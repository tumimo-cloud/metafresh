/*
 * #%L
 * de.metas.business.rest-api
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

package de.metas.common.bprelation.request;

import au.com.origin.snapshots.Expect;
import au.com.origin.snapshots.junit5.SnapshotExtension;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.metas.common.bprelation.JsonBPRelationRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SnapshotExtension.class)
public class JsonRequestBPRelationUpsertTest
{
	private final ObjectMapper mapper = new ObjectMapper();
	private Expect expect;

	@Test
	public void serializeDeserialize() throws IOException
	{
		final JsonRequestBPRelationsUpsert item = JsonRequestBPRelationsUpsert.builder()
				.orgCode("org123")
				.locationIdentifier("loc123")
				.relatesTo(Collections.singletonList(JsonRequestBPRelationTarget.builder()
						.targetBpartnerIdentifier("targetBP123")
						.targetLocationIdentifier("targetLoc123")
						.name("relName")
						.description("relDesc")
						.externalId("ext123")
						.billTo(true)
						.shipTo(true)
						.fetchedFrom(true)
						.handOverLocation(true)
						.role(JsonBPRelationRole.Caregiver)
						.payFrom(true)
						.remitTo(true)
						.active(true)
						.build()))
				.build();

		final String string = mapper.writeValueAsString(item);
		assertThat(string).isNotEmpty();

		final JsonRequestBPRelationsUpsert result = mapper.readValue(string, JsonRequestBPRelationsUpsert.class);

		assertThat(result).isEqualTo(item);
		expect.serializer("orderedJson").toMatchSnapshot(result);
	}
}
