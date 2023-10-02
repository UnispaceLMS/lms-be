package com.unispace.lms.model;

import com.unispace.lms.enums.AssistanceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assistance")
public class Assistance {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer studentId;

  private AssistanceType type;

  private String note;
}
