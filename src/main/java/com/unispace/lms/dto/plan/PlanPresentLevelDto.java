package com.unispace.lms.dto.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanPresentLevelDto {
  private String academicAchievement;

  private String academicAchievementImpactResultNeeded;

  private String employmentSkills;

  private String employmentSkillsImpactResultNeeded;

  private String independentLivingSkills;

  private String independentLivingSkillsImpactResultNeeded;

  private String communityParticipationSkills;

  private String communityParticipationSkillsImpactResultNeeded;
}
