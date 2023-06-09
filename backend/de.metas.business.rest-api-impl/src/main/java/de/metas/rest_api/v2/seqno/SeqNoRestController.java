/*
 * #%L
 * de.metas.business.rest-api-impl
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

package de.metas.rest_api.v2.seqno;

import de.metas.Profiles;
import de.metas.common.rest_api.v2.seqno.JsonSeqNoResponse;
import de.metas.util.web.MetasfreshRestAPIConstants;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static de.metas.common.rest_api.v2.SwaggerDocConstants.AD_SEQ_NO_ID_DOC;

@RestController
@RequestMapping(value = { MetasfreshRestAPIConstants.ENDPOINT_API_V2 + "/seqNo" })
@Profile(Profiles.PROFILE_App)
public class SeqNoRestController
{
	private final SeqNoRestService seqNoRestService;

	public SeqNoRestController(@NonNull final SeqNoRestService seqNoRestService)
	{
		this.seqNoRestService = seqNoRestService;
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "SeqNo for the next AD_SeqNo_ID successfully retrieved"),
			@ApiResponse(responseCode = "401", description = "You are not authorized to invoke seqNo endpoint"),
			@ApiResponse(responseCode = "403", description = "Accessing a related resource is forbidden"),
			@ApiResponse(responseCode = "422", description = "The request could not be processed")
	})
	@GetMapping("/{AD_SeqNo_ID}/next")
	public ResponseEntity<JsonSeqNoResponse> getNextSeqNo(
			@Parameter(required = true, description = AD_SEQ_NO_ID_DOC) //
			@PathVariable("AD_SeqNo_ID") //
			@NonNull final Integer sequenceId
	)
	{
		return ResponseEntity.ok(seqNoRestService.getNextSeqNo(sequenceId));
	}
}
