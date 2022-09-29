/*
 * #%L
 * de.metas.ui.web.base
 * %%
 * Copyright (C) 2022 metas GmbH
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

package de.metas.ui.web.window.descriptor.decorator;

import de.metas.externalreference.ExternalReference;
import de.metas.externalreference.ExternalReferenceRepository;
import de.metas.ui.web.window.model.Document;
import lombok.NonNull;
import org.adempiere.util.lang.impl.TableRecordReference;
import org.springframework.stereotype.Service;

@Service
public class ExternallyReferencedDocumentDecorator implements IDocumentDecorator
{
	private final ExternalReferenceRepository externalReferenceRepository;

	public ExternallyReferencedDocumentDecorator(@NonNull final ExternalReferenceRepository externalReferenceRepository)
	{
		this.externalReferenceRepository = externalReferenceRepository;
	}

	@Override
	public boolean isReadOnly(final Document document)
	{
		final TableRecordReference recordReference = document.getTableRecordReference().orElse(null);

		if (recordReference == null)
		{
			return false;
		}

		return externalReferenceRepository.getExternalReferencesByTableRecordReference(recordReference)
				.stream()
				.anyMatch(ExternalReference::getIsReadOnlyInMetasfresh);
	}
}
