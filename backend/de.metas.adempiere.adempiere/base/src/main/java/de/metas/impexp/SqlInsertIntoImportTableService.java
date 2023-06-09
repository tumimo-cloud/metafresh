package de.metas.impexp;

import lombok.NonNull;
import org.springframework.stereotype.Service;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
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

@Service
public class SqlInsertIntoImportTableService implements InsertIntoImportTableService
{

	@Override
	public InsertIntoImportTableResult insertData(@NonNull final InsertIntoImportTableRequest request)
	{
		final SqlInsertIntoImportTableCommand command = SqlInsertIntoImportTableCommand.builder()
				.importFormat(request.getImportFormat())
				.clientId(request.getClientId())
				.orgId(request.getOrgId())
				.userId(request.getUserId())
				.dataImportRunId(request.getDataImportRunId())
				.dataImportConfigId(request.getDataImportConfigId())
				.insertBatchSize(request.getInsertBatchSize())
				.linesStream(request.getStream())
				.overrideColumnValues(request.getOverrideColumnValues())
				.build();

		return command.execute();
	}

}
