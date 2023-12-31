package com.unispace.lms.dto.plan;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanAssessmentDto {
  private String purpose;

  private List<PlanAssessmentScoreDto> scores;

  private List<PlanAssessmentAdditionalScoreDto> additionalScores;
}
