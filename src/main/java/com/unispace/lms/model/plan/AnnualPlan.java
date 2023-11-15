package com.unispace.lms.model.plan;

import com.unispace.lms.model.plan.goal.PlanGoal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "annual_plan",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"studentId", "year"})})
public class AnnualPlan {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer studentId;

  private Integer year;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "goal_id", referencedColumnName = "id")
  private PlanGoal goal;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "present_level_id", referencedColumnName = "id")
  private PlanPresentLevel presentLevel;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "assessment_id", referencedColumnName = "id")
  private PlanAssessment assessment;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "vision_id", referencedColumnName = "id")
  private PlanVision vision;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "annual_plan_id", referencedColumnName = "id")
  @Size(max = 4)
  private List<PlanQuarterlyAssessment> quarterlyAssessments;

  // todo: delete row instead of setting foreign key = null
  @Transient
  public static void prepareForUpsert(AnnualPlan newEntity, AnnualPlan existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (Objects.isNull(newEntity.getGoal())) {
      newEntity.setGoal(existingEntity.getGoal());
    } else {
      PlanGoal.prepareForUpsert(newEntity.getGoal(), existingEntity.getGoal());
    }
    if (CollectionUtils.isEmpty(newEntity.getQuarterlyAssessments())) {
      newEntity.setQuarterlyAssessments(existingEntity.getQuarterlyAssessments());
    } else {
      if (!CollectionUtils.isEmpty(existingEntity.getQuarterlyAssessments())) {
        PlanQuarterlyAssessment.prepareForUpsert(
            newEntity.getQuarterlyAssessments(), existingEntity.getQuarterlyAssessments());
      }
    }
  }

  @Transient
  public static void filterByQuarter(AnnualPlan annualPlan, Integer quarterNumber) {
    if (Objects.isNull(annualPlan) || Objects.isNull(quarterNumber)) {
      return;
    }
    annualPlan.setPresentLevel(null);
    annualPlan.setAssessment(null);
    annualPlan.setVision(null);
    if (Objects.nonNull(annualPlan.getGoal())) {
      PlanGoal.filterByQuarter(annualPlan.getGoal(), annualPlan.getYear(), quarterNumber);
    }
    annualPlan.setQuarterlyAssessments(
        annualPlan.getQuarterlyAssessments().stream()
            .filter(
                planQuarterlyAssessment ->
                    quarterNumber.equals(planQuarterlyAssessment.getQuarterNumber()))
            .collect(Collectors.toList()));
  }
}
