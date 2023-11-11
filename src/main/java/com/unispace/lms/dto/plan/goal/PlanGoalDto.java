package com.unispace.lms.dto.plan.goal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanGoalDto {
  private PlanGoalOverviewDto overview;

  private PlanGoalHealthWellnessDto healthWellness;

  private PlanGoalPersonalManagementDto personalManagement;

  private PlanGoalHomeManagementDto homeManagement;

  private PlanGoalSafetyDto safety;

  private PlanGoalTransportationDto transportation;

  private PlanGoalHealthyRelationshipDto healthyRelationship;

  private PlanGoalMoneyManagementDto moneyManagement;

  private PlanGoalEmploymentDto employment;

  private PlanGoalMiscellaneousDto miscellaneous;
}
