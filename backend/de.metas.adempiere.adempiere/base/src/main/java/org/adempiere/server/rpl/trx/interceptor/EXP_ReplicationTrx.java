/*
 * #%L
 * de.metas.adempiere.adempiere.base
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

package org.adempiere.server.rpl.trx.interceptor;

import org.adempiere.ad.modelvalidator.annotations.Interceptor;
import org.adempiere.ad.modelvalidator.annotations.ModelChange;
import org.adempiere.process.rpl.model.I_EXP_ReplicationTrx;
import org.compiere.model.ModelValidator;
import org.springframework.stereotype.Component;

@Component
@Interceptor(I_EXP_ReplicationTrx.class)
public class EXP_ReplicationTrx
{
	@ModelChange(timings = ModelValidator.TYPE_BEFORE_CHANGE,
			ifColumnsChanged = I_EXP_ReplicationTrx.COLUMNNAME_IsError)
	public void resetErrorMessage(final I_EXP_ReplicationTrx record)
	{
		if (record.isError())
		{
			return;
		}

		record.setErrorMsg(null);
	}
}
