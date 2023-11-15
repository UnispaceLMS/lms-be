package com.unispace.lms.model.plan.goal;

import com.unispace.lms.util.PlanUtil;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.util.Pair;
import org.springframework.util.CollectionUtils;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plan_goal_miscellaneous")
public class PlanGoalMiscellaneous {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String annualGoal;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "goal_miscellaneous_id", referencedColumnName = "id")
  private List<PlanGoalMiscellaneousEntry> miscellaneousEntries;

  @Transient
  public static void prepareForUpsert(
      PlanGoalMiscellaneous newEntity, PlanGoalMiscellaneous existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (StringUtils.isBlank(newEntity.getAnnualGoal())) {
      newEntity.setAnnualGoal(existingEntity.getAnnualGoal());
    }
    if (CollectionUtils.isEmpty(newEntity.getMiscellaneousEntries())) {
      newEntity.setMiscellaneousEntries(existingEntity.getMiscellaneousEntries());
    }
  }

  public static void filterByQuarter(
      PlanGoalMiscellaneous miscellaneous, Integer year, Integer quarterNumber) {
    if (Objects.isNull(miscellaneous) || Objects.isNull(quarterNumber) || Objects.isNull(year)) {
      return;
    }
    Pair<Date, Date> dateRange = PlanUtil.getDateRangeForQuarter(year, quarterNumber);
    miscellaneous.setMiscellaneousEntries(
        miscellaneous.getMiscellaneousEntries().stream()
            .filter(
                entry ->
                    entry.getDate().after(dateRange.getFirst())
                        && entry.getDate().before(dateRange.getSecond()))
            .collect(Collectors.toList()));
  }
}
