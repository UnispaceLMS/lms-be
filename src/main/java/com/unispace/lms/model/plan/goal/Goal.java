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
@Table(name = "goal")
public class Goal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "overview_id", referencedColumnName = "id")
  private GoalOverview overview;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "health_wellness_id", referencedColumnName = "id")
  private GoalHealthWellness healthWellness;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "personal_management_id", referencedColumnName = "id")
  private GoalPersonalManagement personalManagement;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "home_management_id", referencedColumnName = "id")
  private GoalHomeManagement homeManagement;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "safety_id", referencedColumnName = "id")
  private GoalSafety safety;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "transportation_id", referencedColumnName = "id")
  private GoalTransportation transportation;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "healthy_relationship_id", referencedColumnName = "id")
  private GoalHealthyRelationship healthyRelationship;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "money_management_id", referencedColumnName = "id")
  private GoalMoneyManagement moneyManagement;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "employment_id", referencedColumnName = "id")
  private GoalEmployment employment;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "misc_id", referencedColumnName = "id")
  private GoalMiscellaneous miscellaneous;

  @Transient
  public static void prepareForUpsert(Goal newEntity, Goal existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (Objects.isNull(newEntity.getOverview())) {
      newEntity.setOverview(existingEntity.getOverview());
    } else {
      GoalOverview.prepareForUpsert(newEntity.getOverview(), existingEntity.getOverview());
    }
    if (Objects.isNull(newEntity.getHealthWellness())) {
      newEntity.setHealthWellness(existingEntity.getHealthWellness());
    } else {
      GoalHealthWellness.prepareForUpsert(
          newEntity.getHealthWellness(), existingEntity.getHealthWellness());
    }
    if (Objects.isNull(newEntity.getPersonalManagement())) {
      newEntity.setPersonalManagement(existingEntity.getPersonalManagement());
    } else {
      GoalPersonalManagement.prepareForUpsert(
          newEntity.getPersonalManagement(), existingEntity.getPersonalManagement());
    }
    if (Objects.isNull(newEntity.getHomeManagement())) {
      newEntity.setHomeManagement(existingEntity.getHomeManagement());
    } else {
      GoalHomeManagement.prepareForUpsert(
          newEntity.getHomeManagement(), existingEntity.getHomeManagement());
    }
    if (Objects.isNull(newEntity.getSafety())) {
      newEntity.setSafety(existingEntity.getSafety());
    } else {
      GoalSafety.prepareForUpsert(newEntity.getSafety(), existingEntity.getSafety());
    }
    if (Objects.isNull(newEntity.getTransportation())) {
      newEntity.setTransportation(existingEntity.getTransportation());
    } else {
      GoalTransportation.prepareForUpsert(
          newEntity.getTransportation(), existingEntity.getTransportation());
    }
    if (Objects.isNull(newEntity.getHealthyRelationship())) {
      newEntity.setHealthyRelationship(existingEntity.getHealthyRelationship());
    } else {
      GoalHealthyRelationship.prepareForUpsert(
          newEntity.getHealthyRelationship(), existingEntity.getHealthyRelationship());
    }
    if (Objects.isNull(newEntity.getMoneyManagement())) {
      newEntity.setMoneyManagement(existingEntity.getMoneyManagement());
    } else {
      GoalMoneyManagement.prepareForUpsert(
          newEntity.getMoneyManagement(), existingEntity.getMoneyManagement());
    }
    if (Objects.isNull(newEntity.getEmployment())) {
      newEntity.setEmployment(existingEntity.getEmployment());
    } else {
      GoalEmployment.prepareForUpsert(newEntity.getEmployment(), existingEntity.getEmployment());
    }
    if (Objects.isNull(newEntity.getMiscellaneous())) {
      newEntity.setMiscellaneous(existingEntity.getMiscellaneous());
    } else {
      GoalMiscellaneous.prepareForUpsert(
          newEntity.getMiscellaneous(), existingEntity.getMiscellaneous());
    }
  }
}
