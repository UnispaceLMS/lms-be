package com.unispace.lms.model;

import com.unispace.lms.enums.AssistanceType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Assistance {
  @Enumerated(EnumType.STRING)
  private AssistanceType type;

  private String note;
}
