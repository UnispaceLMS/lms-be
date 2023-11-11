package com.unispace.lms.dto.plan.goal;

import com.unispace.lms.enums.plan.PlanGoalHealthWellnessType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlanGoalHealthWellnessEntryDto extends PlanGoalEntryDto {
  private PlanGoalHealthWellnessType type;
}
