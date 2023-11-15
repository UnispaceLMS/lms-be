package com.unispace.lms.model.plan.goal;

import com.unispace.lms.enums.plan.PlanGoalEmploymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "plan_goal_employment_entry")
public class PlanGoalEmploymentEntry extends PlanGoalEntry {
  @Enumerated(EnumType.STRING)
  private PlanGoalEmploymentType type;
}
