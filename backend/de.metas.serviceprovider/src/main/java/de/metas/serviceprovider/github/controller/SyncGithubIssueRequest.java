/*
 * #%L
 * de.metas.serviceprovider.base
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

package de.metas.serviceprovider.github.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
public class SyncGithubIssueRequest
{
	public static SyncGithubIssueRequest from(@NonNull final JsonNode githubPayload)
	{
		return SyncGithubIssueRequest.builder()
				.owner(githubPayload.at("/repository/owner/login").asText())
				.repositoryName(githubPayload.at("/repository/name").asText())
				.issueNumber(githubPayload.at("/issue/number").asText())
				.action(githubPayload.at("/action").asText())
				.build();
	}

	@NonNull
	String repositoryName;

	@NonNull
	String owner;

	@NonNull
	String issueNumber;

	@NonNull
	String action;

	@Builder
	private SyncGithubIssueRequest(
			@NonNull final String repositoryName,
			@NonNull final String owner,
			@NonNull final String issueNumber,
			@NonNull final String action)
	{
		this.repositoryName = repositoryName;
		this.owner = owner;
		this.issueNumber = issueNumber;
		this.action = action;
	}

	public boolean isSyncRequired()
	{
		return action.equals(Action.OPENED.getCode());
	}

	@AllArgsConstructor
	@Getter
	public enum Action
	{
		OPENED("opened");

		String code;
	}
}
