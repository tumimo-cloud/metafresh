/*
 * #%L
 * de.metas.externalsystem
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

package de.metas.externalsystem.other.export.project;

import de.metas.externalsystem.export.ExportToExternalSystemService;
import de.metas.externalsystem.other.export.project.budget.ExportBudgetProjectToOtherService;
import org.compiere.SpringContextHolder;

public class C_BudgetProject_SyncTo_Other extends C_Project_SyncTo_Other
{
	private final ExportBudgetProjectToOtherService exportBudgetProjectToOtherService = SpringContextHolder.instance.getBean(ExportBudgetProjectToOtherService.class);

	@Override
	protected ExportToExternalSystemService getExportProjectToExternalSystem()
	{
		return exportBudgetProjectToOtherService;
	}
}
