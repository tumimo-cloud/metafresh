/*
 * #%L
 * de.metas.cucumber
 * %%
 * Copyright (C) 2021 metas GmbH
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

package de.metas.cucumber.stepdefs.invoice;

<<<<<<< HEAD
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import de.metas.JsonObjectMapperHolder;
import de.metas.banking.payment.paymentallocation.InvoiceToAllocate;
import de.metas.banking.payment.paymentallocation.InvoiceToAllocateQuery;
import de.metas.banking.payment.paymentallocation.PaymentAllocationRepository;
import de.metas.cucumber.stepdefs.AD_User_StepDefData;
import de.metas.cucumber.stepdefs.C_BPartner_Location_StepDefData;
import de.metas.cucumber.stepdefs.C_BPartner_StepDefData;
import de.metas.cucumber.stepdefs.C_OrderLine_StepDefData;
import de.metas.cucumber.stepdefs.C_Order_StepDefData;
=======
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
>>>>>>> 9ca46724894 (Revert "Revert "Merge remote-tracking branch 'origin/mad_orange_uat' into mad_orange_hotfix"" (#15192))
import de.metas.cucumber.stepdefs.DataTableUtil;
import de.metas.cucumber.stepdefs.ItemProvider;
import de.metas.cucumber.stepdefs.StepDefConstants;
<<<<<<< HEAD
import de.metas.cucumber.stepdefs.StepDefDocAction;
import de.metas.cucumber.stepdefs.StepDefUtil;
import de.metas.cucumber.stepdefs.activity.C_Activity_StepDefData;
import de.metas.cucumber.stepdefs.context.TestContext;
import de.metas.cucumber.stepdefs.docType.C_DocType_StepDefData;
import de.metas.cucumber.stepdefs.invoicecandidate.C_Invoice_Candidate_StepDefData;
import de.metas.cucumber.stepdefs.project.C_Project_StepDefData;
import de.metas.cucumber.stepdefs.sectioncode.M_SectionCode_StepDefData;
import de.metas.currency.CurrencyCode;
import de.metas.currency.CurrencyRepository;
import de.metas.document.DocTypeId;
import de.metas.document.engine.IDocument;
import de.metas.document.engine.IDocumentBL;
import de.metas.impex.api.IInputDataSourceDAO;
import de.metas.impex.model.I_AD_InputDataSource;
import de.metas.inout.model.I_M_InOutLine;
import de.metas.invoice.InvoiceCreditContext;
import de.metas.invoice.InvoiceId;
import de.metas.invoice.InvoiceService;
import de.metas.invoice.invoiceProcessingServiceCompany.InvoiceProcessingServiceCompanyService;
import de.metas.invoice.service.IInvoiceBL;
import de.metas.invoice.service.IInvoiceDAO;
import de.metas.invoice.service.IInvoiceLineBL;
import de.metas.invoicecandidate.InvoiceCandidateId;
import de.metas.invoicecandidate.api.IInvoiceCandBL;
import de.metas.invoicecandidate.api.IInvoiceCandDAO;
import de.metas.invoicecandidate.model.I_C_Invoice_Candidate;
import de.metas.logging.LogManager;
import de.metas.money.CurrencyConversionTypeId;
import de.metas.money.CurrencyId;
import de.metas.order.OrderId;
import de.metas.organization.IOrgDAO;
import de.metas.organization.OrgId;
=======
import de.metas.cucumber.stepdefs.StepDefUtil;
import de.metas.cucumber.stepdefs.invoicecandidate.C_Invoice_Candidate_StepDefData;
import de.metas.invoice.InvoiceId;
import de.metas.invoice.service.IInvoiceDAO;
import de.metas.invoicecandidate.InvoiceCandidateId;
import de.metas.invoicecandidate.api.IInvoiceCandDAO;
import de.metas.invoicecandidate.model.I_C_Invoice_Candidate;
>>>>>>> 9ca46724894 (Revert "Revert "Merge remote-tracking branch 'origin/mad_orange_uat' into mad_orange_hotfix"" (#15192))
import de.metas.payment.paymentterm.IPaymentTermRepository;
import de.metas.payment.paymentterm.PaymentTermId;
import de.metas.payment.paymentterm.impl.PaymentTermQuery;
import de.metas.rest_api.v2.invoice.JsonCreateInvoiceResponse;
import de.metas.rest_api.v2.invoice.JsonCreateInvoiceResponseResult;
import de.metas.util.Check;
import de.metas.util.Services;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.NonNull;
import org.adempiere.ad.dao.IQueryBL;
import org.adempiere.ad.dao.IQueryBuilder;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.model.InterfaceWrapperHelper;
import org.assertj.core.api.SoftAssertions;
import org.compiere.SpringContextHolder;
import org.compiere.model.I_AD_User;
import org.compiere.model.I_C_Activity;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_C_ConversionType;
import org.compiere.model.I_C_Currency;
import org.compiere.model.I_C_DocType;
import org.compiere.model.I_C_Invoice;
import org.compiere.model.I_C_InvoiceLine;
<<<<<<< HEAD
import org.compiere.model.I_C_Order;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.I_C_Project;
import org.compiere.model.I_M_SectionCode;
import org.compiere.model.X_C_Invoice;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;
import org.compiere.util.Trx;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
=======
import org.compiere.model.X_C_Invoice;

>>>>>>> 9ca46724894 (Revert "Revert "Merge remote-tracking branch 'origin/mad_orange_uat' into mad_orange_hotfix"" (#15192))
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static de.metas.cucumber.stepdefs.StepDefConstants.TABLECOLUMN_IDENTIFIER;
import static de.metas.invoicecandidate.model.I_C_Invoice_Candidate.COLUMNNAME_C_Invoice_Candidate_ID;
<<<<<<< HEAD
import static de.metas.invoicecandidate.model.I_C_Invoice_Candidate.COLUMNNAME_C_Order_ID;
import static de.metas.invoicecandidate.model.I_C_Invoice_Candidate.COLUMNNAME_QtyToInvoice;
import static de.metas.invoicecandidate.model.I_C_Invoice_Candidate.COLUMNNAME_QtyToInvoice_Override;
import static org.assertj.core.api.Assertions.*;
import static org.compiere.model.I_C_BPartner_Location.COLUMNNAME_C_BPartner_Location_ID;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_AD_User_ID;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_C_BPartner_ID;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_C_ConversionType_ID;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_C_Currency_ID;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_C_DocTypeTarget_ID;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_C_DocType_ID;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_C_Invoice_ID;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_DateAcct;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_DateInvoiced;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_DateOrdered;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_DueDate;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_ExternalId;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_GrandTotal;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_IsPaid;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_IsSOTrx;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_POReference;
import static org.compiere.model.I_C_Invoice.COLUMNNAME_TotalLines;
import static org.compiere.model.I_C_InvoiceLine.COLUMNNAME_C_InvoiceLine_ID;
import static org.compiere.model.I_C_InvoiceLine.COLUMNNAME_PriceEntered;
=======
import static org.assertj.core.api.Assertions.*;
import static org.compiere.model.I_C_InvoiceLine.COLUMNNAME_C_Invoice_ID;
>>>>>>> 9ca46724894 (Revert "Revert "Merge remote-tracking branch 'origin/mad_orange_uat' into mad_orange_hotfix"" (#15192))

public class C_Invoice_StepDef
{
	private static final Logger logger = LogManager.getLogger(C_Invoice_StepDef.class);

	private final IPaymentTermRepository paymentTermRepo = Services.get(IPaymentTermRepository.class);
<<<<<<< HEAD
	private final IQueryBL queryBL = Services.get(IQueryBL.class);
	private final IInvoiceCandBL invoiceCandBL = Services.get(IInvoiceCandBL.class);
	private final IInvoiceCandDAO invoiceCandDAO = Services.get(IInvoiceCandDAO.class);
	private final IInvoiceDAO invoiceDAO = Services.get(IInvoiceDAO.class);
	private final IInvoiceBL invoiceBL = Services.get(IInvoiceBL.class);
	private final IDocumentBL documentBL = Services.get(IDocumentBL.class);
	private final IInputDataSourceDAO inputDataSourceDAO = Services.get(IInputDataSourceDAO.class);
	private final IInvoiceLineBL invoiceLineBL = Services.get(IInvoiceLineBL.class);
	private final IOrgDAO orgDAO = Services.get(IOrgDAO.class);
	private final InvoiceProcessingServiceCompanyService invoiceProcessingServiceCompanyService = SpringContextHolder.instance.getBean(InvoiceProcessingServiceCompanyService.class);
	private final CurrencyRepository currencyRepository = SpringContextHolder.instance.getBean(CurrencyRepository.class);
	private final PaymentAllocationRepository paymentAllocationRepository = SpringContextHolder.instance.getBean(PaymentAllocationRepository.class);
	private final InvoiceService invoiceService = SpringContextHolder.instance.getBean(InvoiceService.class);
	private final ObjectMapper mapper = JsonObjectMapperHolder.sharedJsonObjectMapper();

	private final C_Invoice_StepDefData invoiceTable;
	private final C_InvoiceLine_StepDefData invoiceLineTable;
	private final C_Invoice_Candidate_StepDefData invoiceCandTable;
	private final C_Order_StepDefData orderTable;
	private final C_OrderLine_StepDefData orderLineTable;
	private final C_BPartner_StepDefData bpartnerTable;
	private final C_BPartner_Location_StepDefData bPartnerLocationTable;
	private final AD_User_StepDefData userTable;
	private final M_SectionCode_StepDefData sectionCodeTable;
	private final C_Project_StepDefData projectTable;
	private final C_Activity_StepDefData activityTable;
	private final C_DocType_StepDefData docTypeTable;
	private final TestContext testContext;

	public C_Invoice_StepDef(
			@NonNull final C_Invoice_StepDefData invoiceTable,
			@NonNull final C_InvoiceLine_StepDefData invoiceLineTable,
			@NonNull final C_Invoice_Candidate_StepDefData invoiceCandTable,
			@NonNull final C_Order_StepDefData orderTable,
			@NonNull final C_OrderLine_StepDefData orderLineTable,
			@NonNull final C_BPartner_StepDefData bpartnerTable,
			@NonNull final C_BPartner_Location_StepDefData bPartnerLocationTable,
			@NonNull final AD_User_StepDefData userTable,
			@NonNull final M_SectionCode_StepDefData sectionCodeTable,
			@NonNull final C_Project_StepDefData projectTable,
			@NonNull final C_Activity_StepDefData activityTable,
			@NonNull final C_DocType_StepDefData docTypeTable,
			@NonNull final TestContext testContext)
	{
		this.invoiceTable = invoiceTable;
		this.invoiceLineTable = invoiceLineTable;
		this.orderTable = orderTable;
		this.bpartnerTable = bpartnerTable;
		this.bPartnerLocationTable = bPartnerLocationTable;
		this.orderLineTable = orderLineTable;
		this.userTable = userTable;
		this.sectionCodeTable = sectionCodeTable;
		this.projectTable = projectTable;
		this.activityTable = activityTable;
		this.invoiceCandTable = invoiceCandTable;
		this.docTypeTable = docTypeTable;
		this.testContext = testContext;
=======
	private final IInvoiceCandDAO invoiceCandDAO = Services.get(IInvoiceCandDAO.class);
	private final IInvoiceDAO invoiceDAO = Services.get(IInvoiceDAO.class);

	private final C_Invoice_StepDefData invoiceTable;
	private final C_Invoice_Candidate_StepDefData invoiceCandTable;

	public C_Invoice_StepDef(
			@NonNull final C_Invoice_StepDefData invoiceTable,
			@NonNull final C_Invoice_Candidate_StepDefData invoiceCandTable)
	{
		this.invoiceTable = invoiceTable;
		this.invoiceCandTable = invoiceCandTable;
>>>>>>> 9ca46724894 (Revert "Revert "Merge remote-tracking branch 'origin/mad_orange_uat' into mad_orange_hotfix"" (#15192))
	}

	@And("validate created invoices")
	public void validate_created_invoices(@NonNull final DataTable table)
	{
		final List<Map<String, String>> dataTable = table.asMaps();
		for (final Map<String, String> row : dataTable)
		{
			final String identifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_ID + "." + TABLECOLUMN_IDENTIFIER);

			final I_C_Invoice invoice = invoiceTable.get(identifier);

			validateInvoice(invoice, row);
		}
	}

<<<<<<< HEAD
	@And("^the invoice identified by (.*) is (completed|reversed|voided)$")
	public void invoice_action(@NonNull final String invoiceIdentifier, @NonNull final String action)
	{
		final I_C_Invoice invoice = invoiceTable.get(invoiceIdentifier);

		switch (StepDefDocAction.valueOf(action))
		{
			case reversed:
				invoice.setDocAction(IDocument.ACTION_Complete); // we need this because otherwise MInvoice.completeIt() won't complete it
				documentBL.processEx(invoice, IDocument.ACTION_Reverse_Correct, IDocument.STATUS_Reversed);
				break;
			case completed:
				invoice.setDocAction(IDocument.ACTION_Complete);
				documentBL.processEx(invoice, IDocument.ACTION_Complete, IDocument.STATUS_Completed);
				break;
			case voided:
				documentBL.processEx(invoice, IDocument.ACTION_Void, IDocument.STATUS_Voided);
				break;
			default:
				throw new AdempiereException("Unhandled C_Invoice action")
						.appendParametersToMessage()
						.setParameter("action:", action);
		}
	}

	@And("load C_Invoice:")
	public void loadC_Invoice(@NonNull final DataTable dataTable)
	{
		for (final Map<String, String> row : dataTable.asMaps())
		{
			final BigDecimal qtyInvoiced = DataTableUtil.extractBigDecimalForColumnName(row, I_C_InvoiceLine.COLUMNNAME_QtyInvoiced);

			final IQueryBuilder<I_C_InvoiceLine> invoiceLineBuilder = queryBL.createQueryBuilder(I_C_InvoiceLine.class)
					.addEqualsFilter(I_C_InvoiceLine.COLUMNNAME_QtyInvoiced, qtyInvoiced);

			final String orderLineIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_InvoiceLine.COLUMNNAME_C_OrderLine_ID + "." + TABLECOLUMN_IDENTIFIER);
			if (Check.isNotBlank(orderLineIdentifier))
			{
				final I_C_OrderLine orderLine = orderLineTable.get(orderLineIdentifier);
				invoiceLineBuilder.addEqualsFilter(I_M_InOutLine.COLUMNNAME_C_OrderLine_ID, orderLine.getC_OrderLine_ID());
			}

			final I_C_InvoiceLine invoiceLine = invoiceLineBuilder.create()
					.firstOnlyNotNull(I_C_InvoiceLine.class);

			final String invoiceLineIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_InvoiceLine_ID + "." + TABLECOLUMN_IDENTIFIER);
			invoiceLineTable.putOrReplace(invoiceLineIdentifier, invoiceLine);

			final I_C_Invoice invoice = InterfaceWrapperHelper.load(invoiceLine.getC_Invoice_ID(), I_C_Invoice.class);
			assertThat(invoice).isNotNull();

			final String docStatus = DataTableUtil.extractStringForColumnName(row, I_C_Invoice.COLUMNNAME_DocStatus);
			assertThat(invoice.getDocStatus()).isEqualTo(docStatus);

			final String orderIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_C_Order_ID + "." + TABLECOLUMN_IDENTIFIER);
			if (Check.isNotBlank(orderIdentifier))
			{
				final I_C_Order order = orderTable.get(orderIdentifier);
				assertThat(invoice.getC_Order_ID()).isEqualTo(order.getC_Order_ID());
			}

			final String invoiceIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_ID + "." + TABLECOLUMN_IDENTIFIER);
			invoiceTable.putOrReplace(invoiceIdentifier, invoice);
		}
	}

=======
>>>>>>> 9ca46724894 (Revert "Revert "Merge remote-tracking branch 'origin/mad_orange_uat' into mad_orange_hotfix"" (#15192))
	@And("^after not more than (.*)s, C_Invoice are found:$")
	public void wait_until_there_are_invoices(final int timeoutSec, @NonNull final DataTable dataTable) throws InterruptedException
	{
		for (final Map<String, String> tableRow : dataTable.asMaps())
		{
			StepDefUtil.tryAndWait(timeoutSec, 500, () -> loadInvoice(tableRow));
		}
	}

<<<<<<< HEAD
	@Deprecated
	@Then("^enqueue candidate for invoicing and after not more than (.*)s, the invoice is found$")
	public void generateInvoice(final int timeoutSec, @NonNull final DataTable table) throws InterruptedException
	{
		final Map<String, String> singleRow = table.asMaps().get(0);

		final String orderIdentifierCandidate = DataTableUtil.extractStringForColumnName(singleRow, I_C_Order.COLUMNNAME_C_Order_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);
		final ImmutableList<OrderId> orderIds = StepDefUtil.extractIdentifiers(orderIdentifierCandidate)
				.stream()
				.map(orderTable::get)
				.map(I_C_Order::getC_Order_ID)
				.map(OrderId::ofRepoId)
				.collect(ImmutableList.toImmutableList());

		final ImmutableSet.Builder<InvoiceCandidateId> invoiceCandidateIds = ImmutableSet.builder();

		for (final OrderId targetOrderId : orderIds)
		{
			//make sure the given invoice candidate is ready for processing
			final InvoiceCandidateId invoiceCandidateId = StepDefUtil.tryAndWaitForItem(timeoutSec, 500,
																						() -> loadInvoiceCandidateReadyToBeProcessed(targetOrderId),
																						() -> logCurrentContext(targetOrderId));

			invoiceCandidateIds.add(invoiceCandidateId);
		}

		final ImmutableSet<InvoiceId> invoiceIds = invoiceService.generateInvoicesFromInvoiceCandidateIds(invoiceCandidateIds.build());

		final List<I_C_Invoice> invoices = invoiceDAO.getByIdsOutOfTrx(invoiceIds);

		final String invoiceIdentifierCandidate = DataTableUtil.extractStringForColumnName(singleRow, I_C_Invoice.COLUMNNAME_C_Invoice_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);
		final ImmutableList<String> invoiceIdentifiers = StepDefUtil.extractIdentifiers(invoiceIdentifierCandidate);
		assertThat(invoices.size()).isEqualTo(invoiceIdentifiers.size());

		// dev-note: map either multiple orders (aggregated) to the same invoice or multiple orders to multiple invoices (each order with its invoice) 
		if (invoiceIdentifiers.size() == 1)
		{
			invoiceTable.putOrReplace(invoiceIdentifiers.get(0), invoices.get(0));
		}
		else
		{
			assertThat(orderIds.size()).isEqualTo(invoiceIdentifiers.size());

			for (int invoiceIndex = 0; invoiceIndex < invoiceIdentifiers.size(); invoiceIndex++)
			{
				final OrderId orderId = orderIds.get(invoiceIndex);
				final I_C_Invoice invoiceRecord = invoices.stream()
						.filter(invoice -> invoice.getC_Order_ID() == orderId.getRepoId())
						.findFirst()
						.orElseThrow(() -> new AdempiereException("No Invoice found with OrderId!")
								.appendParametersToMessage()
								.setParameter("OrderId", orderId));
				invoiceTable.putOrReplace(invoiceIdentifiers.get(invoiceIndex), invoiceRecord);
			}
		}
	}

	@And("metasfresh contains C_Invoice:")
	public void addC_Invoices(@NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> rows = dataTable.asMaps();
		for (final Map<String, String> dataTableRow : rows)
		{
			create_C_Invoice(dataTableRow);
		}
	}

	@And("create credit memo for C_Invoice")
	public void create_credit_memo_for_invoice(@NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> rows = dataTable.asMaps();
		for (final Map<String, String> dataTableRow : rows)
		{
			final String invoiceIdentifier = DataTableUtil.extractStringForColumnName(dataTableRow, COLUMNNAME_C_Invoice_ID + "." + TABLECOLUMN_IDENTIFIER);
			final I_C_Invoice invoice = invoiceTable.get(invoiceIdentifier);

			final BigDecimal creditMemoLineAmt = DataTableUtil.extractBigDecimalForColumnName(dataTableRow, "CreditMemo." + COLUMNNAME_PriceEntered);

			final String creditMemoDocType = DataTableUtil.extractStringForColumnName(dataTableRow, "CreditMemo." + COLUMNNAME_C_DocType_ID + ".Name");

			final DocTypeId creditMemoDocTypeId = queryBL.createQueryBuilder(I_C_DocType.class)
					.addEqualsFilter(I_C_DocType.COLUMNNAME_Name, creditMemoDocType)
					.orderBy(I_C_DocType.COLUMNNAME_Name)
					.create()
					.firstId(DocTypeId::ofRepoIdOrNull);

			final InvoiceCreditContext creditCtx = InvoiceCreditContext.builder()
					.docTypeId(creditMemoDocTypeId)
					.completeAndAllocate(false)
					.referenceOriginalOrder(false)
					.referenceInvoice(true)
					.creditedInvoiceReinvoicable(false).build();

			final I_C_Invoice creditMemo = invoiceBL.creditInvoice(InterfaceWrapperHelper.create(invoice, de.metas.adempiere.model.I_C_Invoice.class), creditCtx);

			for (final de.metas.adempiere.model.I_C_InvoiceLine creditMemoLine : invoiceDAO.retrieveLines(InvoiceId.ofRepoId(creditMemo.getC_Invoice_ID())))
			{
				creditMemoLine.setPriceActual(creditMemoLineAmt);

				// dev note : manually triggering as callouts don't run in cucumber
				invoiceLineBL.updatePrices(creditMemoLine);
				invoiceBL.setLineNetAmt(creditMemoLine);

				InterfaceWrapperHelper.save(creditMemoLine);
			}

			final String creditMemoIdentifier = DataTableUtil.extractStringForColumnName(dataTableRow, "CreditMemo." + TABLECOLUMN_IDENTIFIER);
			invoiceTable.putOrReplace(creditMemoIdentifier, creditMemo);
		}
	}

	@And("process invoice create response")
	public void process_invoice_create_response(@NonNull final DataTable table) throws JsonProcessingException
	{
		final JsonCreateInvoiceResponse jsonCreateInvoiceResponse = mapper.readValue(testContext.getApiResponse().getContent(), JsonCreateInvoiceResponse.class);

		final JsonCreateInvoiceResponseResult result = jsonCreateInvoiceResponse.getResult();
		assertThat(result).isNotNull();
		assertThat(jsonCreateInvoiceResponse.getErrors()).isNull();

		final List<I_C_Invoice> invoiceRecords = invoiceDAO.getByDocumentNo(result.getDocumentNo(), Env.getOrgId(), I_C_Invoice.class);
		assertThat(invoiceRecords.size()).isEqualTo(1);

		final Map<String, String> row = table.asMaps().get(0);

		final String invoiceIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);
		invoiceTable.put(invoiceIdentifier, invoiceRecords.get(0));
	}

	@Then("validate invoice api response error message")
	public void validate_api_response_error_message(@NonNull final DataTable dataTable) throws JsonProcessingException
	{
		for (final Map<String, String> row : dataTable.asMaps())
		{
			final String message = DataTableUtil.extractStringForColumnName(row, "JsonErrorItem.message");

			final SoftAssertions softly = new SoftAssertions();

			final JsonCreateInvoiceResponse jsonCreateInvoiceResponse = mapper.readValue(testContext.getApiResponse().getContent(), JsonCreateInvoiceResponse.class);
			softly.assertThat(jsonCreateInvoiceResponse.getResult()).isNull();

			softly.assertThat(jsonCreateInvoiceResponse.getErrors()).isNotNull();
			softly.assertThat(jsonCreateInvoiceResponse.getErrors().size()).isEqualTo(1);

			softly.assertThat(jsonCreateInvoiceResponse.getErrors().get(0).getMessage()).contains(message);

			softly.assertAll();
		}
	}

=======
>>>>>>> 9ca46724894 (Revert "Revert "Merge remote-tracking branch 'origin/mad_orange_uat' into mad_orange_hotfix"" (#15192))
	private void validateInvoice(@NonNull final I_C_Invoice invoice, @NonNull final Map<String, String> row)
	{
		InterfaceWrapperHelper.refresh(invoice);

		final SoftAssertions softly = new SoftAssertions();

		final String bpartnerIdentifier = DataTableUtil.extractStringForColumnName(row, I_C_BPartner.COLUMNNAME_C_BPartner_ID + "." + TABLECOLUMN_IDENTIFIER);
		final Integer expectedBPartnerId = bpartnerTable.getOptional(bpartnerIdentifier)
				.map(I_C_BPartner::getC_BPartner_ID)
				.orElseGet(() -> Integer.parseInt(bpartnerIdentifier));
		softly.assertThat(invoice.getC_BPartner_ID()).as("C_BPartner_ID").isEqualTo(expectedBPartnerId);

		final String bpartnerLocationIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_BPartner_Location_ID + "." + TABLECOLUMN_IDENTIFIER);
		final Integer expectedBPartnerLocationId = bPartnerLocationTable.getOptional(bpartnerLocationIdentifier)
				.map(I_C_BPartner_Location::getC_BPartner_Location_ID)
				.orElseGet(() -> Integer.parseInt(bpartnerLocationIdentifier));
		softly.assertThat(invoice.getC_BPartner_Location_ID()).as("C_BPartner_Location_ID").isEqualTo(expectedBPartnerLocationId);

		final String poReference = DataTableUtil.extractStringOrNullForColumnName(row, COLUMNNAME_POReference);
		if (Check.isNotBlank(poReference))
		{
			softly.assertThat(invoice.getPOReference()).as("POReference").isEqualTo(poReference);
		}

		final String paymentTerm = DataTableUtil.extractStringOrNullForColumnName(row, "paymentTerm");
		final boolean processed = DataTableUtil.extractBooleanForColumnName(row, "processed");
		final String docStatus = DataTableUtil.extractStringForColumnName(row, "docStatus");

		softly.assertThat(invoice.isProcessed()).as("Processed").isEqualTo(processed);
		softly.assertThat(invoice.getDocStatus()).as("DocStatus").isEqualTo(docStatus);

		if (Check.isNotBlank(paymentTerm))
		{
			final PaymentTermQuery query = PaymentTermQuery.builder()
					.orgId(StepDefConstants.ORG_ID)
					.value(paymentTerm)
					.build();
			final PaymentTermId paymentTermId = paymentTermRepo.retrievePaymentTermId(query)
					.orElse(null);

			softly.assertThat(paymentTermId).as("C_PaymentTerm_ID").isNotNull();
			softly.assertThat(invoice.getC_PaymentTerm_ID()).as("C_PaymentTerm_ID").isEqualTo(paymentTermId.getRepoId());
		}

		final String docSubType = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_DocType.COLUMNNAME_DocSubType);
		if (Check.isNotBlank(docSubType))
		{
			final int docTargetTypeId = invoice.getC_DocTypeTarget_ID();
			final I_C_DocType docType = queryBL.createQueryBuilder(I_C_DocType.class)
					.addEqualsFilter(I_C_DocType.COLUMN_C_DocType_ID, docTargetTypeId)
					.create()
					.firstOnlyNotNull(I_C_DocType.class);

			softly.assertThat(docType.getDocSubType()).as("DocSubType").isEqualTo(docSubType);
		}

		final String bpartnerAddress = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_BPartnerAddress);
		if (Check.isNotBlank(bpartnerAddress))
		{
			softly.assertThat(invoice.getBPartnerAddress()).as("BPartnerAddress").isEqualTo(bpartnerAddress);
		}

		final String expectedDocTypeName = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + COLUMNNAME_C_DocType_ID + "." + I_C_DocType.COLUMNNAME_Name);

		if (Check.isNotBlank(expectedDocTypeName))
		{
			final I_C_DocType actualInvoiceDocType = InterfaceWrapperHelper.load(invoice.getC_DocType_ID(), I_C_DocType.class);

			softly.assertThat(actualInvoiceDocType.getName()).as("C_DocType_ID").isEqualTo(expectedDocTypeName);
		}

		final String paymentRule = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_PaymentRule);
		if (Check.isNotBlank(paymentRule))
		{
			softly.assertThat(invoice.getPaymentRule()).as("PaymentRule").isEqualTo(paymentRule);
		}

		final String internalName = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_AD_InputDataSource_ID + "." + I_AD_InputDataSource.COLUMNNAME_InternalName);
		if (Check.isNotBlank(internalName))
		{
			final I_AD_InputDataSource dataSource = inputDataSourceDAO.retrieveInputDataSource(Env.getCtx(), internalName, true, Trx.TRXNAME_None);
			softly.assertThat(invoice.getAD_InputDataSource_ID()).as("AD_InputDataSource_ID").isEqualTo(dataSource.getAD_InputDataSource_ID());
		}

		final String adUserIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + COLUMNNAME_AD_User_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(adUserIdentifier))
		{
			final I_AD_User contact = userTable.get(adUserIdentifier);
			assertThat(invoice.getAD_User_ID()).isEqualTo(contact.getAD_User_ID());
		}

		final BigDecimal grandTotal = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + COLUMNNAME_GrandTotal);
		if (grandTotal != null)
		{
			softly.assertThat(invoice.getGrandTotal()).as("GrandTotal").isEqualByComparingTo(grandTotal);
		}

		final BigDecimal totalLines = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT." + COLUMNNAME_TotalLines);
		if (totalLines != null)
		{
			softly.assertThat(invoice.getTotalLines()).as("TotalLines").isEqualByComparingTo(totalLines);
		}

		final String currencyCode = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + COLUMNNAME_C_Currency_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(currencyCode))
		{
			final CurrencyId currencyId = currencyRepository.getCurrencyIdByCurrencyCode(CurrencyCode.ofThreeLetterCode(currencyCode));

			softly.assertThat(invoice.getC_Currency_ID()).as("CurrencyID").isEqualTo(currencyId.getRepoId());
		}

		final LocalDate dateInvoiced = DataTableUtil.extractLocalDateOrNullForColumnName(row, "OPT." + COLUMNNAME_DateInvoiced);
		if (dateInvoiced != null)
		{
			final OrgId orgId = OrgId.ofRepoId(invoice.getAD_Org_ID());
			final ZoneId zoneId = orgDAO.getTimeZone(orgId);

			softly.assertThat(TimeUtil.asLocalDate(invoice.getDateInvoiced(), zoneId)).isEqualTo(dateInvoiced);
		}

		final LocalDate dateAcct = DataTableUtil.extractLocalDateOrNullForColumnName(row, "OPT." + COLUMNNAME_DateAcct);
		if (dateAcct != null)
		{
			final OrgId orgId = OrgId.ofRepoId(invoice.getAD_Org_ID());
			final ZoneId zoneId = orgDAO.getTimeZone(orgId);

			softly.assertThat(TimeUtil.asLocalDate(invoice.getDateAcct(), zoneId)).isEqualTo(dateAcct);
		}

		final LocalDate dateOrdered = DataTableUtil.extractLocalDateOrNullForColumnName(row, "OPT." + COLUMNNAME_DateOrdered);
		if (dateOrdered != null)
		{
			final OrgId orgId = OrgId.ofRepoId(invoice.getAD_Org_ID());
			final ZoneId zoneId = orgDAO.getTimeZone(orgId);

			softly.assertThat(TimeUtil.asLocalDate(invoice.getDateOrdered(), zoneId)).isEqualTo(dateOrdered);
		}

		final String externalId = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + COLUMNNAME_ExternalId);
		if (Check.isNotBlank(externalId))
		{
			softly.assertThat(invoice.getExternalId()).as("ExternalId").isEqualTo(externalId);
		}

		final String docTypeIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + COLUMNNAME_C_DocType_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(docTypeIdentifier))
		{
			final I_C_DocType docTypeRecord = docTypeTable.get(docTypeIdentifier);
			softly.assertThat(docTypeRecord).isNotNull();

			softly.assertThat(invoice.getC_DocType_ID()).as(COLUMNNAME_C_DocType_ID).isEqualTo(docTypeRecord.getC_DocType_ID());
		}

		final String docTypeTargetIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + COLUMNNAME_C_DocTypeTarget_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(docTypeTargetIdentifier))
		{
			final I_C_DocType docTypeRecord = docTypeTable.get(docTypeTargetIdentifier);
			softly.assertThat(docTypeRecord).isNotNull();

			softly.assertThat(invoice.getC_DocTypeTarget_ID()).as(COLUMNNAME_C_DocTypeTarget_ID).isEqualTo(docTypeRecord.getC_DocType_ID());
		}

		final Boolean isSOTrx = DataTableUtil.extractBooleanForColumnNameOrNull(row, "OPT." + COLUMNNAME_IsSOTrx);
		if (isSOTrx != null)
		{
			softly.assertThat(invoice.isSOTrx()).as(COLUMNNAME_IsSOTrx).isEqualTo(isSOTrx);
		}

		{// payment related
			final Boolean invoiceIsPaid = DataTableUtil.extractBooleanForColumnNameOr(row, "OPT." + COLUMNNAME_IsPaid, null);

			final BigDecimal invoiceOpenAmt = DataTableUtil.extractBigDecimalOrNullForColumnName(row, "OPT.OpenAmt");

			if (invoiceIsPaid != null)
			{
				softly.assertThat(invoice.isPaid()).as("IsPaid").isEqualTo(invoiceIsPaid);
			}

			if (invoiceOpenAmt != null)
			{
				final InvoiceToAllocate invoiceToAllocate = paymentAllocationRepository
						.retrieveInvoicesToAllocate(InvoiceToAllocateQuery.builder()
															.evaluationDate(ZonedDateTime.now())
															.onlyInvoiceId(InvoiceId.ofRepoId(invoice.getC_Invoice_ID()))
															.build()).get(0);
				softly.assertThat(invoiceToAllocate.getOpenAmountConverted().getAsBigDecimal()).as("OpenAmountConverted").isEqualByComparingTo(invoiceOpenAmt);
			}
		}

		final String sectionCodeIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_M_SectionCode_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(sectionCodeIdentifier))
		{
			final I_M_SectionCode sectionCode = sectionCodeTable.get(sectionCodeIdentifier);
			softly.assertThat(invoice.getM_SectionCode_ID()).as("M_SectionCode_ID").isEqualTo(sectionCode.getM_SectionCode_ID());
		}

		final String projectIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_C_Project_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(projectIdentifier))
		{
			final I_C_Project project = projectTable.get(projectIdentifier);
			softly.assertThat(invoice.getC_Project_ID()).as("C_Project_ID").isEqualTo(project.getC_Project_ID());
		}

		final String costCenterIdentifier = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_C_Activity_ID + "." + TABLECOLUMN_IDENTIFIER);
		if (Check.isNotBlank(costCenterIdentifier))
		{
			final I_C_Activity activity = activityTable.get(costCenterIdentifier);
			softly.assertThat(invoice.getC_Activity_ID()).as("C_Activity_ID").isEqualTo(activity.getC_Activity_ID());
		}

		final String expectedSalesRep_ID = DataTableUtil.extractNullableStringForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_SalesRep_ID);
		if (expectedSalesRep_ID != null)
		{
			final int expectedSalesRep_RepoId = Optional.ofNullable(DataTableUtil.nullToken2Null(expectedSalesRep_ID))
					.map(Integer::parseInt)
					.orElse(0);

			assertThat(invoice.getSalesRep_ID()).isEqualTo(expectedSalesRep_RepoId);
		}

		softly.assertAll();
	}

	public Boolean loadInvoice(@NonNull final Map<String, String> row)
	{
		final String invoiceIdentifierCandidate = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_ID + "." + TABLECOLUMN_IDENTIFIER);
		final ImmutableList<String> invoiceIdentifiers = StepDefUtil.extractIdentifiers(invoiceIdentifierCandidate);

		if (invoiceIdentifiers.isEmpty())
		{
			throw new RuntimeException("No invoice identifier present for column: " + COLUMNNAME_C_Invoice_ID + "." + TABLECOLUMN_IDENTIFIER);
		}

		final boolean lookingForMultipleInvoices = invoiceIdentifiers.size() > 1;

		return lookingForMultipleInvoices ? loadMultipleInvoices(row) : loadSingleInvoiceByDocStatus(row);
	}

	private Boolean loadMultipleInvoices(@NonNull final Map<String, String> row)
	{
		final String invoiceCandIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_Candidate_ID + "." + TABLECOLUMN_IDENTIFIER);
		final I_C_Invoice_Candidate invoiceCandidate = invoiceCandTable.get(invoiceCandIdentifier);

		final InvoiceCandidateId invoiceCandidateId = InvoiceCandidateId.ofRepoId(invoiceCandidate.getC_Invoice_Candidate_ID());

		final Set<InvoiceId> invoiceIds = invoiceCandDAO.retrieveIlForIc(invoiceCandidateId)
				.stream()
				.map(I_C_InvoiceLine::getC_Invoice_ID)
				.map(InvoiceId::ofRepoId)
				.collect(ImmutableSet.toImmutableSet());

		final String invoiceIdCandidate = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);

		final ImmutableList<String> invoiceIdentifiers = StepDefUtil.extractIdentifiers(invoiceIdCandidate);

		if (invoiceIds.size() != invoiceIdentifiers.size())
		{
			return false;
		}

		final List<I_C_Invoice> invoices = invoiceDAO.getByIdsOutOfTrx(invoiceIds)
				.stream()
				.sorted(Comparator.comparingInt(I_C_Invoice::getC_Invoice_ID))
				.collect(ImmutableList.toImmutableList());

		assertThat(invoices).isNotEmpty();
		assertThat(invoices.size()).isEqualTo(invoiceIdentifiers.size());

		for (int invoiceIndex = 0; invoiceIndex < invoices.size(); invoiceIndex++)
		{
			invoiceTable.putOrReplace(invoiceIdentifiers.get(invoiceIndex), invoices.get(invoiceIndex));
		}

		return true;
	}

	private Boolean loadSingleInvoiceByDocStatus(@NonNull final Map<String, String> row)
	{
		final String invoiceCandIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_Candidate_ID + "." + TABLECOLUMN_IDENTIFIER);
		final I_C_Invoice_Candidate invoiceCandidate = invoiceCandTable.get(invoiceCandIdentifier);

		final InvoiceCandidateId invoiceCandidateId = InvoiceCandidateId.ofRepoId(invoiceCandidate.getC_Invoice_Candidate_ID());

		final Set<InvoiceId> invoiceIds = invoiceCandDAO.retrieveIlForIc(invoiceCandidateId)
				.stream()
				.map(I_C_InvoiceLine::getC_Invoice_ID)
				.map(InvoiceId::ofRepoId)
				.collect(ImmutableSet.toImmutableSet());

		if (invoiceIds.isEmpty())
		{
			return false;
		}

		final List<I_C_Invoice> invoices = invoiceDAO.getByIdsOutOfTrx(invoiceIds);

		final String invoiceStatus = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_DocStatus);
		final String docStatus = Optional.ofNullable(invoiceStatus)
				.orElse(X_C_Invoice.DOCACTION_Complete);

		final Optional<I_C_Invoice> invoice = invoices.stream()
				.filter(i -> i.getDocStatus().equals(docStatus))
				.findFirst();

		if (!invoice.isPresent())
		{
			return false;
		}

		final String invoiceIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_ID + "." + TABLECOLUMN_IDENTIFIER);
		invoiceTable.putOrReplace(invoiceIdentifier, invoice.get());

		return true;
	}

	@Nullable
	private I_C_Invoice_Candidate getFirstInvoiceCandidateByOrderId(@NonNull final OrderId targetOrderId)
	{
		return queryBL.createQueryBuilder(I_C_Invoice_Candidate.class)
				.addOnlyActiveRecordsFilter()
				.addEqualsFilter(I_C_Invoice_Candidate.COLUMNNAME_C_Order_ID, targetOrderId)
				.orderBy(COLUMNNAME_C_Invoice_Candidate_ID)
				.create()
				.first(I_C_Invoice_Candidate.class);
	}

	private boolean isInvoiceCandidateReadyToBeProcessed(@NonNull final OrderId targetOrderId)
	{
		final I_C_Invoice_Candidate invoiceableInvoiceCand = getFirstInvoiceCandidateByOrderId(targetOrderId);

		if (invoiceableInvoiceCand == null)
		{
			return false;
		}

		return invoiceableInvoiceCand.getQtyToInvoice().signum() > 0 || invoiceableInvoiceCand.getQtyToInvoice_Override().signum() > 0;
	}

	@NonNull
	private String logCurrentContext(@NonNull final OrderId targetOrderId)
	{
		final StringBuilder message = new StringBuilder();

		message.append("Looking for invoice candidate with:").append("\n")
				.append(COLUMNNAME_C_Order_ID).append(" : ").append(targetOrderId).append("\n")
				.append(COLUMNNAME_QtyToInvoice).append(" > 0").append("\n")
				.append("OR ").append(COLUMNNAME_QtyToInvoice_Override).append(" > 0");

		message.append("C_Invoice_Candidate record:").append("\n");

		Optional.ofNullable(getFirstInvoiceCandidateByOrderId(targetOrderId))
				.map(invoiceCandidateRecord ->
							 message.append(COLUMNNAME_C_Invoice_Candidate_ID).append(" : ").append(invoiceCandidateRecord.getC_Invoice_Candidate_ID()).append(" ; ")
									 .append(COLUMNNAME_QtyToInvoice).append(" : ").append(invoiceCandidateRecord.getQtyToInvoice()).append(" ; ")
									 .append(COLUMNNAME_QtyToInvoice_Override).append(" : ").append(invoiceCandidateRecord.getQtyToInvoice_Override()).append(" ; ")
									 .append("\n"))
				.orElseGet(() -> message.append("No invoice-able invoice candidate record found for ")
						.append(COLUMNNAME_C_Order_ID).append(" : ").append(targetOrderId).append(" ; "));

		return "*** Error while looking for first invoice-able invoice candidate record, see current context: \n" + message;
	}

	private void create_C_Invoice(@NonNull final Map<String, String> row)
	{
		final String bPartnerIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_BPartner_ID + "." + TABLECOLUMN_IDENTIFIER);
		final Integer bPartnerId = bpartnerTable.getOptional(bPartnerIdentifier)
				.map(I_C_BPartner::getC_BPartner_ID)
				.orElseGet(() -> Integer.parseInt(bPartnerIdentifier));

		final String docTargetName = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_DocTypeTarget_ID + "." + I_C_DocType.COLUMNNAME_Name);
		final DocTypeId docTypeId = queryBL.createQueryBuilder(I_C_DocType.class)
				.addOnlyActiveRecordsFilter()
				.addEqualsFilter(I_C_DocType.COLUMNNAME_Name, docTargetName)
				.orderBy(I_C_DocType.COLUMNNAME_Name)
				.create()
				.firstId(DocTypeId::ofRepoIdOrNull);

		final Timestamp dateInvoiced = DataTableUtil.extractDateTimestampForColumnName(row, COLUMNNAME_DateInvoiced);

		final String conversionType = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_ConversionType_ID + "." + I_C_ConversionType.COLUMNNAME_Name);
		final CurrencyConversionTypeId conversionTypeId = queryBL.createQueryBuilder(I_C_ConversionType.class)
				.addOnlyActiveRecordsFilter()
				.addEqualsFilter(I_C_ConversionType.COLUMNNAME_Name, conversionType)
				.orderBy(I_C_ConversionType.COLUMNNAME_Name)
				.create()
				.firstId(CurrencyConversionTypeId::ofRepoIdOrNull);

		final boolean soTrx = DataTableUtil.extractBooleanForColumnName(row, COLUMNNAME_IsSOTrx);

		final String isoCode = DataTableUtil.extractStringForColumnName(row, I_C_Currency.Table_Name + "." + I_C_Currency.COLUMNNAME_ISO_Code);
		final CurrencyId currencyId = currencyRepository.getCurrencyIdByCurrencyCode(CurrencyCode.ofThreeLetterCode(isoCode));

		final I_C_Invoice invoice = InterfaceWrapperHelper.newInstance(I_C_Invoice.class);

		invoice.setC_BPartner_ID(bPartnerId);
		invoice.setC_DocTypeTarget_ID(docTypeId.getRepoId());
		invoice.setC_DocType_ID(docTypeId.getRepoId());
		invoice.setDateInvoiced(dateInvoiced);
		invoice.setIsSOTrx(soTrx);
		invoice.setC_ConversionType_ID(conversionTypeId.getRepoId());
		invoice.setC_Currency_ID(currencyId.getRepoId());

		final String documentNo = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_DocumentNo);
		if (Check.isNotBlank(documentNo))
		{
			invoice.setDocumentNo(documentNo);
		}

		final String externalId = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_ExternalId);
		if (Check.isNotBlank(externalId))
		{
			invoice.setExternalId(externalId);
		}

		invoiceDAO.save(invoice);

		final String invoiceIdentifier = DataTableUtil.extractStringForColumnName(row, TABLECOLUMN_IDENTIFIER);
		invoiceTable.putOrReplace(invoiceIdentifier, invoice);
	}

	@And("update C_Invoice:")
	public void update_C_Invoice(@NonNull final DataTable dataTable)
	{
		for (final Map<String, String> row : dataTable.asMaps())
		{
			updateInvoice(row);
		}
	}

	private void updateInvoice(@NonNull final Map<String, String> row)
	{
		final String invoiceIdentifier = DataTableUtil.extractRecordIdentifier(row, "C_Invoice");

		final I_C_Invoice invoice = invoiceTable.get(invoiceIdentifier);

		final Timestamp dateInvoiced = DataTableUtil.extractDateTimestampForColumnNameOrNull(row, "OPT." + COLUMNNAME_DateInvoiced);
		if (dateInvoiced != null)
		{
			invoice.setDateInvoiced(dateInvoiced);
		}

		final String paymentTerm = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_C_PaymentTerm_ID);
		if (Check.isNotBlank(paymentTerm))
		{
			final PaymentTermQuery query = PaymentTermQuery.builder()
					.orgId(StepDefConstants.ORG_ID)
					.value(paymentTerm)
					.build();

			final PaymentTermId paymentTermId = paymentTermRepo.retrievePaymentTermId(query)
					.orElse(null);

			assertThat(paymentTermId).isNotNull();

			invoice.setC_PaymentTerm_ID(paymentTermId.getRepoId());
		}

		final Timestamp dueDate = DataTableUtil.extractDateTimestampForColumnNameOrNull(row, "OPT." + COLUMNNAME_DueDate);
		if (dueDate != null)
		{
			invoice.setDueDate(dueDate);
		}

		InterfaceWrapperHelper.save(invoice);

		invoiceTable.putOrReplace(invoiceIdentifier, invoice);
	}

	@NonNull
	private ItemProvider.ProviderResult<InvoiceCandidateId> loadInvoiceCandidateReadyToBeProcessed(@NonNull final OrderId targetOrderId)
	{
		final InvoiceCandidateId invoiceCandidateId = invoiceCandDAO.getFirstInvoiceableInvoiceCandId(targetOrderId).getFirstInvoiceableInvoiceCandId();

		if (invoiceCandidateId == null)
		{
			return ItemProvider.ProviderResult.resultWasNotFound("No Invoiceable Invoice Candidate found for OrderId=" + targetOrderId.getRepoId());
		}

		return ItemProvider.ProviderResult.resultWasFound(invoiceCandidateId);
	}

	public Boolean loadInvoice(@NonNull final Map<String, String> row)
	{
		final String invoiceIdentifierCandidate = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_ID + "." + TABLECOLUMN_IDENTIFIER);
		final ImmutableList<String> invoiceIdentifiers = StepDefUtil.extractIdentifiers(invoiceIdentifierCandidate);

		if (invoiceIdentifiers.isEmpty())
		{
			throw new RuntimeException("No invoice identifier present for column: " + COLUMNNAME_C_Invoice_ID + "." + TABLECOLUMN_IDENTIFIER);
		}

		final boolean lookingForMultipleInvoices = invoiceIdentifiers.size() > 1;

		return lookingForMultipleInvoices ? loadMultipleInvoices(row) : loadSingleInvoiceByDocStatus(row);
	}

	private Boolean loadMultipleInvoices(@NonNull final Map<String, String> row)
	{
		final String invoiceCandIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_Candidate_ID + "." + TABLECOLUMN_IDENTIFIER);
		final I_C_Invoice_Candidate invoiceCandidate = invoiceCandTable.get(invoiceCandIdentifier);

		final InvoiceCandidateId invoiceCandidateId = InvoiceCandidateId.ofRepoId(invoiceCandidate.getC_Invoice_Candidate_ID());

		final Set<InvoiceId> invoiceIds = invoiceCandDAO.retrieveIlForIc(invoiceCandidateId)
				.stream()
				.map(I_C_InvoiceLine::getC_Invoice_ID)
				.map(InvoiceId::ofRepoId)
				.collect(ImmutableSet.toImmutableSet());

		final String invoiceIdCandidate = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_ID + "." + StepDefConstants.TABLECOLUMN_IDENTIFIER);

		final ImmutableList<String> invoiceIdentifiers = StepDefUtil.extractIdentifiers(invoiceIdCandidate);

		if (invoiceIds.size() != invoiceIdentifiers.size())
		{
			return false;
		}

		final List<I_C_Invoice> invoices = invoiceDAO.getByIdsOutOfTrx(invoiceIds)
				.stream()
				.sorted(Comparator.comparingInt(I_C_Invoice::getC_Invoice_ID))
				.collect(ImmutableList.toImmutableList());

		assertThat(invoices).isNotEmpty();
		assertThat(invoices.size()).isEqualTo(invoiceIdentifiers.size());

		for (int invoiceIndex = 0; invoiceIndex < invoices.size(); invoiceIndex++)
		{
			invoiceTable.putOrReplace(invoiceIdentifiers.get(invoiceIndex), invoices.get(invoiceIndex));
		}

		return true;
	}

	private Boolean loadSingleInvoiceByDocStatus(@NonNull final Map<String, String> row)
	{
		final String invoiceCandIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_Candidate_ID + "." + TABLECOLUMN_IDENTIFIER);
		final I_C_Invoice_Candidate invoiceCandidate = invoiceCandTable.get(invoiceCandIdentifier);

		final InvoiceCandidateId invoiceCandidateId = InvoiceCandidateId.ofRepoId(invoiceCandidate.getC_Invoice_Candidate_ID());

		final Set<InvoiceId> invoiceIds = invoiceCandDAO.retrieveIlForIc(invoiceCandidateId)
				.stream()
				.map(I_C_InvoiceLine::getC_Invoice_ID)
				.map(InvoiceId::ofRepoId)
				.collect(ImmutableSet.toImmutableSet());

		if (invoiceIds.isEmpty())
		{
			return false;
		}

		final List<I_C_Invoice> invoices = invoiceDAO.getByIdsOutOfTrx(invoiceIds);

		final String invoiceStatus = DataTableUtil.extractStringOrNullForColumnName(row, "OPT." + I_C_Invoice.COLUMNNAME_DocStatus);
		final String docStatus = Optional.ofNullable(invoiceStatus)
				.orElse(X_C_Invoice.DOCACTION_Complete);

		final Optional<I_C_Invoice> invoice = invoices.stream()
				.filter(i -> i.getDocStatus().equals(docStatus))
				.findFirst();

		if (!invoice.isPresent())
		{
			return false;
		}

		final String invoiceIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_Invoice_ID + "." + TABLECOLUMN_IDENTIFIER);
		invoiceTable.putOrReplace(invoiceIdentifier, invoice.get());

		return true;
	}

}
