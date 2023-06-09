package de.metas.ui.web.process;

import org.adempiere.ad.expression.api.LogicExpressionResult;

import de.metas.ui.web.process.adprocess.device_providers.DeviceDescriptorsList;
import de.metas.ui.web.window.datatypes.json.JSONOptions;
import de.metas.ui.web.window.descriptor.DocumentFieldWidgetType;
import de.metas.ui.web.window.model.DocumentValidStatus;

import java.util.OptionalInt;

/*
 * #%L
 * metasfresh-webui-api
 * %%
 * Copyright (C) 2018 metas GmbH
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

public interface IProcessInstanceParameter
{
	String getParameterName();

	DocumentFieldWidgetType getWidgetType();

	OptionalInt getMinPrecision();

	Object getValueAsJsonObject(JSONOptions jsonOpts);

	LogicExpressionResult getReadonly();

	LogicExpressionResult getMandatory();

	LogicExpressionResult getDisplayed();

	DocumentValidStatus getValidStatus();

	DeviceDescriptorsList getDevices();
}
