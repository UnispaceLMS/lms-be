package com.unispace.lms.dto.plan.goal;

import com.unispace.lms.enums.AssessmentType;
import com.unispace.lms.enums.Schedule;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PlanGoalEntryDto {
  private Date date;

  private String shortTermObjective;

  private AssessmentType assessmentType;

  private Schedule schedule;

  private String criteria;
}
