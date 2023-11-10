package com.unispace.lms.dto.plan.goal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalDto {
  private GoalOverviewDto overview;

  private GoalHealthWellnessDto healthWellness;

  private GoalPersonalManagementDto personalManagement;

  private GoalHomeManagementDto homeManagement;

  private GoalSafetyDto safety;

  private GoalTransportationDto transportation;

  private GoalHealthyRelationshipDto healthyRelationship;

  private GoalMoneyManagementDto moneyManagement;

  private GoalEmploymentDto employment;

  private GoalMiscellaneousDto miscellaneous;
}
