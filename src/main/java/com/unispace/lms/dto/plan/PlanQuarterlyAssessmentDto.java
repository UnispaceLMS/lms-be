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
public class PlanQuarterlyAssessmentDto {
  private Integer quarterNumber;

  private String studentStrengths;

  private List<PlanAssessmentScoreDto> scores;
}
