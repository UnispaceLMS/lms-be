package com.unispace.lms.dto.student;

import com.unispace.lms.enums.Program;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
  private Integer id;

  private Integer ownerUserId;

  private String email;

  private String firstName;

  private String middleName;

  private String lastName;

  private Instant dateOfBirth;

  private String phoneNumber;

  private Program program;

  private String year;

  private Integer expectedGraduation;

  private String primaryDiagnosis;

  private String emergencyContactName;

  private String emergencyContactPhoneNumber;

  private String emergencyContactEmail;

  private String mentalHealthStatus;

  private List<String> allergies;

  private List<String> interests;

  private List<String> calmDownThings;

  private List<String> triggers;

  private List<String> bestTeachingStrategies;

  private List<String> friendsAndFamily;

  private List<String> dreamJobs;

  private List<String> dreamLivingSituations;

  private List<String> worries;

  private List<String> negativeThoughtTriggers;

  private List<String> helpfulStrategies;

  private List<String> hardTimesOfYear;

  private List<String> safetyConceptStruggles;

  private List<String> helpfulAccommodations;

  private List<String> morningHelps;

  private List<String> eveningHelps;

  private List<String> independentlyCapableTasks;

  private List<String> helpRequiredTasks;
}
