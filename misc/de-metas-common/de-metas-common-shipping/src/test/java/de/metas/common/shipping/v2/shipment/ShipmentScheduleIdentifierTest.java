/*
 * #%L
 * de-metas-common-shipping
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

package de.metas.common.shipping.v2.shipment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ShipmentScheduleIdentifierTest
{
	private ObjectMapper objectMapper;

	@BeforeEach
	public void beforeEach()
	{
		objectMapper = newJsonObjectMapper();
	}

	private static ObjectMapper newJsonObjectMapper()
	{
		return new ObjectMapper();
	}

	@Test
	public void test() throws IOException
	{
		final ShipmentScheduleIdentifier request = ShipmentScheduleIdentifier.builder()
				.externalHeaderId("externalHeaderId")
				.externalLineId("externalLineId")
				.build();

		testSerializeDeserialize(request);
	}

	private void testSerializeDeserialize(final Object obj) throws IOException
	{
		System.out.println("Object: " + obj);

		final String json = objectMapper.writeValueAsString(obj);
		System.out.println("Object->JSON: " + json);

		final Object objDeserialized = objectMapper.readValue(json, obj.getClass());
		System.out.println("Object deserialized: " + objDeserialized);
		Assertions.assertThat(objDeserialized).isEqualTo(obj);
	}
}
