package com.unispace.lms.model.plan;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PlanAssessmentAdditionalScore {
  private String category;

  private Integer score;
}
