package com.unispace.lms.dto.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanAssessmentAdditionalScoreDto {
  private String category;

  private Integer score;
}
