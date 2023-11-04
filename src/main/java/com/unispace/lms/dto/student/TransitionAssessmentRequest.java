package com.unispace.lms.dto.student;

import com.unispace.lms.enums.GoalCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransitionAssessmentRequest {
  private GoalCategory type;

  private Integer score;
}
