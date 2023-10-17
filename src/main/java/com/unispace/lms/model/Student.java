package com.unispace.lms.model;

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

  private String emergencyContactName;

  private String emergencyContactPhoneNumber;

  private String emergencyContactEmail;

  private String mentalHealthStatus;

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
  @CollectionTable(name = "student_friends_family")
  @Column(name = "friends_family")
  private List<String> friendsAndFamily;

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
  @CollectionTable(name = "student_helpful_accomodation")
  @Column(name = "helpful_accomodation")
  private List<String> helpfulAccommodations;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "student_morning_help")
  @Column(name = "morning_help")
  private List<String> morningHelps;

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
    if (Objects.isNull(newEntity.getEmergencyContactName())) {
      newEntity.setEmergencyContactName(existingEntity.getEmergencyContactName());
    }
    if (Objects.isNull(newEntity.getEmergencyContactPhoneNumber())) {
      newEntity.setEmergencyContactPhoneNumber(existingEntity.getEmergencyContactPhoneNumber());
    }
    if (Objects.isNull(newEntity.getEmergencyContactEmail())) {
      newEntity.setEmergencyContactEmail(existingEntity.getEmergencyContactEmail());
    }
    if (Objects.isNull(newEntity.getMentalHealthStatus())) {
      newEntity.setMentalHealthStatus(existingEntity.getMentalHealthStatus());
    }
    if (CollectionUtils.isEmpty(newEntity.getAllergies())) {
      newEntity.setAllergies(existingEntity.getAllergies());
    }
    if (CollectionUtils.isEmpty(newEntity.getInterests())) {
      newEntity.setInterests(existingEntity.getInterests());
    }
    if (CollectionUtils.isEmpty(newEntity.getCalmDownThings())) {
      newEntity.setCalmDownThings(existingEntity.getCalmDownThings());
    }
    if (CollectionUtils.isEmpty(newEntity.getTriggers())) {
      newEntity.setTriggers(existingEntity.getTriggers());
    }
    if (CollectionUtils.isEmpty(newEntity.getBestTeachingStrategies())) {
      newEntity.setBestTeachingStrategies(existingEntity.getBestTeachingStrategies());
    }
    if (CollectionUtils.isEmpty(newEntity.getFriendsAndFamily())) {
      newEntity.setFriendsAndFamily(existingEntity.getFriendsAndFamily());
    }
    if (CollectionUtils.isEmpty(newEntity.getDreamJobs())) {
      newEntity.setDreamJobs(existingEntity.getDreamJobs());
    }
    if (CollectionUtils.isEmpty(newEntity.getDreamLivingSituations())) {
      newEntity.setDreamLivingSituations(existingEntity.getDreamLivingSituations());
    }
    if (CollectionUtils.isEmpty(newEntity.getWorries())) {
      newEntity.setWorries(existingEntity.getWorries());
    }
    if (CollectionUtils.isEmpty(newEntity.getNegativeThoughtTriggers())) {
      newEntity.setNegativeThoughtTriggers(existingEntity.getNegativeThoughtTriggers());
    }
    if (CollectionUtils.isEmpty(newEntity.getHelpfulStrategies())) {
      newEntity.setHelpfulStrategies(existingEntity.getHelpfulStrategies());
    }
    if (CollectionUtils.isEmpty(newEntity.getHardTimesOfYear())) {
      newEntity.setHardTimesOfYear(existingEntity.getHardTimesOfYear());
    }
    if (CollectionUtils.isEmpty(newEntity.getSafetyConceptStruggles())) {
      newEntity.setSafetyConceptStruggles(existingEntity.getSafetyConceptStruggles());
    }
    if (CollectionUtils.isEmpty(newEntity.getHelpfulAccommodations())) {
      newEntity.setHelpfulAccommodations(existingEntity.getHelpfulAccommodations());
    }
    if (CollectionUtils.isEmpty(newEntity.getMorningHelps())) {
      newEntity.setMorningHelps(existingEntity.getMorningHelps());
    }
    if (CollectionUtils.isEmpty(newEntity.getEveningHelps())) {
      newEntity.setEveningHelps(existingEntity.getEveningHelps());
    }
    if (CollectionUtils.isEmpty(newEntity.getIndependentlyCapableTasks())) {
      newEntity.setIndependentlyCapableTasks(existingEntity.getIndependentlyCapableTasks());
    }
    if (CollectionUtils.isEmpty(newEntity.getHelpRequiredTasks())) {
      newEntity.setHelpRequiredTasks(existingEntity.getHelpRequiredTasks());
    }
  }
}
