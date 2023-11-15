package com.unispace.lms.dto.plan;

import com.unispace.lms.enums.GoalCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanAssessmentScoreDto {
  private GoalCategory category;

  private Integer score;

  private String comment;
}
