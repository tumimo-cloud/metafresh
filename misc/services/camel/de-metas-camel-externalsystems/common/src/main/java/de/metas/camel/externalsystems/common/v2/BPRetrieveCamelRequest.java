/*
 * #%L
 * de-metas-camel-externalsystems-common
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

package de.metas.camel.externalsystems.common.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.metas.common.rest_api.common.JsonMetasfreshId;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import javax.annotation.Nullable;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = BPRetrieveCamelRequest.BPRetrieveCamelRequestBuilder.class)
public class BPRetrieveCamelRequest
{
	@NonNull
	@JsonProperty("bpartnerIdentifier")
	String bPartnerIdentifier;

	@NonNull
	@JsonProperty("externalSystemConfigId")
	JsonMetasfreshId externalSystemConfigId;

	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("adPInstanceId")
	JsonMetasfreshId adPInstanceId;

	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("orgCode")
	String orgCode;

	/**
	 * If {@code true}, then make the metasfresh-API-call with that Http header {@code Cache-Control=no-cache}
	 */
	@JsonProperty("noCache")
	boolean noCache;
}
