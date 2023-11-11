package com.unispace.lms.dto.plan;

import com.unispace.lms.enums.GoalCategory;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanAssessmentDto {
  Map<GoalCategory, Integer> scores;

  Map<String, Integer> additionalScores;
}
