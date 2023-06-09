package de.metas.ui.web.window.datatypes.json;

import com.google.common.collect.ImmutableMap;
import de.metas.ui.web.window.descriptor.LayoutType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;

/*
 * #%L
 * metasfresh-webui-api
 * %%
 * Copyright (C) 2016 metas GmbH
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

@Schema(enumAsRef = true, description = "JSONLayoutType: \n" +
		"* `primary` - Primary layout: it will render the label and beneath the field\n" +
		"* `primaryLongLabels` - Same as <code>primary</code> but will advice the frontend to render long labels. At the moment it's used for filter checkboxes\n" +
		"* `secondary` - It will render the label and the field on same line\n" +
		"")
public enum JSONLayoutType
{
	primary,

	primaryLongLabels,

	secondary;

	public static JSONLayoutType fromNullable(final LayoutType layoutType)
	{
		if (layoutType == null)
		{
			return null;
		}
		final JSONLayoutType jsonLayoutType = layoutType2json.get(layoutType);
		if (jsonLayoutType == null)
		{
			throw new IllegalArgumentException("Cannot convert " + layoutType + " to " + JSONLayoutType.class);
		}
		return jsonLayoutType;
	}

	private static final Map<LayoutType, JSONLayoutType> layoutType2json = ImmutableMap.<LayoutType, JSONLayoutType> builder()
			.put(LayoutType.primary, JSONLayoutType.primary)
			.put(LayoutType.secondary, JSONLayoutType.secondary)
			.build();

}
