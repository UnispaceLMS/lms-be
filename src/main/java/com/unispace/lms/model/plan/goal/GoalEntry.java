package com.unispace.lms.model.plan.goal;

import com.unispace.lms.enums.AssessmentType;
import com.unispace.lms.enums.Schedule;
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
public class GoalEntry {
  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  @Temporal(TemporalType.DATE)
  private Date date;

  private String shortTermObjective;

  @Enumerated(EnumType.STRING)
  private AssessmentType assessmentType;

  @Enumerated(EnumType.STRING)
  private Schedule schedule;

  private String criteria;
}
