package com.unispace.lms.model.plan.goal;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plan_goal_healthy_relationship")
public class PlanGoalHealthyRelationship {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String annualGoal;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "plan_goal_healthy_relationship_entry")
  private List<PlanGoalHealthyRelationshipEntry> healthyRelationshipEntries;

  @Transient
  public static void prepareForUpsert(
      PlanGoalHealthyRelationship newEntity, PlanGoalHealthyRelationship existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (StringUtils.isBlank(newEntity.getAnnualGoal())) {
      newEntity.setAnnualGoal(existingEntity.getAnnualGoal());
    }
    if (CollectionUtils.isEmpty(newEntity.getHealthyRelationshipEntries())) {
      newEntity.setHealthyRelationshipEntries(existingEntity.getHealthyRelationshipEntries());
    }
  }
}
