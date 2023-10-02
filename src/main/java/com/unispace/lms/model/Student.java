package com.unispace.lms.model;

import com.unispace.lms.enums.Program;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer teacherId;
  
  private String email;

  private String firstName;

  private String lastName;

  private Instant dateOfBirth;

  private String phoneNumber;

  private Program program;

  private String year;

  private Integer expectedGraduation;

  @ElementCollection
  private List<String> allergies;

  private String primaryDiagnosis;

  private String emergencyContactName;

  private String emergencyContactPhoneNumber;

  private String emergencyContactEmail;
}
