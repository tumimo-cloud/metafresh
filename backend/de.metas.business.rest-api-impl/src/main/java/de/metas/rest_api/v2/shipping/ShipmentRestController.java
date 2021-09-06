/*
 * #%L
 * de.metas.business.rest-api-impl
 * %%
 * Copyright (C) 2020 metas GmbH
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

package de.metas.rest_api.v2.shipping;

import com.google.common.collect.ImmutableList;
import de.metas.Profiles;
import de.metas.async.QueueWorkPackageId;
import de.metas.common.rest_api.common.JsonMetasfreshId;
import de.metas.common.shipping.v2.shipment.JsonCreateShipmentRequest;
import de.metas.common.shipping.v2.shipment.JsonCreateShipmentResponse;
import de.metas.common.shipping.v2.shipment.mpackage.JsonCreateShippingPackagesRequest;
import de.metas.handlingunits.shipmentschedule.api.ShipmentScheduleEnqueuer;
import de.metas.logging.LogManager;
import de.metas.rest_api.utils.JsonErrors;
import de.metas.rest_api.v2.shipping.mpackage.ShippingPackageService;
import de.metas.util.Loggables;
import de.metas.util.Services;
import de.metas.util.web.MetasfreshRestAPIConstants;
import lombok.NonNull;
import org.adempiere.ad.trx.api.ITrxManager;
import org.compiere.util.Env;
import org.slf4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = { MetasfreshRestAPIConstants.ENDPOINT_API_V2 + "/shipments" })
@RestController
@Profile(Profiles.PROFILE_App)
public class ShipmentRestController
{
	private static final Logger log = LogManager.getLogger(ShipmentRestController.class);

	private final ITrxManager trxManager = Services.get(ITrxManager.class);

	private final de.metas.rest_api.v2.shipping.ShipmentService shipmentService;
	private final de.metas.rest_api.v2.shipping.mpackage.ShippingPackageService shippingPackageService;

	public ShipmentRestController(@NonNull final ShipmentService shipmentService, final ShippingPackageService shippingPackageService)
	{
		this.shipmentService = shipmentService;
		this.shippingPackageService = shippingPackageService;
	}

	@PostMapping
	public ResponseEntity<?> createShipments(@RequestBody final JsonCreateShipmentRequest request)
	{
		log.debug("*** createShipments: Started with request: {}", request);

		try
		{
			final ShipmentScheduleEnqueuer.Result result = shipmentService.updateShipmentSchedulesAndGenerateShipments(request);

			final ImmutableList<JsonMetasfreshId> workPackageIds = extractWorkpackageIds(result);
			final JsonCreateShipmentResponse jsonCreateShipmentResponse = JsonCreateShipmentResponse
					.builder()
					.createdAsyncWorkpackageIdList(workPackageIds)
					.build();

			log.debug("*** createShipments: Execution done! Created workPackage ids: {}", workPackageIds);

			return ResponseEntity.ok(jsonCreateShipmentResponse);
		}
		catch (final Exception ex)
		{
			Loggables.addLog(ex.getMessage(), ex);

			log.error(ex.getMessage(), ex);

			final String adLanguage = Env.getADLanguageOrBaseLanguage();
			return ResponseEntity.badRequest()
					.body(JsonErrors.ofThrowable(ex, adLanguage));
		}
	}

	@PostMapping("/packages")
	public ResponseEntity<?> createShippingPackages(@RequestBody final JsonCreateShippingPackagesRequest request)
	{
		log.debug("*** createShippingPackages: Started with request: {}", request);

		try
		{
			trxManager.runInNewTrx(() -> shippingPackageService.generateShippingPackages(request));

			log.debug("*** createShippingPackages: Execution done!");

			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (final Exception ex)
		{
			log.error(ex.getMessage(), ex);

			final String adLanguage = Env.getADLanguageOrBaseLanguage();
			return ResponseEntity.badRequest()
					.body(JsonErrors.ofThrowable(ex, adLanguage));
		}
	}

	private static ImmutableList<JsonMetasfreshId> extractWorkpackageIds(@NonNull final ShipmentScheduleEnqueuer.Result result)
	{
		return result.getEnqueuedPackageIds()
				.stream()
				.map(QueueWorkPackageId::getRepoId)
				.map(JsonMetasfreshId::of)
				.collect(ImmutableList.toImmutableList());
	}
}
