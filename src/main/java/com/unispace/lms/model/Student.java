package com.unispace.lms.model;

import com.unispace.lms.enums.BloodGroup;
import com.unispace.lms.enums.Program;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

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

  private Integer ownerUserId;

  @Column(unique = true)
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

  private BloodGroup bloodGroup;

  private String legalGuardianName;

  private String emergencyContactName;

  private String emergencyContactPhoneNumber;

  private String emergencyContactSecondaryPhoneNumber;

  private String emergencyContactEmail;

  private String mentalHealthStatus;

  private String allergicReactions;

  private String medicineRoutine;

  private String mentalHealthDiagnosis;

  private String mentalHealthStudentPerspective;

  private String objectCopingMechanism;

  private String activityCopingMechanism;

  private String peopleCopingMechanism;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_allergy")
  @Column(name = "allergy")
  private List<String> allergies;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_interest")
  @Column(name = "interest")
  private List<String> interests;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_calm_down_thing")
  @Column(name = "calm_down_thing")
  private List<String> calmDownThings;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_trigger")
  @Column(name = "trigger")
  private List<String> triggers;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_best_teaching_strategy")
  @Column(name = "best_teaching_strategy")
  private List<String> bestTeachingStrategies;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_friends")
  @Column(name = "friends")
  private List<String> friends;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_family")
  @Column(name = "family")
  private List<String> family;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_dream_job")
  @Column(name = "dream_job")
  private List<String> dreamJobs;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_dream_living_situation")
  @Column(name = "dream_living_situation")
  private List<String> dreamLivingSituations;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_worry")
  @Column(name = "worry")
  private List<String> worries;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_fear")
  @Column(name = "fear")
  private List<String> fears;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_negative_thought_trigger")
  @Column(name = "negative_thought_trigger")
  private List<String> negativeThoughtTriggers;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_helpful_strategy")
  @Column(name = "helpful_strategy")
  private List<String> helpfulStrategies;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_hard_time")
  @Column(name = "hard_time")
  private List<String> hardTimesOfYear;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_safety_struggle")
  @Column(name = "safety_struggle")
  private List<String> safetyConceptStruggles;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_helpful_accommodation")
  @Column(name = "helpful_accommodation")
  private List<String> helpfulAccommodations;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_morning_help")
  @Column(name = "morning_help")
  private List<String> morningHelps;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_afternoon_help")
  @Column(name = "afternoon_help")
  private List<String> afternoonHelps;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_evening_help")
  @Column(name = "evening_help")
  private List<String> eveningHelps;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_independently_capable_task")
  @Column(name = "independently_capable_task")
  private List<String> independentlyCapableTasks;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_help_required_task")
  @Column(name = "help_required_task")
  private List<String> helpRequiredTasks;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_strength")
  private List<StrengthOrConcern> strengths;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_concern")
  private List<StrengthOrConcern> concerns;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_assistance")
  private List<Assistance> assistances;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_record")
  private List<Record> records;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_support")
  private List<Support> supports;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_transition_assessment")
  private List<TransitionAssessment> transitionAssessments;

  @Transient
  public static void prepareForUpsert(Student newEntity, Student existingEntity) {
    if (Objects.isNull(newEntity) || Objects.isNull(existingEntity)) {
      return;
    }
    newEntity.setId(existingEntity.getId());
    if (Objects.isNull(newEntity.getOwnerUserId())) {
      newEntity.setOwnerUserId(existingEntity.getOwnerUserId());
    }
    if (Objects.isNull(newEntity.getEmail())) {
      newEntity.setEmail(existingEntity.getEmail());
    }
    if (Objects.isNull(newEntity.getFirstName())) {
      newEntity.setFirstName(existingEntity.getFirstName());
    }
    if (Objects.isNull(newEntity.getMiddleName())) {
      newEntity.setMiddleName(existingEntity.getMiddleName());
    }
    if (Objects.isNull(newEntity.getLastName())) {
      newEntity.setLastName(existingEntity.getLastName());
    }
    if (Objects.isNull(newEntity.getDateOfBirth())) {
      newEntity.setDateOfBirth(existingEntity.getDateOfBirth());
    }
    if (Objects.isNull(newEntity.getPhoneNumber())) {
      newEntity.setPhoneNumber(existingEntity.getPhoneNumber());
    }
    if (Objects.isNull(newEntity.getProgram())) {
      newEntity.setProgram(existingEntity.getProgram());
    }
    if (Objects.isNull(newEntity.getYear())) {
      newEntity.setYear(existingEntity.getYear());
    }
    if (Objects.isNull(newEntity.getExpectedGraduation())) {
      newEntity.setExpectedGraduation(existingEntity.getExpectedGraduation());
    }
    if (Objects.isNull(newEntity.getPrimaryDiagnosis())) {
      newEntity.setPrimaryDiagnosis(existingEntity.getPrimaryDiagnosis());
    }
    if (Objects.isNull(newEntity.getBloodGroup())) {
      newEntity.setBloodGroup(existingEntity.getBloodGroup());
    }
    if (StringUtils.isEmpty(newEntity.getLegalGuardianName())) {
      newEntity.setLegalGuardianName(existingEntity.getLegalGuardianName());
    }
    if (Objects.isNull(newEntity.getEmergencyContactName())) {
      newEntity.setEmergencyContactName(existingEntity.getEmergencyContactName());
    }
    if (Objects.isNull(newEntity.getEmergencyContactPhoneNumber())) {
      newEntity.setEmergencyContactPhoneNumber(existingEntity.getEmergencyContactPhoneNumber());
    }
    if (StringUtils.isEmpty(newEntity.getEmergencyContactSecondaryPhoneNumber())) {
      newEntity.setEmergencyContactSecondaryPhoneNumber(
          existingEntity.getEmergencyContactSecondaryPhoneNumber());
    }
    if (Objects.isNull(newEntity.getEmergencyContactEmail())) {
      newEntity.setEmergencyContactEmail(existingEntity.getEmergencyContactEmail());
    }
    if (Objects.isNull(newEntity.getMentalHealthStatus())) {
      newEntity.setMentalHealthStatus(existingEntity.getMentalHealthStatus());
    }
    if (StringUtils.isEmpty(newEntity.getAllergicReactions())) {
      newEntity.setAllergicReactions(existingEntity.getAllergicReactions());
    }
    if (StringUtils.isEmpty(newEntity.getMedicineRoutine())) {
      newEntity.setMedicineRoutine(existingEntity.getMedicineRoutine());
    }
    if (StringUtils.isEmpty(newEntity.getMentalHealthDiagnosis())) {
      newEntity.setMentalHealthDiagnosis(existingEntity.getMentalHealthDiagnosis());
    }
    if (StringUtils.isEmpty(newEntity.getMentalHealthStudentPerspective())) {
      newEntity.setMentalHealthStudentPerspective(
          existingEntity.getMentalHealthStudentPerspective());
    }
    if (StringUtils.isEmpty(newEntity.getObjectCopingMechanism())) {
      newEntity.setObjectCopingMechanism(existingEntity.getObjectCopingMechanism());
    }
    if (StringUtils.isEmpty(newEntity.getActivityCopingMechanism())) {
      newEntity.setActivityCopingMechanism(existingEntity.getActivityCopingMechanism());
    }
    if (StringUtils.isEmpty(newEntity.getPeopleCopingMechanism())) {
      newEntity.setPeopleCopingMechanism(existingEntity.getPeopleCopingMechanism());
    }
    if (CollectionUtils.isEmpty(newEntity.getAllergies())) {
      newEntity.setAllergies(existingEntity.getAllergies());
    } else {
      newEntity.getAllergies().addAll(existingEntity.getAllergies());
    }
    if (CollectionUtils.isEmpty(newEntity.getInterests())) {
      newEntity.setInterests(existingEntity.getInterests());
    } else {
      newEntity.getInterests().addAll(existingEntity.getInterests());
    }
    if (CollectionUtils.isEmpty(newEntity.getCalmDownThings())) {
      newEntity.setCalmDownThings(existingEntity.getCalmDownThings());
    } else {
      newEntity.getCalmDownThings().addAll(existingEntity.getCalmDownThings());
    }
    if (CollectionUtils.isEmpty(newEntity.getTriggers())) {
      newEntity.setTriggers(existingEntity.getTriggers());
    } else {
      newEntity.getTriggers().addAll(existingEntity.getTriggers());
    }
    if (CollectionUtils.isEmpty(newEntity.getBestTeachingStrategies())) {
      newEntity.setBestTeachingStrategies(existingEntity.getBestTeachingStrategies());
    } else {
      newEntity.getBestTeachingStrategies().addAll(existingEntity.getBestTeachingStrategies());
    }
    if (CollectionUtils.isEmpty(newEntity.getFriends())) {
      newEntity.setFriends(existingEntity.getFriends());
    } else {
      newEntity.getFriends().addAll(existingEntity.getFriends());
    }
    if (CollectionUtils.isEmpty(newEntity.getFamily())) {
      newEntity.setFamily(existingEntity.getFamily());
    } else {
      newEntity.getFamily().addAll(existingEntity.getFamily());
    }
    if (CollectionUtils.isEmpty(newEntity.getDreamJobs())) {
      newEntity.setDreamJobs(existingEntity.getDreamJobs());
    } else {
      newEntity.getDreamJobs().addAll(existingEntity.getDreamJobs());
    }
    if (CollectionUtils.isEmpty(newEntity.getDreamLivingSituations())) {
      newEntity.setDreamLivingSituations(existingEntity.getDreamLivingSituations());
    } else {
      newEntity.getDreamLivingSituations().addAll(existingEntity.getDreamLivingSituations());
    }
    if (CollectionUtils.isEmpty(newEntity.getWorries())) {
      newEntity.setWorries(existingEntity.getWorries());
    } else {
      newEntity.getWorries().addAll(existingEntity.getWorries());
    }
    if (CollectionUtils.isEmpty(newEntity.getFears())) {
      newEntity.setFears(existingEntity.getFears());
    } else {
      newEntity.getFears().addAll(existingEntity.getFears());
    }
    if (CollectionUtils.isEmpty(newEntity.getNegativeThoughtTriggers())) {
      newEntity.setNegativeThoughtTriggers(existingEntity.getNegativeThoughtTriggers());
    } else {
      newEntity.getNegativeThoughtTriggers().addAll(existingEntity.getNegativeThoughtTriggers());
    }
    if (CollectionUtils.isEmpty(newEntity.getHelpfulStrategies())) {
      newEntity.setHelpfulStrategies(existingEntity.getHelpfulStrategies());
    } else {
      newEntity.getHelpfulStrategies().addAll(existingEntity.getHelpfulStrategies());
    }
    if (CollectionUtils.isEmpty(newEntity.getHardTimesOfYear())) {
      newEntity.setHardTimesOfYear(existingEntity.getHardTimesOfYear());
    } else {
      newEntity.getHardTimesOfYear().addAll(existingEntity.getHardTimesOfYear());
    }
    if (CollectionUtils.isEmpty(newEntity.getSafetyConceptStruggles())) {
      newEntity.setSafetyConceptStruggles(existingEntity.getSafetyConceptStruggles());
    } else {
      newEntity.getSafetyConceptStruggles().addAll(existingEntity.getSafetyConceptStruggles());
    }
    if (CollectionUtils.isEmpty(newEntity.getHelpfulAccommodations())) {
      newEntity.setHelpfulAccommodations(existingEntity.getHelpfulAccommodations());
    } else {
      newEntity.getHelpfulAccommodations().addAll(existingEntity.getHelpfulAccommodations());
    }
    if (CollectionUtils.isEmpty(newEntity.getMorningHelps())) {
      newEntity.setMorningHelps(existingEntity.getMorningHelps());
    } else {
      newEntity.getMorningHelps().addAll(existingEntity.getMorningHelps());
    }
    if (CollectionUtils.isEmpty(newEntity.getAfternoonHelps())) {
      newEntity.setAfternoonHelps(existingEntity.getAfternoonHelps());
    } else {
      newEntity.getAfternoonHelps().addAll(existingEntity.getAfternoonHelps());
    }
    if (CollectionUtils.isEmpty(newEntity.getEveningHelps())) {
      newEntity.setEveningHelps(existingEntity.getEveningHelps());
    } else {
      newEntity.getEveningHelps().addAll(existingEntity.getEveningHelps());
    }
    if (CollectionUtils.isEmpty(newEntity.getIndependentlyCapableTasks())) {
      newEntity.setIndependentlyCapableTasks(existingEntity.getIndependentlyCapableTasks());
    } else {
      newEntity
          .getIndependentlyCapableTasks()
          .addAll(existingEntity.getIndependentlyCapableTasks());
    }
    if (CollectionUtils.isEmpty(newEntity.getHelpRequiredTasks())) {
      newEntity.setHelpRequiredTasks(existingEntity.getHelpRequiredTasks());
    } else {
      newEntity.getHelpRequiredTasks().addAll(existingEntity.getHelpRequiredTasks());
    }
    if (CollectionUtils.isEmpty(newEntity.getStrengths())) {
      newEntity.setStrengths(existingEntity.getStrengths());
    } else {
      newEntity.getStrengths().addAll(existingEntity.getStrengths());
    }
    if (CollectionUtils.isEmpty(newEntity.getConcerns())) {
      newEntity.setConcerns(existingEntity.getConcerns());
    } else {
      newEntity.getConcerns().addAll(existingEntity.getConcerns());
    }
    if (CollectionUtils.isEmpty(newEntity.getAssistances())) {
      newEntity.setAssistances(existingEntity.getAssistances());
    } else {
      newEntity.getAssistances().addAll(existingEntity.getAssistances());
    }
    if (CollectionUtils.isEmpty(newEntity.getRecords())) {
      newEntity.setRecords(existingEntity.getRecords());
    } else {
      newEntity.getRecords().addAll(existingEntity.getRecords());
    }
    if (CollectionUtils.isEmpty(newEntity.getSupports())) {
      newEntity.setSupports(existingEntity.getSupports());
    } else {
      newEntity.getSupports().addAll(existingEntity.getSupports());
    }
    if (CollectionUtils.isEmpty(newEntity.getTransitionAssessments())) {
      newEntity.setTransitionAssessments(existingEntity.getTransitionAssessments());
    } else {
      newEntity.getTransitionAssessments().addAll(existingEntity.getTransitionAssessments());
    }
  }
}
