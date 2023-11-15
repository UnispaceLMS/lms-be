package com.unispace.lms.model.plan.goal;

import com.unispace.lms.enums.plan.PlanGoalPersonalManagementType;
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
@Table(name = "plan_goal_personal_management_entry")
public class PlanGoalPersonalManagementEntry extends PlanGoalEntry {
  @Enumerated(EnumType.STRING)
  private PlanGoalPersonalManagementType type;
}
