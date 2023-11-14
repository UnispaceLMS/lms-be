package com.unispace.lms.model.plan;

import com.unispace.lms.enums.GoalCategory;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PlanAssessmentScore {
  @Enumerated(EnumType.STRING)
  private GoalCategory category;

  private Integer score;
}
