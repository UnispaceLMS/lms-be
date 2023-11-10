package com.unispace.lms.model.plan;

import com.unispace.lms.model.plan.goal.Goal;
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
import jakarta.persistence.UniqueConstraint;
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
@Table(
    name = "annual_plan",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"studentId", "year"})})
public class AnnualPlan {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer studentId;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "goal_id", referencedColumnName = "id")
  private Goal goal;

  private Integer year;

  @Transient
  public static void prepareForUpsert(AnnualPlan newEntity, AnnualPlan existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (Objects.isNull(newEntity.getGoal())) {
      newEntity.setGoal(existingEntity.getGoal());
    } else {
      Goal.prepareForUpsert(newEntity.getGoal(), existingEntity.getGoal());
    }
  }
}
