/*
 * #%L
 * de.metas.deliveryplanning.base
 * %%
 * Copyright (C) 2023 metas GmbH
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

package de.metas.deliveryplanning;

import de.metas.deliveryplanning.impexp.process.DeliveryPlanningImportProcess;
import de.metas.impexp.processing.IImportProcessFactory;
import de.metas.util.Services;
import org.adempiere.ad.modelvalidator.AbstractModuleInterceptor;
import org.compiere.model.I_I_DeliveryPlanning;
import org.springframework.stereotype.Component;

/**
 * Module activator
 */
@Component
public class Main extends AbstractModuleInterceptor
{
	@Override
	protected void onAfterInit()
	{
		Services.get(IImportProcessFactory.class).registerImportProcess(I_I_DeliveryPlanning.class, DeliveryPlanningImportProcess.class);
	}

}
