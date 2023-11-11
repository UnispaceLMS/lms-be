package com.unispace.lms.dto.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanVisionDto {
  private String employmentGoals;

  private String independentLivingGoals;

  private String communityParticipation;

  private String postSecondaryEducationTraining;
}
