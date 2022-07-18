package de.metas.project.workorder.conflicts;

import de.metas.calendar.simulation.SimulationPlanId;
import de.metas.calendar.util.CalendarDateRange;
import de.metas.product.ResourceId;
import de.metas.project.workorder.WOProjectAndResourceId;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import javax.annotation.Nullable;

@Value
@Builder
class ResourceAllocation
{
	@NonNull ResourceId resourceId;
	@NonNull WOProjectAndResourceId projectAndResourceId;
	@Nullable SimulationPlanId appliedSimulationId;
	@NonNull CalendarDateRange dateRange;

	public boolean isInConflictWith(@NonNull ResourceAllocation other)
	{
		return ResourceId.equals(this.resourceId, other.resourceId)
				&& this.dateRange.isOverlappingWith(other.dateRange);
	}
}
