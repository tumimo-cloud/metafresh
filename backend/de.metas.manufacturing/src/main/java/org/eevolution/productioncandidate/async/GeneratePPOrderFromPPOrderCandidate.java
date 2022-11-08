/*
 * #%L
 * de.metas.manufacturing
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

package org.eevolution.productioncandidate.async;

import com.google.common.collect.ImmutableList;
import de.metas.async.model.I_C_Queue_WorkPackage;
import de.metas.async.spi.WorkpackageProcessorAdapter;
import de.metas.process.PInstanceId;
import de.metas.util.Check;
import de.metas.util.Loggables;
import lombok.NonNull;
import org.adempiere.util.api.IParams;
import org.compiere.SpringContextHolder;
import org.eevolution.model.I_PP_Order_Candidate;
import org.eevolution.productioncandidate.service.PPOrderCandidateProcessRequest;
import org.eevolution.productioncandidate.service.PPOrderCandidateService;
import org.eevolution.productioncandidate.service.produce.PPOrderCandidateToAllocate;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.eevolution.productioncandidate.async.PPOrderCandidateEnqueuer.WP_AUTO_PROCESS_CANDIDATES_AFTER_PRODUCTION;
import static org.eevolution.productioncandidate.async.PPOrderCandidateEnqueuer.WP_COMPLETE_DOC_PARAM;
import static org.eevolution.productioncandidate.async.PPOrderCandidateEnqueuer.WP_PINSTANCE_ID_PARAM;

public class GeneratePPOrderFromPPOrderCandidate extends WorkpackageProcessorAdapter
{
	private final PPOrderCandidateService ppOrderCandidateService = SpringContextHolder.instance.getBean(PPOrderCandidateService.class);

	@Override
	public Result processWorkPackage(@NonNull final I_C_Queue_WorkPackage workPackage, @Nullable final String localTrxName)
	{
		final PPOrderCandidateProcessRequest ppOrderCandidateProcessRequest = getProcessPPOrderCandRequest();

		final OrderGenerateResult result = ppOrderCandidateService.processCandidates(ppOrderCandidateProcessRequest);

		Loggables.addLog("Generated: {}", result);

		return Result.SUCCESS;
	}

	@NonNull
	private PPOrderCandidateProcessRequest getProcessPPOrderCandRequest()
	{
		final IParams params = getParameters();

		final PInstanceId pInstanceId = params.getParameterAsId(WP_PINSTANCE_ID_PARAM, PInstanceId.class);
		final boolean isDocComplete = params.getParameterAsBool(WP_COMPLETE_DOC_PARAM);
		final boolean autoProcessCandidatesAfterProduction = params.getParameterAsBool(WP_AUTO_PROCESS_CANDIDATES_AFTER_PRODUCTION);

		Check.assumeNotNull(pInstanceId, "adPInstanceId is not null");

		final Iterator<I_PP_Order_Candidate> orderCandidates = ppOrderCandidateService.retrieveOCForSelection(pInstanceId);

		final Stream<I_PP_Order_Candidate> candidateStream = StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(orderCandidates, Spliterator.ORDERED), false);

		return PPOrderCandidateProcessRequest.builder()
				.isDocComplete(isDocComplete)
				.autoProcessCandidatesAfterProduction(autoProcessCandidatesAfterProduction)
				.sortedCandidates(getSortedCandidates(candidateStream))
				.build();
	}

	@NonNull
	private ImmutableList<PPOrderCandidateToAllocate> getSortedCandidates(@NonNull final Stream<I_PP_Order_Candidate> candidateStream)
	{
		return candidateStream.filter(orderCandidate -> !orderCandidate.isProcessed())
				.map(PPOrderCandidateToAllocate::of)
				.sorted(Comparator.comparing(PPOrderCandidateToAllocate::getHeaderAggregationKey))
				.collect(ImmutableList.toImmutableList());
	}
}