package com.unispace.lms.dto.student;

import com.unispace.lms.enums.Program;
import java.util.Date;
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

  private Date dateOfBirth;

  private String phoneNumber;

  private Program program;

  private Integer year;

  private Integer expectedGraduation;

  private String primaryDiagnosis;

  private String emergencyContactName;

  private String emergencyContactPhoneNumber;

  private String emergencyContactEmail;

  private String secondaryEmergencyContactName;

  private String secondaryEmergencyContactPhoneNumber;

  private String secondaryEmergencyContactEmail;

  private String mentalHealthStatus;

  private List<AllergyRequest> allergies;

  private List<String> interests;

  private List<String> calmingStrategies;

  private List<String> triggers;

  private List<String> bestTeachingStrategies;

  private List<String> friends;

  private List<String> family;

  private String dreamJob;

  private String dreamLivingSituation;

  private List<String> worries;

  private List<String> negativeThoughtTriggers;

  private List<String> helpfulStrategies;

  private String toughestTime;

  private List<String> safetyConceptStruggles;

  private String accommodations;

  private String morningHelp;

  private String eveningHelp;

  private List<String> independentlyCapableTasks;

  private List<String> helpRequiredTasks;

  private List<StrengthOrConcernRequest> strengths;

  private List<StrengthOrConcernRequest> concerns;

  private List<AssistanceRequest> assistances;

  private String legalGuardianName;

  private String emergencyContactSecondaryPhoneNumber;

  private String medicineRoutine;

  private String mentalHealthDiagnosis;

  private String mentalHealthStudentPerspective;

  private List<String> fears;

  private String afternoonHelp;

  private List<SupportRequest> supports;

  private List<TransitionAssessmentRequest> transitionAssessments;
}
