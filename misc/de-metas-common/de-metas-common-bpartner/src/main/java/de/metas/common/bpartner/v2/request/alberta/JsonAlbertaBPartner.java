/*
 * #%L
 * de-metas-common-bpartner
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

package de.metas.common.bpartner.v2.request.alberta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.annotation.Nullable;
import java.time.Instant;

@Getter
@ToString
@EqualsAndHashCode
public class JsonAlbertaBPartner
{
	@Schema
	@Nullable
	private Boolean isArchived;

	@Schema(hidden = true)
	private boolean archivedSet;

	@Schema
	@Nullable
	private String title;

	@Schema(hidden = true)
	private boolean titleSet;

	@Schema
	@Nullable
	private String titleShort;

	@Schema(hidden = true)
	private boolean titleShortSet;

	@Schema
	@Nullable
	private Instant timestamp;

	@Schema(hidden = true)
	private boolean timestampSet;

	public void setIsArchived(@Nullable final Boolean isArchived)
	{
		this.isArchived = isArchived;
		this.archivedSet = true;
	}

	public void setTitle(@Nullable final String title)
	{
		this.title = title;
		this.titleSet = true;
	}

	public void setTitleShort(@Nullable final String titleShort)
	{
		this.titleShort = titleShort;
		this.titleShortSet = true;
	}

	public void setTimestamp(@Nullable final Instant timestamp)
	{
		this.timestamp = timestamp;
		this.timestampSet = true;
	}
}

