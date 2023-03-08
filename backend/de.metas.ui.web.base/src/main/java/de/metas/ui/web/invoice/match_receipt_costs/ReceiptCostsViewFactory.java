package de.metas.ui.web.invoice.match_receipt_costs;

import com.google.common.collect.ImmutableList;
import de.metas.bpartner.BPartnerId;
import de.metas.i18n.TranslatableStrings;
import de.metas.invoice.InvoiceLineId;
import de.metas.invoice.service.IInvoiceBL;
import de.metas.money.MoneyService;
import de.metas.order.costs.OrderCostService;
import de.metas.process.AdProcessId;
import de.metas.process.IADProcessDAO;
import de.metas.process.RelatedProcessDescriptor;
import de.metas.ui.web.document.filter.DocumentFilter;
import de.metas.ui.web.document.filter.DocumentFilterDescriptor;
import de.metas.ui.web.view.CreateViewRequest;
import de.metas.ui.web.view.IView;
import de.metas.ui.web.view.IViewFactory;
import de.metas.ui.web.view.IViewsRepository;
import de.metas.ui.web.view.ViewCloseAction;
import de.metas.ui.web.view.ViewFactory;
import de.metas.ui.web.view.ViewId;
import de.metas.ui.web.view.ViewProfileId;
import de.metas.ui.web.view.descriptor.ViewLayout;
import de.metas.ui.web.view.json.JSONFilterViewRequest;
import de.metas.ui.web.view.json.JSONViewDataType;
import de.metas.ui.web.window.datatypes.LookupValue;
import de.metas.ui.web.window.datatypes.WindowId;
import de.metas.ui.web.window.descriptor.LookupDescriptorProviders;
import de.metas.ui.web.window.model.lookup.LookupDataSourceFactory;
import de.metas.util.Check;
import de.metas.util.Services;
import lombok.NonNull;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_Invoice;
import org.compiere.model.I_M_InOut_Cost;

import javax.annotation.Nullable;
import java.util.function.Supplier;

@ViewFactory(windowId = ReceiptCostsViewFactory.WINDOWID_String)
public class ReceiptCostsViewFactory implements IViewFactory
{
	public static final String WINDOWID_String = "receiptCosts";
	public static final WindowId WINDOW_ID = WindowId.fromJson(WINDOWID_String);

	private static final String VIEW_PARAM_invoiceLineId = "invoiceLineId";

	private final IInvoiceBL invoiceBL = Services.get(IInvoiceBL.class);
	private final IADProcessDAO adProcessDAO = Services.get(IADProcessDAO.class);
	private final LookupDataSourceFactory lookupDataSourceFactory;
	private final ReceiptCostsViewDataService viewDataService;
	private DocumentFilterDescriptor _filterDescriptor; // lazy

	public ReceiptCostsViewFactory(
			final @NonNull OrderCostService orderCostService,
			final @NonNull MoneyService moneyService,
			final @NonNull LookupDataSourceFactory lookupDataSourceFactory)
	{
		this.lookupDataSourceFactory = lookupDataSourceFactory;
		this.viewDataService = ReceiptCostsViewDataService.builder()
				.orderCostService(orderCostService)
				.moneyService(moneyService)
				.lookupDataSourceFactory(lookupDataSourceFactory)
				.build();
	}

	@Override
	public ViewLayout getViewLayout(final WindowId windowId, final JSONViewDataType viewDataType, final ViewProfileId profileId)
	{
		return ViewLayout.builder()
				.setWindowId(WINDOW_ID)
				.setCaption(TranslatableStrings.adElementOrMessage(I_M_InOut_Cost.COLUMNNAME_M_InOut_Cost_ID))
				.setAllowOpeningRowDetails(false)
				.allowViewCloseAction(ViewCloseAction.CANCEL)
				.allowViewCloseAction(ViewCloseAction.DONE)
				.addElementsFromViewRowClass(ReceiptCostRow.class, viewDataType)
				.setFilters(ImmutableList.of(getFilterDescriptor()))
				.build();
	}

