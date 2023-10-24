package com.unispace.lms.dto.student;

import com.unispace.lms.enums.StrengthOrConcernType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrengthOrConcernRequest {
  private StrengthOrConcernType type;

  private String note;
}
