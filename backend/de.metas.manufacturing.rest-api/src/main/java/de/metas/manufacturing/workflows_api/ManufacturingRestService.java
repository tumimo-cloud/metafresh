package de.metas.manufacturing.workflows_api;

import com.google.common.collect.ImmutableList;
import de.metas.i18n.TranslatableStrings;
import de.metas.manufacturing.job.ManufacturingJob;
import de.metas.manufacturing.job.ManufacturingJobActivity;
import de.metas.manufacturing.job.ManufacturingJobActivityId;
import de.metas.manufacturing.job.ManufacturingJobReference;
import de.metas.manufacturing.job.ManufacturingJobService;
import de.metas.manufacturing.workflows_api.activity_handlers.ConfirmationActivityHandler;
import de.metas.manufacturing.workflows_api.activity_handlers.MaterialReceiptActivityHandler;
import de.metas.manufacturing.workflows_api.activity_handlers.RawMaterialsIssueActivityHandler;
import de.metas.manufacturing.workflows_api.activity_handlers.WorkReportActivityHandler;
import de.metas.user.UserId;
import de.metas.workflow.rest_api.model.WFActivity;
import de.metas.workflow.rest_api.model.WFActivityId;
import de.metas.workflow.rest_api.model.WFActivityStatus;
import de.metas.workflow.rest_api.model.WFProcess;
import de.metas.workflow.rest_api.model.WFProcessId;
import lombok.NonNull;
import org.adempiere.ad.dao.QueryLimit;
import org.adempiere.exceptions.AdempiereException;
import org.eevolution.api.PPOrderId;
import org.eevolution.api.PPOrderRoutingActivityStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ManufacturingRestService
{
	private final ManufacturingJobService manufacturingJobService;

	public ManufacturingRestService(final ManufacturingJobService manufacturingJobService)
	{
		this.manufacturingJobService = manufacturingJobService;
	}

	public Stream<ManufacturingJobReference> streamJobReferencesForUser(final @NonNull UserId responsibleId, final @NonNull QueryLimit suggestedLimit)
	{
		return manufacturingJobService.streamJobReferencesForUser(responsibleId, suggestedLimit);
	}

	public ManufacturingJob createJob(final PPOrderId ppOrderId, final UserId responsibleId)
	{
		return manufacturingJobService.createJob(ppOrderId, responsibleId);
	}

	public ManufacturingJob getJobById(final PPOrderId ppOrderId)
	{
		return manufacturingJobService.getJobById(ppOrderId);
	}

	private static WFActivity toWFActivity(final ManufacturingJobActivity jobActivity)
	{
		final WFActivity.WFActivityBuilder builder = WFActivity.builder()
				.id(WFActivityId.ofId(jobActivity.getId()))
				.caption(TranslatableStrings.anyLanguage(jobActivity.getName()))
				.status(toWFActivityStatus(jobActivity.getStatus()));

		switch (jobActivity.getType())
		{
			case RawMaterialsIssue:
				return builder.wfActivityType(RawMaterialsIssueActivityHandler.HANDLED_ACTIVITY_TYPE).build();
			case MaterialReceipt:
				return builder.wfActivityType(MaterialReceiptActivityHandler.HANDLED_ACTIVITY_TYPE).build();
			case WorkReport:
				return builder.wfActivityType(WorkReportActivityHandler.HANDLED_ACTIVITY_TYPE).build();
			case ActivityConfirmation:
				return builder.wfActivityType(ConfirmationActivityHandler.HANDLED_ACTIVITY_TYPE).build();
			default:
				throw new AdempiereException("Unknown type: " + jobActivity);
		}
	}

	public static WFProcess toWFProcess(final ManufacturingJob job)
	{
		return WFProcess.builder()
				.id(WFProcessId.ofIdPart(ManufacturingMobileApplication.HANDLER_ID, job.getPpOrderId()))
				.invokerId(Objects.requireNonNull(job.getResponsibleId()))
				.caption(TranslatableStrings.anyLanguage("" + job.getPpOrderId().getRepoId())) // TODO
				.document(job)
				.activities(job.getActivities()
						.stream()
						.map(ManufacturingRestService::toWFActivity)
						.collect(ImmutableList.toImmutableList()))
				.build();
	}

	private static WFActivityStatus toWFActivityStatus(final @NonNull PPOrderRoutingActivityStatus status)
	{
		switch (status)
		{
			case NOT_STARTED:
				return WFActivityStatus.NOT_STARTED;
			case IN_PROGRESS:
				return WFActivityStatus.IN_PROGRESS;
			case COMPLETED:
				return WFActivityStatus.COMPLETED;
			case CLOSED:
				return WFActivityStatus.COMPLETED;
			case VOIDED:
				return WFActivityStatus.COMPLETED;
			default:
				throw new AdempiereException("Unknown status: " + status);
		}
	}

	public ManufacturingJob withActivityCompleted(ManufacturingJob job, ManufacturingJobActivityId jobActivityId) {return manufacturingJobService.withActivityCompleted(job, jobActivityId);}
}