	public final CreateViewRequest createViewRequest(@NonNull final InvoiceLineId invoiceLineId)
	{
		return CreateViewRequest.builder(WINDOW_ID)
				.setParameter(VIEW_PARAM_invoiceLineId, invoiceLineId)
				.setUseAutoFilters(true)
				.build();
	}

	@Override
	public ReceiptCostsView createView(@NonNull final CreateViewRequest request)
	{
		final ViewId viewId = request.getViewId();
		viewId.assertWindowId(WINDOW_ID);

		return ReceiptCostsView.builder()
				.viewId(viewId)
				.rowsData(getViewData(request))
				.filterDescriptor(getFilterDescriptor())
				.relatedProcess(createProcessDescriptor(10, ReceiptCostsView_CreateMatchInv.class))
				.build();
	}

	private ReceiptCostsViewData getViewData(final @NonNull CreateViewRequest request)
	{
		final InvoiceLineId invoiceLineId = getInvoiceLineId(request);
		final DocumentFilter effectiveFilter = getEffectiveFilter(request);
		return viewDataService.getData(invoiceLineId, effectiveFilter);
	}

	@NonNull
	private static InvoiceLineId getInvoiceLineId(final @NonNull CreateViewRequest request)
	{
		return Check.assumeNotNull(request.getParameterAs(VIEW_PARAM_invoiceLineId, InvoiceLineId.class), "No invoiceLineId parameter provided");
	}

	@Nullable
	private DocumentFilter getEffectiveFilter(final @NonNull CreateViewRequest request)
	{
		if (request.isUseAutoFilters())
		{
			final InvoiceLineId invoiceLineId = getInvoiceLineId(request);
			final I_C_Invoice invoice = invoiceBL.getById(invoiceLineId.getInvoiceId());
			final BPartnerId bpartnerId = BPartnerId.ofRepoId(invoice.getC_BPartner_ID());
			final LookupValue bpartner = lookupDataSourceFactory.searchInTableLookup(I_C_BPartner.Table_Name).findById(bpartnerId);

			return DocumentFilter.equalsFilter(ReceiptCostsViewFilterHelper.FILTER_ID, ReceiptCostsViewFilterHelper.PARAM_C_BPartner_ID, bpartner);
		}
		else
		{
			return request.getFiltersUnwrapped(getFilterDescriptor())
					.getFilterById(ReceiptCostsViewFilterHelper.FILTER_ID)
					.orElse(null);
		}
	}

	@SuppressWarnings("SameParameterValue")
	private RelatedProcessDescriptor createProcessDescriptor(final int sortNo, @NonNull final Class<?> processClass)
	{
		final AdProcessId processId = adProcessDAO.retrieveProcessIdByClass(processClass);
		if (processId == null)
		{
			throw new AdempiereException("No processId found for " + processClass);
		}

		return RelatedProcessDescriptor.builder()
				.processId(processId)
				.anyTable().anyWindow()
				.displayPlace(RelatedProcessDescriptor.DisplayPlace.ViewQuickActions)
				.sortNo(sortNo)
				.build();
	}

	private DocumentFilterDescriptor getFilterDescriptor()
	{
		DocumentFilterDescriptor filterDescriptor = this._filterDescriptor;
		if (filterDescriptor == null)
		{
			final LookupDescriptorProviders lookupDescriptorProviders = lookupDataSourceFactory.getLookupDescriptorProviders();
			filterDescriptor = this._filterDescriptor = ReceiptCostsViewFilterHelper.createFilterDescriptor(lookupDescriptorProviders);
		}

		return filterDescriptor;
	}

	@Override
	public ReceiptCostsView filterView(
			final @NonNull IView view,
			final @NonNull JSONFilterViewRequest filterViewRequest,
			final @NonNull Supplier<IViewsRepository> viewsRepo)
	{
		final ReceiptCostsView receiptCostsView = (ReceiptCostsView)view;
		return createView(
				CreateViewRequest.filterViewBuilder(view, filterViewRequest)
						.setParameter(VIEW_PARAM_invoiceLineId, receiptCostsView.getInvoiceLineId())
						.build());
	}
}
