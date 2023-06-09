/*
 * #%L
 * de.metas.business
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

package de.metas.bpartner.blockstatus;

import de.metas.util.lang.ReferenceListAwareEnum;
import de.metas.util.lang.ReferenceListAwareEnums;
import lombok.Getter;
import lombok.NonNull;
import org.compiere.model.X_C_BPartner_BlockStatus;

public enum BlockStatus implements ReferenceListAwareEnum
{
	Blocked(X_C_BPartner_BlockStatus.BLOCKSTATUS_Blocked),
	Unblocked(X_C_BPartner_BlockStatus.BLOCKSTATUS_Unblocked);

	@Getter
	private final String code;

	BlockStatus(@NonNull final String code)
	{
		this.code = code;
	}

	@NonNull
	public static BlockStatus ofCode(@NonNull final String code)
	{
		return index.ofCode(code);
	}
	
	public boolean isInactivateBPartner()
	{
		return this == Blocked;
	}
	
	public boolean isActivateBPartner()
	{
		return this == Unblocked;
	}
	
	public boolean isBlocked()
	{
		return this == Blocked;
	}
	
	private static final ReferenceListAwareEnums.ValuesIndex<BlockStatus> index = ReferenceListAwareEnums.index(values());
}
