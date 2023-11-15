package com.unispace.lms.model.plan.goal;

import com.unispace.lms.util.PlanUtil;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.util.Pair;
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

  public static void filterByQuarter(
      PlanGoalHealthyRelationship healthyRelationship, Integer year, Integer quarterNumber) {
    if (Objects.isNull(healthyRelationship)
        || Objects.isNull(quarterNumber)
        || Objects.isNull(year)) {
      return;
    }
    Pair<Date, Date> dateRange = PlanUtil.getDateRangeForQuarter(year, quarterNumber);
    healthyRelationship.setHealthyRelationshipEntries(
        healthyRelationship.getHealthyRelationshipEntries().stream()
            .filter(
                entry ->
                    entry.getDate().after(dateRange.getFirst())
                        && entry.getDate().before(dateRange.getSecond()))
            .collect(Collectors.toList()));
  }
}
