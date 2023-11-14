package com.unispace.lms.dto.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FetchYearsResponse {
  private boolean goalExists;

  private boolean presentLevelExists;

  private boolean assessmentExists;

  private boolean visionExists;
}
