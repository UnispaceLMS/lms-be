package com.unispace.lms.dto.student;

import com.unispace.lms.enums.BloodGroup;
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

  private String program;

  private String year;

  private Integer expectedGraduation;

  private String primaryDiagnosis;

  private String emergencyContactName;

  private String emergencyContactPhoneNumber;

  private String emergencyContactEmail;

  private String mentalHealthStatus;

  private List<String> allergies;

  private List<String> interests;

  private String calmingStrategy;

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

  private String safetyConceptStruggle;

  private String accommodations;

  private String morningHelp;

  private String eveningHelp;

  private List<String> independentlyCapableTasks;

  private List<String> helpRequiredTasks;

  private List<StrengthOrConcernRequest> strengths;

  private List<StrengthOrConcernRequest> concerns;

  private List<AssistanceRequest> assistances;

  private List<RecordRequest> records;

  private BloodGroup bloodGroup;

  private String legalGuardianName;

  private String emergencyContactSecondaryPhoneNumber;

  private String allergicReactions;

  private String medicineRoutine;

  private String mentalHealthDiagnosis;

  private String mentalHealthStudentPerspective;

  private String objectCopingMechanism;

  private String activityCopingMechanism;

  private String peopleCopingMechanism;

  private List<String> fears;

  private String afternoonHelp;

  private List<SupportRequest> supports;

  private List<TransitionAssessmentRequest> transitionAssessments;
}
