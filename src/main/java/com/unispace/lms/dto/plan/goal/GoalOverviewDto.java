package com.unispace.lms.dto.plan.goal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalOverviewDto {
  private String independentLiving;

  private String education;

  private String communityParticipation;

  private String career;
}
