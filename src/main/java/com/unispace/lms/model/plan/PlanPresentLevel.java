package com.unispace.lms.model.plan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plan_present_level")
public class PlanPresentLevel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String academicAchievement;

  private String academicAchievementImpactResultNeeded;

  private String employmentSkills;

  private String employmentSkillsImpactResultNeeded;

  private String independentLivingSkills;

  private String independentLivingSkillsImpactResultNeeded;

  private String communityParticipationSkills;

  private String communityParticipationSkillsImpactResultNeeded;
}
