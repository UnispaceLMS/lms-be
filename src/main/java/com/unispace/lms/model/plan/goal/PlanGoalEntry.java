package com.unispace.lms.model.plan.goal;

import com.unispace.lms.enums.plan.PlanGoalAssessmentType;
import com.unispace.lms.enums.plan.PlanGoalSchedule;
import com.unispace.lms.enums.plan.PlanGoalStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class PlanGoalEntry {
  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  @Temporal(TemporalType.DATE)
  private Date date;

  private String shortTermObjective;

  @Enumerated(EnumType.STRING)
  private PlanGoalAssessmentType assessmentType;

  @Enumerated(EnumType.STRING)
  private PlanGoalSchedule schedule;

  private String criteria;

  private PlanGoalStatus status;
}
