/*
 * #%L
 * de.metas.cucumber
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

package de.metas.cucumber.stepdefs.dataImport;

import de.metas.cucumber.stepdefs.AD_User_StepDefData;
import de.metas.cucumber.stepdefs.C_BPartner_Location_StepDefData;
import de.metas.cucumber.stepdefs.C_BPartner_StepDefData;
import de.metas.cucumber.stepdefs.DataTableUtil;
import de.metas.cucumber.stepdefs.M_Product_StepDefData;
import de.metas.cucumber.stepdefs.context.TestContext;
import de.metas.invoicecandidate.model.I_I_Invoice_Candidate;
import de.metas.util.Check;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import lombok.NonNull;
import org.compiere.model.I_AD_User;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_M_Product;
import org.compiere.util.TimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

import static de.metas.cucumber.stepdefs.StepDefConstants.TABLECOLUMN_IDENTIFIER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class C_DataImport_StepDef
{
	private final C_BPartner_StepDefData bpartnerTable;
	private final M_Product_StepDefData productTable;
	private final C_BPartner_Location_StepDefData bPartnerLocationTable;
	private final AD_User_StepDefData contactTable;

	private final TestContext testContext;

	public C_DataImport_StepDef(
			@NonNull final C_BPartner_StepDefData bpartnerTable,
			@NonNull final M_Product_StepDefData productTable,
			@NonNull final C_BPartner_Location_StepDefData bPartnerLocationTable,
			@NonNull final AD_User_StepDefData contactTable,
			@NonNull final TestContext testContext)
	{
		this.bpartnerTable = bpartnerTable;
		this.productTable = productTable;
		this.bPartnerLocationTable = bPartnerLocationTable;
		this.contactTable = contactTable;
		this.testContext = testContext;
	}

	@And("store DataImport string requestBody in context")
	public void store_string_requestBody_in_context(@NonNull final DataTable dataTable)
	{
		final Map<String, String> row = dataTable.asMaps().get(0);

		final String billBPartnerIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, I_I_Invoice_Candidate.COLUMNNAME_Bill_BPartner_ID + "." + TABLECOLUMN_IDENTIFIER);
		final String bpartnerValue;
		if (Check.isNotBlank(billBPartnerIdentifier))
		{
			final I_C_BPartner billBPartner = bpartnerTable.get(billBPartnerIdentifier);
			assertThat(billBPartner).isNotNull();
			bpartnerValue = billBPartner.getValue();
		}
		else
		{
			bpartnerValue = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_Bill_BPartner_Value);
		}

		final String billBPartnerLocationIdentifier = DataTableUtil.extractStringForColumnName(row, I_I_Invoice_Candidate.COLUMNNAME_Bill_Location_ID + "." + TABLECOLUMN_IDENTIFIER);
		final I_C_BPartner_Location bPartnerLocation = bPartnerLocationTable.get(billBPartnerLocationIdentifier);
		assertThat(bPartnerLocation).isNotNull();

		final String billBPartnerContactIdentifier = DataTableUtil.extractStringForColumnName(row, I_I_Invoice_Candidate.COLUMNNAME_Bill_User_ID + "." + TABLECOLUMN_IDENTIFIER);
		final I_AD_User contact = contactTable.get(billBPartnerContactIdentifier);
		assertThat(contact).isNotNull();

		final String productIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, I_I_Invoice_Candidate.COLUMNNAME_M_Product_ID + "." + TABLECOLUMN_IDENTIFIER);
		final String productValue;
		if (Check.isNotBlank(productIdentifier))
		{
			final I_M_Product product = productTable.get(productIdentifier);
			assertThat(product).isNotNull();
			productValue = product.getValue();
		}
		else
		{
			productValue = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_M_Product_Value);
		}

		final String qtyOrdered = DataTableUtil.extractStringForColumnName(row, I_I_Invoice_Candidate.COLUMNNAME_QtyOrdered);
		final String isSOTrx = DataTableUtil.extractStringForColumnName(row, I_I_Invoice_Candidate.COLUMNNAME_IsSOTrx);

		final String qtyDelivered = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_QtyDelivered);
		final String dateOrdered = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_DateOrdered);
		final String presetDateInvoiced = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_PresetDateInvoiced);
		final String uomCode = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_X12DE355);
		final String docBaseType = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_DocBaseType);
		final String docSubType = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_DocSubType);
		final String poReference = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_POReference);
		final String description = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_Description);
		final String invoiceRule = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_InvoiceRule);
		final String orgCode = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_OrgCode);
		final String defaultOrgCode = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_Default_OrgCode);
		final String endNote = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_DescriptionBottom);
		final String adUserInChargeIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_AD_User_InCharge_ID + "." + TABLECOLUMN_IDENTIFIER);
		final BigDecimal discount = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_Discount);
		final BigDecimal price = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_Price);
		final String activityValue = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_I_Invoice_Candidate.COLUMNNAME_C_Activity_Value);

		int userInChargeId = 0;
		if (Check.isNotBlank(adUserInChargeIdentifier))
		{
			final I_AD_User userInCharge = contactTable.get(adUserInChargeIdentifier);
			assertThat(userInCharge).isNotNull();
			userInChargeId = userInCharge.getAD_User_ID();
		}

		final String payload = bpartnerValue + ";"
				+ bPartnerLocation.getC_BPartner_Location_ID() + ";"
				+ contact.getAD_User_ID() + ";"
				+ productValue + ";"
				+ TimeUtil.asLocalDate(dateOrdered) + ";"
				+ qtyOrdered + ";"
				+ qtyDelivered + ";"
				+ uomCode + ";"
				+ isSOTrx + ";"
				+ docBaseType + ";"
				+ docSubType + ";"
				+ TimeUtil.asLocalDate(presetDateInvoiced) + ";"
				+ description + ";"
				+ poReference + ";"
				+ invoiceRule + ";"
				+ orgCode + ";"
				+ defaultOrgCode + ";"
				+ endNote + ";"
				+ (userInChargeId >= 0 ? userInChargeId : "") + ";"
				+ discount + ";"
				+ price + ";"
				+ activityValue + ";";

		testContext.setRequestPayload(payload.replaceAll("null", ""));
	}

	@And("store file content as requestBody in context")
	public void store_file_content_requestBody_in_context(@NonNull final DataTable dataTable) throws IOException
	{
		final Map<String, String> row = dataTable.asMaps().get(0);

		final String fileName = DataTableUtil.extractStringForColumnName(row, "FileName");

		final InputStream inputStream = C_DataImport_StepDef.class.getClassLoader().getResourceAsStream(fileName);

		final String content = new BufferedReader(
				new InputStreamReader(inputStream, StandardCharsets.UTF_8))
				.lines()
				.collect(Collectors.joining("\n"));

		testContext.setRequestPayload(content);
	}
}
