package com.unispace.lms.dto.plan;

import com.unispace.lms.dto.plan.goal.GoalDto;
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

  private GoalDto goal;
}
