package com.unispace.lms.model.plan.goal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plan_goal")
public class PlanGoal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "overview_id", referencedColumnName = "id")
  private PlanGoalOverview overview;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "health_wellness_id", referencedColumnName = "id")
  private PlanGoalHealthWellness healthWellness;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "personal_management_id", referencedColumnName = "id")
  private PlanGoalPersonalManagement personalManagement;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "home_management_id", referencedColumnName = "id")
  private PlanGoalHomeManagement homeManagement;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "safety_id", referencedColumnName = "id")
  private PlanGoalSafety safety;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "transportation_id", referencedColumnName = "id")
  private PlanGoalTransportation transportation;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "healthy_relationship_id", referencedColumnName = "id")
  private PlanGoalHealthyRelationship healthyRelationship;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "money_management_id", referencedColumnName = "id")
  private PlanGoalMoneyManagement moneyManagement;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "employment_id", referencedColumnName = "id")
  private PlanGoalEmployment employment;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "misc_id", referencedColumnName = "id")
  private PlanGoalMiscellaneous miscellaneous;

  @Transient
  public static void prepareForUpsert(PlanGoal newEntity, PlanGoal existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (Objects.isNull(newEntity.getOverview())) {
      newEntity.setOverview(existingEntity.getOverview());
    } else {
      PlanGoalOverview.prepareForUpsert(newEntity.getOverview(), existingEntity.getOverview());
    }
    if (Objects.isNull(newEntity.getHealthWellness())) {
      newEntity.setHealthWellness(existingEntity.getHealthWellness());
    } else {
      PlanGoalHealthWellness.prepareForUpsert(
          newEntity.getHealthWellness(), existingEntity.getHealthWellness());
    }
    if (Objects.isNull(newEntity.getPersonalManagement())) {
      newEntity.setPersonalManagement(existingEntity.getPersonalManagement());
    } else {
      PlanGoalPersonalManagement.prepareForUpsert(
          newEntity.getPersonalManagement(), existingEntity.getPersonalManagement());
    }
    if (Objects.isNull(newEntity.getHomeManagement())) {
      newEntity.setHomeManagement(existingEntity.getHomeManagement());
    } else {
      PlanGoalHomeManagement.prepareForUpsert(
          newEntity.getHomeManagement(), existingEntity.getHomeManagement());
    }
    if (Objects.isNull(newEntity.getSafety())) {
      newEntity.setSafety(existingEntity.getSafety());
    } else {
      PlanGoalSafety.prepareForUpsert(newEntity.getSafety(), existingEntity.getSafety());
    }
    if (Objects.isNull(newEntity.getTransportation())) {
      newEntity.setTransportation(existingEntity.getTransportation());
    } else {
      PlanGoalTransportation.prepareForUpsert(
          newEntity.getTransportation(), existingEntity.getTransportation());
    }
    if (Objects.isNull(newEntity.getHealthyRelationship())) {
      newEntity.setHealthyRelationship(existingEntity.getHealthyRelationship());
    } else {
      PlanGoalHealthyRelationship.prepareForUpsert(
          newEntity.getHealthyRelationship(), existingEntity.getHealthyRelationship());
    }
    if (Objects.isNull(newEntity.getMoneyManagement())) {
      newEntity.setMoneyManagement(existingEntity.getMoneyManagement());
    } else {
      PlanGoalMoneyManagement.prepareForUpsert(
          newEntity.getMoneyManagement(), existingEntity.getMoneyManagement());
    }
    if (Objects.isNull(newEntity.getEmployment())) {
      newEntity.setEmployment(existingEntity.getEmployment());
    } else {
      PlanGoalEmployment.prepareForUpsert(
          newEntity.getEmployment(), existingEntity.getEmployment());
    }
    if (Objects.isNull(newEntity.getMiscellaneous())) {
      newEntity.setMiscellaneous(existingEntity.getMiscellaneous());
    } else {
      PlanGoalMiscellaneous.prepareForUpsert(
          newEntity.getMiscellaneous(), existingEntity.getMiscellaneous());
    }
  }
}
