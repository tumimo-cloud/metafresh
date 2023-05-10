/*
 * #%L
 * de-metas-common-pricing
 * %%
 * Copyright (C) 2022 metas GmbH
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

package de.metas.common.pricing.v2.productprice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.metas.common.rest_api.common.JsonMetasfreshId;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.Instant;
import java.util.List;

@Builder
@Value
@JsonDeserialize(builder = JsonPriceListVersionResponse.JsonPriceListVersionResponseBuilder.class)
public class JsonPriceListVersionResponse
{
	@NonNull
	@JsonProperty("metasfreshId")
	JsonMetasfreshId metasfreshId;

	@NonNull
	@JsonProperty("name")
	String name;

	@NonNull
	@JsonProperty("validFrom")
	Instant validFrom;

	@NonNull
	@JsonProperty("prices")
	List<JsonResponsePrice> jsonResponsePrices;
}
