package com.unispace.lms.model.student;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.util.Date;
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

  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  @Temporal(TemporalType.DATE)
  private Date dateOfBirth;

  private String phoneNumber;

  private Program program;

  private Integer year;

  private Integer expectedGraduation;

  private String primaryDiagnosis;

  private String legalGuardianName;

  private String emergencyContactName;

  private String emergencyContactPhoneNumber;

  private String emergencyContactSecondaryPhoneNumber;

  private String emergencyContactEmail;

  private String secondaryEmergencyContactName;

  private String secondaryEmergencyContactPhoneNumber;

  private String secondaryEmergencyContactEmail;

  private String mentalHealthStatus;

  private String medicineRoutine;

  private String mentalHealthDiagnosis;

  private String mentalHealthStudentPerspective;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "object_coping_mechanism")
  private List<String> objectCopingMechanisms;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "activity_coping_mechanism")
  private List<String> activityCopingMechanisms;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "people_coping_mechanism")
  private List<String> peopleCopingMechanisms;

  private String dreamJobs;

  private String dreamLivingSituations;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "safety_concept_struggle")
  private List<String> safetyConceptStruggles;

  private String accommodations;

  private String morningHelp;

  private String afternoonHelp;

  private String eveningHelp;

  private String calmingStrategy;

  private String toughestTime;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_allergy")
  private List<Allergy> allergies;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_interest")
  @Column(name = "interest")
  private List<String> interests;

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
    if (StringUtils.isEmpty(newEntity.getFirstName())) {
      newEntity.setFirstName(existingEntity.getFirstName());
    }
    if (StringUtils.isEmpty(newEntity.getMiddleName())) {
      newEntity.setMiddleName(existingEntity.getMiddleName());
    }
    if (StringUtils.isEmpty(newEntity.getLastName())) {
      newEntity.setLastName(existingEntity.getLastName());
    }
    if (Objects.isNull(newEntity.getDateOfBirth())) {
      newEntity.setDateOfBirth(existingEntity.getDateOfBirth());
    }
    if (StringUtils.isEmpty(newEntity.getPhoneNumber())) {
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
    if (StringUtils.isEmpty(newEntity.getPrimaryDiagnosis())) {
      newEntity.setPrimaryDiagnosis(existingEntity.getPrimaryDiagnosis());
    }
    if (StringUtils.isEmpty(newEntity.getLegalGuardianName())) {
      newEntity.setLegalGuardianName(existingEntity.getLegalGuardianName());
    }
    if (StringUtils.isEmpty(newEntity.getEmergencyContactName())) {
      newEntity.setEmergencyContactName(existingEntity.getEmergencyContactName());
    }
    if (StringUtils.isEmpty(newEntity.getEmergencyContactPhoneNumber())) {
      newEntity.setEmergencyContactPhoneNumber(existingEntity.getEmergencyContactPhoneNumber());
    }
    if (StringUtils.isEmpty(newEntity.getEmergencyContactSecondaryPhoneNumber())) {
      newEntity.setEmergencyContactSecondaryPhoneNumber(
          existingEntity.getEmergencyContactSecondaryPhoneNumber());
    }
    if (StringUtils.isEmpty(newEntity.getEmergencyContactEmail())) {
      newEntity.setEmergencyContactEmail(existingEntity.getEmergencyContactEmail());
    }
    if (StringUtils.isEmpty(newEntity.getSecondaryEmergencyContactName())) {
      newEntity.setSecondaryEmergencyContactName(existingEntity.getSecondaryEmergencyContactName());
    }
    if (StringUtils.isEmpty(newEntity.getSecondaryEmergencyContactPhoneNumber())) {
      newEntity.setSecondaryEmergencyContactPhoneNumber(
          existingEntity.getSecondaryEmergencyContactPhoneNumber());
    }
    if (StringUtils.isEmpty(newEntity.getSecondaryEmergencyContactEmail())) {
      newEntity.setSecondaryEmergencyContactEmail(
          existingEntity.getSecondaryEmergencyContactEmail());
    }
    if (StringUtils.isEmpty(newEntity.getMentalHealthStatus())) {
      newEntity.setMentalHealthStatus(existingEntity.getMentalHealthStatus());
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
    if (CollectionUtils.isEmpty(newEntity.getObjectCopingMechanisms())) {
      newEntity.setObjectCopingMechanisms(existingEntity.getObjectCopingMechanisms());
    }
    if (CollectionUtils.isEmpty(newEntity.getActivityCopingMechanisms())) {
      newEntity.setActivityCopingMechanisms(existingEntity.getActivityCopingMechanisms());
    }
    if (CollectionUtils.isEmpty(newEntity.getPeopleCopingMechanisms())) {
      newEntity.setPeopleCopingMechanisms(existingEntity.getPeopleCopingMechanisms());
    }
    if (StringUtils.isEmpty(newEntity.getDreamJobs())) {
      newEntity.setDreamJobs(existingEntity.getDreamJobs());
    }
    if (StringUtils.isEmpty(newEntity.getDreamLivingSituations())) {
      newEntity.setDreamLivingSituations(existingEntity.getDreamLivingSituations());
    }
    if (CollectionUtils.isEmpty(newEntity.getSafetyConceptStruggles())) {
      newEntity.setSafetyConceptStruggles(existingEntity.getSafetyConceptStruggles());
    }
    if (StringUtils.isEmpty(newEntity.getAccommodations())) {
      newEntity.setAccommodations(existingEntity.getAccommodations());
    }
    if (StringUtils.isEmpty(newEntity.getMorningHelp())) {
      newEntity.setMorningHelp(existingEntity.getMorningHelp());
    }
    if (StringUtils.isEmpty(newEntity.getAfternoonHelp())) {
      newEntity.setAfternoonHelp(existingEntity.getAfternoonHelp());
    }
    if (StringUtils.isEmpty(newEntity.getEveningHelp())) {
      newEntity.setEveningHelp(existingEntity.getEveningHelp());
    }
    if (StringUtils.isEmpty(newEntity.getCalmingStrategy())) {
      newEntity.setCalmingStrategy(existingEntity.getCalmingStrategy());
    }
    if (StringUtils.isEmpty(newEntity.getToughestTime())) {
      newEntity.setToughestTime(existingEntity.getToughestTime());
    }
    if (CollectionUtils.isEmpty(newEntity.getAllergies())) {
      newEntity.setAllergies(existingEntity.getAllergies());
    }
    if (CollectionUtils.isEmpty(newEntity.getInterests())) {
      newEntity.setInterests(existingEntity.getInterests());
    }
    if (CollectionUtils.isEmpty(newEntity.getTriggers())) {
      newEntity.setTriggers(existingEntity.getTriggers());
    }
    if (CollectionUtils.isEmpty(newEntity.getBestTeachingStrategies())) {
      newEntity.setBestTeachingStrategies(existingEntity.getBestTeachingStrategies());
    }
    if (CollectionUtils.isEmpty(newEntity.getFriends())) {
      newEntity.setFriends(existingEntity.getFriends());
    }
    if (CollectionUtils.isEmpty(newEntity.getFamily())) {
      newEntity.setFamily(existingEntity.getFamily());
    }
    if (CollectionUtils.isEmpty(newEntity.getWorries())) {
      newEntity.setWorries(existingEntity.getWorries());
    }
    if (CollectionUtils.isEmpty(newEntity.getFears())) {
      newEntity.setFears(existingEntity.getFears());
    }
    if (CollectionUtils.isEmpty(newEntity.getNegativeThoughtTriggers())) {
      newEntity.setNegativeThoughtTriggers(existingEntity.getNegativeThoughtTriggers());
    }
    if (CollectionUtils.isEmpty(newEntity.getHelpfulStrategies())) {
      newEntity.setHelpfulStrategies(existingEntity.getHelpfulStrategies());
    }
    if (CollectionUtils.isEmpty(newEntity.getIndependentlyCapableTasks())) {
      newEntity.setIndependentlyCapableTasks(existingEntity.getIndependentlyCapableTasks());
    }
    if (CollectionUtils.isEmpty(newEntity.getHelpRequiredTasks())) {
      newEntity.setHelpRequiredTasks(existingEntity.getHelpRequiredTasks());
    }
    if (CollectionUtils.isEmpty(newEntity.getStrengths())) {
      newEntity.setStrengths(existingEntity.getStrengths());
    }
    if (CollectionUtils.isEmpty(newEntity.getConcerns())) {
      newEntity.setConcerns(existingEntity.getConcerns());
    }
    if (CollectionUtils.isEmpty(newEntity.getAssistances())) {
      newEntity.setAssistances(existingEntity.getAssistances());
    }
    if (CollectionUtils.isEmpty(newEntity.getSupports())) {
      newEntity.setSupports(existingEntity.getSupports());
    }
    if (CollectionUtils.isEmpty(newEntity.getTransitionAssessments())) {
      newEntity.setTransitionAssessments(existingEntity.getTransitionAssessments());
    }
  }
}
