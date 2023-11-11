package com.unispace.lms.dto.plan.goal;

import com.unispace.lms.enums.plan.PlanGoalSchedule;
import com.unispace.lms.enums.plan.PlanGoalAssessmentType;
import java.util.Date;

import com.unispace.lms.enums.plan.PlanGoalStatus;
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

  private PlanGoalAssessmentType assessmentType;

  private PlanGoalSchedule schedule;

  private String criteria;

  private PlanGoalStatus status;
}
