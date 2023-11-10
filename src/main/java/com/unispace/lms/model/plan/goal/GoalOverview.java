package com.unispace.lms.model.plan.goal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "goal_overview")
public class GoalOverview {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String independentLiving;

  private String education;

  private String communityParticipation;

  private String career;

  public static void prepareForUpsert(GoalOverview newEntity, GoalOverview existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (StringUtils.isBlank(newEntity.getIndependentLiving())) {
      newEntity.setIndependentLiving(existingEntity.getIndependentLiving());
    }
    if (StringUtils.isBlank(newEntity.getEducation())) {
      newEntity.setEducation(existingEntity.getEducation());
    }
    if (StringUtils.isBlank(newEntity.getCommunityParticipation())) {
      newEntity.setCommunityParticipation(existingEntity.getCommunityParticipation());
    }
    if (StringUtils.isBlank(newEntity.getCareer())) {
      newEntity.setCareer(existingEntity.getCareer());
    }
  }
}
