package com.unispace.lms.dto.student;

import com.unispace.lms.enums.RecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordRequest {
  private Integer studentId;

  private RecordType type;

  private String note;
}
