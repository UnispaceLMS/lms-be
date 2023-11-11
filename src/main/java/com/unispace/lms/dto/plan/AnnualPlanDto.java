package com.unispace.lms.dto.plan;

import com.unispace.lms.dto.plan.goal.PlanGoalDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnualPlanDto {
  private Integer studentId;

  private Integer year;

  private PlanGoalDto goal;

  private PlanPresentLevelDto presentLevel;

  private PlanAssessmentDto assessment;

  private PlanVisionDto vision;
}
