package com.unispace.lms.dto.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportRequest {
  private String supportAndModificationToEnv;

  private String condition;

  private String location;
}
