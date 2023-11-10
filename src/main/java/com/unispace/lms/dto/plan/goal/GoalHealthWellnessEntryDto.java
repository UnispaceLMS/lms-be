package com.unispace.lms.dto.plan.goal;

import com.unispace.lms.enums.GoalHealthWellnessType;
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
public class GoalHealthWellnessEntryDto extends GoalEntryDto {
  private GoalHealthWellnessType type;
}
