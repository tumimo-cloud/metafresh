package org.adempiere.ad.table.api.impl;

import static org.adempiere.model.InterfaceWrapperHelper.getTableId;
import static org.adempiere.model.InterfaceWrapperHelper.newInstance;
import static org.adempiere.model.InterfaceWrapperHelper.save;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.List;
import java.util.Set;

import org.adempiere.ad.table.TableRecordIdDescriptor;
import org.adempiere.ad.table.api.AdTableId;
import org.adempiere.ad.table.api.IADTableDAO;
import org.adempiere.model.InterfaceWrapperHelper;
import org.adempiere.test.AdempiereTestHelper;
import org.compiere.model.I_AD_ChangeLog;
import org.compiere.model.I_AD_Column;
import org.compiere.model.I_AD_Element;
import org.compiere.model.I_AD_Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.google.common.collect.ImmutableSet;

import de.metas.util.Services;
import lombok.NonNull;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
 * %%
 * Copyright (C) 2017 metas GmbH
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

public class TableRecordIdDAO_Test
{
	@BeforeEach
	public void init()
	{
		AdempiereTestHelper.get().init();
	}

	@Test
	public void recordDescriptor_ChangeLog_Record_ID()
	{
		final IADTableDAO adTableDAO = Services.get(IADTableDAO.class);

		final I_AD_Field referencedField = newInstance(I_AD_Field.class);
		save(referencedField);
		final AdTableId adfieldTableID = AdTableId.ofRepoId(adTableDAO.retrieveTableId(I_AD_Field.Table_Name));

		final Mocked_I_AD_ChangeLog referencingChangeLog = newInstance(Mocked_I_AD_ChangeLog.class);

		referencingChangeLog.setAD_Table_ID(adfieldTableID.getRepoId());
		referencingChangeLog.setRecord_ID(referencedField.getAD_Field_ID());
		save(referencingChangeLog);

		final int adChangeLogTableID = getTableId(I_AD_ChangeLog.class);

		// for the unit test need to explicitly create AD_Column records for the two AD_Changelog properties
		{
			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_Record_ID);

			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Table_ID);

		}

		final String tableName = "AD_ChangeLog";

		final TableRecordIdDAO instanceUnderTest = setupTableRecordDaoWithDistinctIDs(ImmutableSet.of(adfieldTableID));
		final List<TableRecordIdDescriptor> tableRecordReferences = instanceUnderTest.getTableRecordIdReferences(tableName);

		assertThat(tableRecordReferences.size()).isEqualTo(1);

		final TableRecordIdDescriptor expectedactualTableRecordIdDescriptor = createTableRecordIdDescriptor("AD_ChangeLog", Mocked_I_AD_ChangeLog.COLUMNNAME_Record_ID, "AD_Field");

		assertThat(equalsTableRecordIdDescriptor(expectedactualTableRecordIdDescriptor, tableRecordReferences.get(0))).isTrue();
	}

	@Test
	public void recordDescriptor_ChangeLog_PrefixRecordId()
	{
		final IADTableDAO adTableDAO = Services.get(IADTableDAO.class);

		final I_AD_Field referencedField = newInstance(I_AD_Field.class);
		save(referencedField);
		final AdTableId adfieldTableID = AdTableId.ofRepoId(adTableDAO.retrieveTableId(I_AD_Field.Table_Name));

		final Mocked_I_AD_ChangeLog referencingChangeLog = newInstance(Mocked_I_AD_ChangeLog.class);
		referencingChangeLog.setAD_Field_AD_Table_ID(adfieldTableID.getRepoId());
		referencingChangeLog.setAD_Field_Record_ID(referencedField.getAD_Field_ID());
		save(referencingChangeLog);

		final int adChangeLogTableID = getTableId(I_AD_ChangeLog.class);

		// for the unit test need to explicitly create AD_Column records for the two AD_Changelog properties
		{
			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Field_Record_ID);

			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Field_AD_Table_ID);

		}
		final String tableName = "AD_ChangeLog";

		final TableRecordIdDAO instanceUnderTest = setupTableRecordDaoWithDistinctIDs(ImmutableSet.of(adfieldTableID));
		final List<TableRecordIdDescriptor> tableRecordReferences = instanceUnderTest.getTableRecordIdReferences(tableName);

		assertThat(tableRecordReferences.size()).isEqualTo(1);

		final TableRecordIdDescriptor expectedactualTableRecordIdDescriptor = createTableRecordIdDescriptor("AD_ChangeLog", Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Field_Record_ID, "AD_Field");

		assertThat(equalsTableRecordIdDescriptor(expectedactualTableRecordIdDescriptor, tableRecordReferences.get(0))).isTrue();

	}

	@Test
	public void recordDescriptor_ChangeLog_RecordId_And_Prefix_RecordId()
	{
		final IADTableDAO adTableDAO = Services.get(IADTableDAO.class);

		final I_AD_Field referencedField = newInstance(I_AD_Field.class);
		save(referencedField);
		final AdTableId adfieldTableID = AdTableId.ofRepoId(adTableDAO.retrieveTableId(I_AD_Field.Table_Name));

		final Mocked_I_AD_ChangeLog originChangeLog = newInstance(Mocked_I_AD_ChangeLog.class);

		originChangeLog.setAD_Table_ID(adfieldTableID.getRepoId());
		originChangeLog.setRecord_ID(referencedField.getAD_Field_ID());
		originChangeLog.setAD_Field_AD_Table_ID(adfieldTableID.getRepoId());
		originChangeLog.setAD_Field_Record_ID(referencedField.getAD_Field_ID());
		save(originChangeLog);

		final int adChangeLogTableID = getTableId(I_AD_ChangeLog.class);

		// for the unit test need to explicitly create AD_Column records for the two AD_Changelog properties
		{
			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_Record_ID);

			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Table_ID);

			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Field_Record_ID);

			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Field_AD_Table_ID);

		}
		final String tableName = "AD_ChangeLog";

		final TableRecordIdDAO instanceUnderTest = setupTableRecordDaoWithDistinctIDs(ImmutableSet.of(adfieldTableID));
		final List<TableRecordIdDescriptor> tableRecordReferences = instanceUnderTest.getTableRecordIdReferences(tableName);

		final TableRecordIdDescriptor expectedactualTableRecordIdDescriptor_Record_ID = createTableRecordIdDescriptor("AD_ChangeLog", Mocked_I_AD_ChangeLog.COLUMNNAME_Record_ID, "AD_Field");
		final TableRecordIdDescriptor expectedactualTableRecordIdDescriptor_Prefix_Record_ID = createTableRecordIdDescriptor("AD_ChangeLog", Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Field_Record_ID, "AD_Field");

		assertThat(tableRecordReferences.size()).isEqualTo(2);

		assertThat(containsTableRecordReferences(tableRecordReferences, expectedactualTableRecordIdDescriptor_Record_ID)).isTrue();
		assertThat(containsTableRecordReferences(tableRecordReferences, expectedactualTableRecordIdDescriptor_Prefix_Record_ID)).isTrue();

	}

	@Test
	public void recordDescriptor_All_TableRecordIdDescriptors()
	{
		final IADTableDAO adTableDAO = Services.get(IADTableDAO.class);

		final I_AD_Field referencedField = newInstance(I_AD_Field.class);
		save(referencedField);
		final AdTableId adfieldTableID = AdTableId.ofRepoId(adTableDAO.retrieveTableId(I_AD_Field.Table_Name));

		final Mocked_I_AD_ChangeLog referencingChangeLog = newInstance(Mocked_I_AD_ChangeLog.class);

		referencingChangeLog.setAD_Table_ID(adfieldTableID.getRepoId());
		referencingChangeLog.setRecord_ID(referencedField.getAD_Field_ID());
		referencingChangeLog.setAD_Field_AD_Table_ID(adfieldTableID.getRepoId());
		referencingChangeLog.setAD_Field_Record_ID(referencedField.getAD_Field_ID());
		save(referencingChangeLog);

		final int adChangeLogTableID = getTableId(I_AD_ChangeLog.class);

		// for the unit test need to explicitly create AD_Column records for the two AD_Changelog properties
		{
			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_Record_ID);

			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Table_ID);

			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Field_Record_ID);

			createColumn(adChangeLogTableID, Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Field_AD_Table_ID);
		}

		final TableRecordIdDAO instanceUnderTest = setupTableRecordDaoWithDistinctIDs(ImmutableSet.of(adfieldTableID));
		final List<TableRecordIdDescriptor> tableRecordIdDescriptors = instanceUnderTest.retrieveAllTableRecordIdReferences();

		final TableRecordIdDescriptor expectedactualTableRecordIdDescriptor_Record_ID = createTableRecordIdDescriptor("AD_ChangeLog", Mocked_I_AD_ChangeLog.COLUMNNAME_Record_ID, "AD_Field");
		final TableRecordIdDescriptor expectedactualTableRecordIdDescriptor_Prefix_Record_ID = createTableRecordIdDescriptor("AD_ChangeLog", Mocked_I_AD_ChangeLog.COLUMNNAME_AD_Field_Record_ID, "AD_Field");

		assertThat(tableRecordIdDescriptors.size()).isEqualTo(2);

		assertThat(containsTableRecordReferences(tableRecordIdDescriptors, expectedactualTableRecordIdDescriptor_Record_ID)).isTrue();
		assertThat(containsTableRecordReferences(tableRecordIdDescriptors, expectedactualTableRecordIdDescriptor_Prefix_Record_ID)).isTrue();

	}

	private I_AD_Column createColumn(final int tableId, final String columnName)
	{
		final I_AD_Column column = newInstance(I_AD_Column.class);
		column.setIsActive(true);
		column.setAD_Table_ID(tableId);
		column.setColumnName(columnName);
		save(column);
		return column;
	}

	public TableRecordIdDescriptor createTableRecordIdDescriptor(final String originTableName, final String recordIdColumnName, final String targetTableName)
	{
		final TableRecordIdDescriptor tableRecordIdDescriptor = TableRecordIdDescriptor.of(originTableName, recordIdColumnName, targetTableName);

		return tableRecordIdDescriptor;

	}

	public boolean equalsTableRecordIdDescriptor(@NonNull final TableRecordIdDescriptor expectedTableRecordIdDescriptor, @NonNull final TableRecordIdDescriptor actualTableRecordIdDescriptor)
	{
		return expectedTableRecordIdDescriptor.getOriginTableName().equals(actualTableRecordIdDescriptor.getOriginTableName())
				&& expectedTableRecordIdDescriptor.getRecordIdColumnName().equals(actualTableRecordIdDescriptor.getRecordIdColumnName())
				&& expectedTableRecordIdDescriptor.getTargetTableName().equals(actualTableRecordIdDescriptor.getTargetTableName());

	}

	private boolean containsTableRecordReferences(final List<TableRecordIdDescriptor> tableRecordIdDescriptors, final TableRecordIdDescriptor expectedactualTableRecordIdDescriptor)
	{
		for (final TableRecordIdDescriptor tableRecordIdDescriptor : tableRecordIdDescriptors)
		{
			if (equalsTableRecordIdDescriptor(tableRecordIdDescriptor, expectedactualTableRecordIdDescriptor))
			{
				return true;
			}
		}

		return false;

	}

	interface Mocked_I_AD_ChangeLog extends I_AD_ChangeLog
	{
		void setAD_Field_AD_Table_ID(int AD_Table_ID);

		int getAD_Field_AD_Table_ID();

		org.compiere.model.I_AD_Table getAD_Field_AD_Table();

		void setAD_Field_AD_Table(org.compiere.model.I_AD_Table AD_Table);

		String COLUMNNAME_AD_Field_AD_Table_ID = "AD_Field_AD_Table_ID";

		//
		void setAD_Field_Record_ID(int AD_Field_Record_ID);

		int getAD_Field_Record_ID();

		/** Column name Record_ID */
		String COLUMNNAME_AD_Field_Record_ID = "AD_Field_Record_ID";

	}

	/**
	 * tests TableRecordIdDAO#retrieveTableRecordReferences()
	 * Creates two <code>AD_ChangeLog</code> records, one referencing an <code>AD_Element</code>, the other one referencing an <code>AD_Field</code>.
	 * Then verifies that the map returned by the method under test contains two entries. One for <code>AD_Element</code>, one for <code>AD_Field</code>.
	 */
	@Test
	public void testRetrieveTableRecordReferences()
	{
		final IADTableDAO adTableDAO = Services.get(IADTableDAO.class);

		final I_AD_Element referencedElement = InterfaceWrapperHelper.newInstance(I_AD_Element.class);
		InterfaceWrapperHelper.save(referencedElement);
		final AdTableId adElementTableID = AdTableId.ofRepoId(adTableDAO.retrieveTableId(I_AD_Element.Table_Name));

		final I_AD_Field referencedField = InterfaceWrapperHelper.newInstance(I_AD_Field.class);
		InterfaceWrapperHelper.save(referencedField);
		final AdTableId adfieldTableID = AdTableId.ofRepoId(adTableDAO.retrieveTableId(I_AD_Field.Table_Name));

		final I_AD_ChangeLog referencingChangeLog = InterfaceWrapperHelper.newInstance(I_AD_ChangeLog.class);
		referencingChangeLog.setAD_Table_ID(adElementTableID.getRepoId());
		referencingChangeLog.setRecord_ID(referencedElement.getAD_Element_ID());
		InterfaceWrapperHelper.save(referencingChangeLog);

		final I_AD_ChangeLog referencingChangeLog2 = InterfaceWrapperHelper.newInstance(I_AD_ChangeLog.class);
		referencingChangeLog2.setAD_Table_ID(adfieldTableID.getRepoId());
		referencingChangeLog2.setRecord_ID(referencedField.getAD_Field_ID());
		InterfaceWrapperHelper.save(referencingChangeLog2);

		final int adChangeLogTableID = adTableDAO.retrieveTableId(I_AD_ChangeLog.Table_Name);

		// for the unit test need to explicitly create AD_Column records for the two AD_Changelog properties
		{
			final I_AD_Column recordIDColumn = InterfaceWrapperHelper.newInstance(I_AD_Column.class);
			recordIDColumn.setColumnName(I_AD_ChangeLog.COLUMNNAME_Record_ID);
			recordIDColumn.setAD_Table_ID(adChangeLogTableID);
			InterfaceWrapperHelper.save(recordIDColumn);

			final I_AD_Column tableIDIDColumn = InterfaceWrapperHelper.newInstance(I_AD_Column.class);
			tableIDIDColumn.setColumnName(I_AD_ChangeLog.COLUMNNAME_AD_Table_ID);
			tableIDIDColumn.setAD_Table_ID(adChangeLogTableID);
			InterfaceWrapperHelper.save(tableIDIDColumn);
		}

		final TableRecordIdDAO instanceUnderTest = setupTableRecordDaoWithDistinctIDs(ImmutableSet.of(adElementTableID, adfieldTableID));
		final List<TableRecordIdDescriptor> tableRecordIdReferences = instanceUnderTest.retrieveAllTableRecordIdReferences();

		// assert that there are two records, one about AD_Fleid, one about AD_Element
		assertThat(tableRecordIdReferences).hasSize(2);
		assertThat(tableRecordIdReferences.stream().anyMatch(d -> I_AD_Element.Table_Name.equals(d.getTargetTableName()))).isTrue();
		assertThat(tableRecordIdReferences.stream().anyMatch(d -> I_AD_Field.Table_Name.equals(d.getTargetTableName()))).isTrue();

		final TableRecordIdDescriptor adElementReferenceDescriptor = tableRecordIdReferences.stream().filter(d -> I_AD_Element.Table_Name.equals(d.getTargetTableName())).findFirst().get();
		assertThat(adElementReferenceDescriptor.getOriginTableName()).isEqualTo(I_AD_ChangeLog.Table_Name);
		assertThat(adElementReferenceDescriptor.getRecordIdColumnName()).isEqualTo(I_AD_ChangeLog.COLUMNNAME_Record_ID);

		final TableRecordIdDescriptor adFieldReferenceDescriptor = tableRecordIdReferences.stream().filter(d -> I_AD_Field.Table_Name.equals(d.getTargetTableName())).findFirst().get();
		assertThat(adFieldReferenceDescriptor.getOriginTableName()).isEqualTo(I_AD_ChangeLog.Table_Name);
		assertThat(adFieldReferenceDescriptor.getRecordIdColumnName()).isEqualTo(I_AD_ChangeLog.COLUMNNAME_Record_ID);
	}

	private static TableRecordIdDAO setupTableRecordDaoWithDistinctIDs(
			@NonNull final Set<AdTableId> retrieveDistinctIdsResult)
	{
		final TableRecordIdDAO tableRecordIdDAO = Mockito.spy(new TableRecordIdDAO());

		Mockito.doReturn(retrieveDistinctIdsResult)
				.when(tableRecordIdDAO).retrieveDistinctIds(
						anyString(), // tableName
						anyString() // idColumnName
				);

		return tableRecordIdDAO;
	}
}
