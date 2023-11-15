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
@Table(name = "plan_goal_transportation")
public class PlanGoalTransportation {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String annualGoal;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "plan_goal_transportation_entry")
  private List<PlanGoalTransportationEntry> transportationEntries;

  @Transient
  public static void prepareForUpsert(
      PlanGoalTransportation newEntity, PlanGoalTransportation existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (StringUtils.isBlank(newEntity.getAnnualGoal())) {
      newEntity.setAnnualGoal(existingEntity.getAnnualGoal());
    }
    if (CollectionUtils.isEmpty(newEntity.getTransportationEntries())) {
      newEntity.setTransportationEntries(existingEntity.getTransportationEntries());
    }
  }

  public static void filterByQuarter(
      PlanGoalTransportation transportation, Integer year, Integer quarterNumber) {
    if (Objects.isNull(transportation) || Objects.isNull(quarterNumber) || Objects.isNull(year)) {
      return;
    }
    Pair<Date, Date> dateRange = PlanUtil.getDateRangeForQuarter(year, quarterNumber);
    transportation.setTransportationEntries(
        transportation.getTransportationEntries().stream()
            .filter(
                entry ->
                    entry.getDate().after(dateRange.getFirst())
                        && entry.getDate().before(dateRange.getSecond()))
            .collect(Collectors.toList()));
  }
}
