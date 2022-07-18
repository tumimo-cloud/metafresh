/*
 * #%L
 * de.metas.business
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

package de.metas.project.workorder;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSet;
import de.metas.calendar.util.CalendarDateRange;
import de.metas.organization.IOrgDAO;
import de.metas.organization.OrgId;
import de.metas.product.ResourceId;
import de.metas.project.ProjectId;
import de.metas.util.Services;
import de.metas.util.StringUtils;
import de.metas.workflow.WFDurationUnit;
import lombok.NonNull;
import org.adempiere.ad.dao.IQueryBL;
import org.adempiere.ad.dao.IQueryBuilder;
import org.compiere.model.I_C_Project_WO_Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

@Repository
public class WOProjectResourceRepository
{
	private static final IOrgDAO orgDAO = Services.get(IOrgDAO.class);
	private final IQueryBL queryBL = Services.get(IQueryBL.class);

	public WOProjectResourcesCollection getByProjectIds(@NonNull final Set<ProjectId> projectIds)
	{
		if (projectIds.isEmpty())
		{
			return WOProjectResourcesCollection.EMPTY;
		}

		final ImmutableListMultimap<ProjectId, WOProjectResource> byProjectId = queryBL.createQueryBuilder(I_C_Project_WO_Resource.class)
				.addOnlyActiveRecordsFilter()
				.addInArrayFilter(I_C_Project_WO_Resource.COLUMNNAME_C_Project_ID, projectIds)
				.stream()
				.map(WOProjectResourceRepository::fromRecord)
				.collect(ImmutableListMultimap.toImmutableListMultimap(WOProjectResource::getProjectId, Function.identity()));

		return projectIds.stream()
				.map(projectId -> WOProjectResources.builder()
						.projectId(projectId)
						.resources(byProjectId.get(projectId))
						.build())
				.collect(WOProjectResourcesCollection.collect());
	}

	public WOProjectResources getByProjectId(@NonNull final ProjectId projectId)
	{
		return getByProjectIds(ImmutableSet.of(projectId)).get(projectId);
	}

	public Stream<WOProjectResource> streamByResourceIds(
			@NonNull final Set<ResourceId> resourceIds,
			@Nullable final Set<ProjectId> onlyProjectIds)
	{
		if (resourceIds.isEmpty())
		{
			return Stream.empty();
		}

		final IQueryBuilder<I_C_Project_WO_Resource> queryBuilder = queryBL.createQueryBuilder(I_C_Project_WO_Resource.class)
				.addOnlyActiveRecordsFilter()
				.addInArrayFilter(I_C_Project_WO_Resource.COLUMNNAME_S_Resource_ID, resourceIds);

		if (onlyProjectIds != null && !onlyProjectIds.isEmpty())
		{
			queryBuilder.addInArrayFilter(I_C_Project_WO_Resource.COLUMNNAME_C_Project_ID, onlyProjectIds);
		}

		return queryBuilder.stream()
				.map(WOProjectResourceRepository::fromRecord);
	}

	public static WOProjectResource fromRecord(@NonNull final I_C_Project_WO_Resource record)
	{
		final TemporalUnit durationUnit = WFDurationUnit.ofCode(record.getDurationUnit()).getTemporalUnit();
		final ProjectId projectId = ProjectId.ofRepoId(record.getC_Project_ID());
		
		return WOProjectResource.builder()
				.id(WOProjectResourceId.ofRepoId(projectId, record.getC_Project_WO_Resource_ID()))
				.projectId(projectId)
				.stepId(WOProjectStepId.ofRepoId(projectId, record.getC_Project_WO_Step_ID()))
				.resourceId(ResourceId.ofRepoId(record.getS_Resource_ID()))
				.dateRange(CalendarDateRange.builder()
						.startDate(record.getAssignDateFrom().toInstant())
						.endDate(record.getAssignDateTo().toInstant())
						.allDay(record.isAllDay())
						.build())
				.durationUnit(durationUnit)
				.duration(Duration.of(record.getDuration().longValue(), durationUnit))
				.description(StringUtils.trimBlankToNull(record.getDescription()))
				.build();
	}
}
