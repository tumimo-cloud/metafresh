/*
 * #%L
 * de-metas-common-rest_api
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

package de.metas.common.rest_api.v2.project.workorder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.metas.common.rest_api.common.JsonMetasfreshId;
import de.metas.common.rest_api.v2.JsonResponseUpsertItem;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
public class JsonWorkOrderProjectUpsertResponse
{
	@NonNull
	JsonMetasfreshId projectId;

	@NonNull
	List<JsonWorkOrderStepUpsertResponse> createdStepIds;

	@NonNull
	JsonResponseUpsertItem.SyncOutcome syncOutcome;

	@Builder
	@JsonCreator
	public JsonWorkOrderProjectUpsertResponse(
			@NonNull @JsonProperty("projectId") final JsonMetasfreshId projectId,
			@Singular @JsonProperty("createdStepIds") final List<JsonWorkOrderStepUpsertResponse> createdStepIds,
			@NonNull @JsonProperty("syncOutcome") final JsonResponseUpsertItem.SyncOutcome syncOutcome
	)
	{
		this.projectId = projectId;
		this.createdStepIds = createdStepIds;
		this.syncOutcome = syncOutcome;
	}
}
