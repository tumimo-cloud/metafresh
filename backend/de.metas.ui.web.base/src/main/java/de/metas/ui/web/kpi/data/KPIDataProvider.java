/*
 * #%L
 * de.metas.ui.web.base
 * %%
 * Copyright (C) 2021 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package de.metas.ui.web.kpi.data;

import de.metas.common.util.time.SystemTime;
import de.metas.elasticsearch.IESSystem;
import de.metas.i18n.AdMessageKey;
import de.metas.i18n.BooleanWithReason;
import de.metas.i18n.ExplainedOptional;
import de.metas.i18n.ITranslatableString;
import de.metas.i18n.TranslatableStrings;
import de.metas.logging.LogManager;
import de.metas.ui.web.kpi.KPITimeRangeDefaults;
import de.metas.ui.web.kpi.TimeRange;
import de.metas.ui.web.kpi.descriptor.KPI;
import de.metas.ui.web.kpi.descriptor.KPIDatasourceType;
import de.metas.ui.web.kpi.descriptor.KPIId;
import de.metas.ui.web.kpi.descriptor.KPIRepository;
import de.metas.util.lang.Percent;
import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.service.ISysConfigBL;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class KPIDataProvider
{
	public static final AdMessageKey MSG_FailedLoadingKPI = AdMessageKey.of("webui.dashboard.KPILoadError");

	private static final Logger logger = LogManager.getLogger(KPIDataProvider.class);
	private final IESSystem esSystem;
	private final KPIRepository kpiRepository;

	private final ConcurrentHashMap<KPIDataCacheKey, KPIDataCacheValue> cache = new ConcurrentHashMap<>();
	private final Random random = new Random();

	private static final String SYSCONFIG_CacheCleanupHitRate = "webui.kpi.cacheCleanupHitRate";
	private static final Percent DEFAULT_CacheCleanupHitRate = Percent.of(20);
	private final Percent cacheCleanupHitRate;

	@Builder
	private KPIDataProvider(
			@NonNull final KPIRepository kpiRepository,
			@NonNull final IESSystem esSystem,
			@NonNull final ISysConfigBL sysConfigBL)
	{
		this.esSystem = esSystem;
		this.kpiRepository = kpiRepository;

		this.cacheCleanupHitRate = getCacheCleanupHitRate(sysConfigBL);
		logger.info("cacheCleanupHitRate={}", cacheCleanupHitRate);
	}

	private static Percent getCacheCleanupHitRate(final ISysConfigBL sysConfigBL)
	{
		final int rateInt = sysConfigBL.getIntValue(SYSCONFIG_CacheCleanupHitRate, -1);
		if (rateInt <= 0)
		{
			return DEFAULT_CacheCleanupHitRate;
		}
		else if (rateInt > 100)
		{
			return Percent.ONE_HUNDRED;
		}
		else
		{
			return Percent.of(rateInt);
		}
	}

	public ExplainedOptional<KPIDataResult> getKPIData(@NonNull final KPIDataRequest request)
	{
		if (isCacheCleanupRandomHit())
		{
			cleanupCacheNow();
		}

		final Duration maxStaleAccepted = request.getMaxStaleAccepted();
		final KPIDataCacheValue cacheValue = cache.compute(
				extractCacheKey(request),
				(cacheKey, existingCacheValue) -> computeCacheValueIfNeeded(cacheKey, existingCacheValue, maxStaleAccepted));

		return cacheValue.toExplainedOptional();
	}

	private KPIDataCacheKey extractCacheKey(@NonNull final KPIDataRequest request)
	{
		final KPI kpi = kpiRepository.getKPI(request.getKpiId());
		final KPIDataContext contextReduced = request.getContext()
				.retainOnlyRequiredParameters(kpi.getRequiredContextParameters());

		return KPIDataCacheKey.builder()
				.kpiId(request.getKpiId())
				.timeRangeDefaults(request.getTimeRangeDefaults())
				.context(contextReduced)
				.build();
	}

	private KPIDataCacheValue computeCacheValueIfNeeded(
			@NonNull final KPIDataCacheKey cacheKey,
			@Nullable final KPIDataCacheValue existingValue,
			@Nullable final Duration maxStaleAccepted)
	{
		logger.trace("computeCacheValueIfNeeded: cacheKey={}, maxStaleAccepted={}, existingValue={}", cacheKey, maxStaleAccepted, existingValue);

		if (existingValue == null)
		{
			logger.trace("computeCacheValueIfNeeded: no existingValue. Computing and returning a new value");
			return computeCacheValue(cacheKey);
		}
		else if (existingValue.isExpired(maxStaleAccepted))
		{
			logger.trace("computeCacheValueIfNeeded: existingValue expired. Computing and returning a new value");
			return computeCacheValue(cacheKey);
		}
		else
		{
			logger.trace("computeCacheValueIfNeeded: existingValue is still valid. Returning it.");
			return existingValue;
		}
	}

	private KPIDataCacheValue computeCacheValue(@NonNull final KPIDataCacheKey cacheKey)
	{
		final KPIDataContext context = cacheKey.getContext();
		final KPITimeRangeDefaults timeRangeDefaults = cacheKey.getTimeRangeDefaults();
		final TimeRange timeRange = timeRangeDefaults.createTimeRange(context.getFrom(), context.getTo());
		final KPI kpi = kpiRepository.getKPI(cacheKey.getKpiId());
		final Duration defaultMaxStaleAccepted = kpi.getAllowedStaleDuration();

		try
		{
			final KPIDatasourceType dataSourceType = kpi.getDatasourceType();
			if (dataSourceType == KPIDatasourceType.ELASTICSEARCH)
			{
				final BooleanWithReason elasticsearchEnabled = esSystem.getEnabled();
				if (elasticsearchEnabled.isTrue())
				{
					final KPIDataResult data = ElasticsearchKPIDataLoader.newInstance(esSystem.elasticsearchClient(), kpi)
							.setTimeRange(timeRange)
							.retrieveData();
					return KPIDataCacheValue.ok(data, defaultMaxStaleAccepted);
				}
				else
				{
					return KPIDataCacheValue.error(elasticsearchEnabled.getReason(), defaultMaxStaleAccepted);
				}
			}
			else if (dataSourceType == KPIDatasourceType.SQL)
			{
				final KPIDataResult data = SQLKPIDataLoader.builder()
						.kpi(kpi)
						.timeRange(timeRange)
						.context(context)
						.build()
						.retrieveData();
				return KPIDataCacheValue.ok(data, defaultMaxStaleAccepted);
			}
			else
			{
				// shall not happen
				throw new AdempiereException("Unknown KPI's data source type: " + dataSourceType)
						.setParameter("kpi", kpi);
			}
		}
		catch (final Exception ex)
		{
			logger.warn("Failed computing KPI for {}. Returning error.", cacheKey, ex);

			final ITranslatableString errorMessage = AdempiereException.isUserValidationError(ex)
					? AdempiereException.extractMessageTrl(ex)
					: TranslatableStrings.adMessage(MSG_FailedLoadingKPI);

			return KPIDataCacheValue.error(errorMessage, defaultMaxStaleAccepted);
		}
	}

	private boolean isCacheCleanupRandomHit()
	{
		final int randomValue = random.nextInt(100);
		return randomValue <= cacheCleanupHitRate.toInt();
	}

	private void cleanupCacheNow()
	{
		logger.trace("cacheCleanupNow: {} entries before cleanup", cache.size());

		cache.values().removeIf(cacheValue -> cacheValue.isExpired());

		logger.trace("cacheCleanupNow: {} entries after cleanup", cache.size());
	}

	public Optional<KPIZoomIntoDetailsInfo> getZoomIntoDetailsInfo(@NonNull final KPIDataRequest request)
	{
		final KPIDataContext context = request.getContext();
		final KPITimeRangeDefaults timeRangeDefaults = request.getTimeRangeDefaults();
		final TimeRange timeRange = timeRangeDefaults.createTimeRange(context.getFrom(), context.getTo());
		final KPI kpi = kpiRepository.getKPI(request.getKpiId());

		final KPIDatasourceType dataSourceType = kpi.getDatasourceType();
		if (dataSourceType == KPIDatasourceType.SQL)
		{
			return Optional.of(
					SQLKPIDataLoader.builder()
							.kpi(kpi)
							.timeRange(timeRange)
							.context(context)
							.build()
							.getKPIZoomIntoDetailsInfo());
		}
		else
		{
			return Optional.empty();
		}
	}

	//
	//
	// -----------------------------------------
	//
	//

	@Value
	@Builder
	private static class KPIDataCacheKey
	{
		@NonNull KPIId kpiId;
		@NonNull KPITimeRangeDefaults timeRangeDefaults;
		@NonNull KPIDataContext context;
	}

	@Value
	@ToString(exclude = "data" /* because it's too big */)
	private static class KPIDataCacheValue
	{
		public static KPIDataCacheValue ok(@NonNull final KPIDataResult data, @NonNull final Duration defaultMaxStaleAccepted)
		{
			return new KPIDataCacheValue(data, defaultMaxStaleAccepted);
		}

		public static KPIDataCacheValue error(@Nullable final ITranslatableString errorMessage, @NonNull final Duration defaultMaxStaleAccepted)
		{
			return new KPIDataCacheValue(errorMessage, defaultMaxStaleAccepted);
		}

		public static KPIDataCacheValue error(@NonNull final Exception exception, @NonNull final Duration defaultMaxStaleAccepted)
		{
			return new KPIDataCacheValue(AdempiereException.extractMessageTrl(exception), defaultMaxStaleAccepted);
		}

		@NonNull Instant created = SystemTime.asInstant();
		@NonNull Duration defaultMaxStaleAccepted;

		KPIDataResult data;

		boolean error;
		ITranslatableString errorMessage;

		public KPIDataCacheValue(@NonNull final KPIDataResult data, @NonNull final Duration defaultMaxStaleAccepted)
		{
			this.data = data;
			this.error = false;
			this.errorMessage = null;
			this.defaultMaxStaleAccepted = defaultMaxStaleAccepted;
		}

		public KPIDataCacheValue(@Nullable final ITranslatableString errorMessage, @NonNull final Duration defaultMaxStaleAccepted)
		{
			this.data = null;
			this.error = true;
			this.errorMessage = errorMessage != null ? errorMessage : TranslatableStrings.anyLanguage("Unknown internal error");
			this.defaultMaxStaleAccepted = defaultMaxStaleAccepted;
		}

		public boolean isExpired()
		{
			return isExpired(null);
		}

		public boolean isExpired(@Nullable final Duration maxStaleAccepted)
		{
			final Duration maxStaleAcceptedEffective = maxStaleAccepted != null
					? maxStaleAccepted
					: defaultMaxStaleAccepted;

			final Instant now = SystemTime.asInstant();
			final Duration staleActual = Duration.between(created, now);
			final boolean expired = staleActual.compareTo(maxStaleAcceptedEffective) > 0;
			logger.trace("isExpired={}, now={}, maxStaleAcceptedEffective={}, staleActual={}, cacheValue={}", expired, now, maxStaleAcceptedEffective, staleActual, this);
			return expired;
		}

		public ExplainedOptional<KPIDataResult> toExplainedOptional()
		{
			return !error
					? ExplainedOptional.of(data)
					: ExplainedOptional.emptyBecause(errorMessage);
		}
	}
}
