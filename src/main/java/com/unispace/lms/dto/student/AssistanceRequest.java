package com.unispace.lms.dto.student;

import com.unispace.lms.enums.AssistanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssistanceRequest {
  private Integer id;

  private Integer studentId;

  private AssistanceType type;

  private String note;
}
