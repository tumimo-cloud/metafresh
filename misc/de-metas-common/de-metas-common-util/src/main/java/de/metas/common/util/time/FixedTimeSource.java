package de.metas.common.util.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/*
 * #%L
 * de-metas-common-util
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

@EqualsAndHashCode
@ToString
class FixedTimeSource implements TimeSource
{
	public static FixedTimeSource ofZonedDateTime(final ZonedDateTime zonedDateTime)
	{
		return new FixedTimeSource(zonedDateTime);
	}

	private final ZonedDateTime date;

	private FixedTimeSource(@NonNull final ZonedDateTime date)
	{
		this.date = date.truncatedTo(ChronoUnit.MILLIS);
	}

	@Override
	public long millis()
	{
		return date.toInstant().toEpochMilli();
	}

	@Override
	public ZoneId zoneId()
	{
		return date.getZone();
	}
}
