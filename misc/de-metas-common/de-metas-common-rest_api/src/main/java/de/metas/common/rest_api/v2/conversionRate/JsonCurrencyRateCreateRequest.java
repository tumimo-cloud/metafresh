/*
 * #%L
 * de-metas-common-rest_api
 * %%
 * Copyright (C) 2023 metas GmbH
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

package de.metas.common.rest_api.v2.conversionRate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.annotation.Nullable;
import java.util.List;

@ApiModel
@Value
@Builder
@Jacksonized
public class JsonCurrencyRateCreateRequest
{
	@ApiModelProperty(position = 10, value = "Translated to `C_ConversionRate.AD_Org_ID")
	@Nullable
	String orgCode;

	@ApiModelProperty(position = 20, value = "Translated to `C_ConversionRate.C_Currency_ID")
	@NonNull
	String currencyCodeFrom;

	@ApiModelProperty(position = 30, dataType = "List of conversion rates")
	@NonNull
	List<JsonCurrencyRateCreateRequestItem> requestItems;
}
