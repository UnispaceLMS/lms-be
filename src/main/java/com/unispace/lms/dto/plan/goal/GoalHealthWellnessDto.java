package com.unispace.lms.dto.plan.goal;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalHealthWellnessDto {
  private String annualGoal;

  private List<GoalHealthWellnessEntryDto> healthWellnessEntries;
}
