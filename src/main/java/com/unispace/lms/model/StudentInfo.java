package com.unispace.lms.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_info")
public class StudentInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer studentId;

  @ElementCollection private List<String> interests;

  @ElementCollection private List<String> calmDownThings;

  @ElementCollection private List<String> triggers;

  @ElementCollection private List<String> bestTeachingStrategies;

  @ElementCollection private List<String> friendsAndFamily;

  @ElementCollection private List<String> dreamJobs;

  @ElementCollection private List<String> dreamLivingSituations;

  @ElementCollection private List<String> worries;

  private String mentalHealthStatus;

  @ElementCollection private List<String> negativeThoughtTriggers;

  @ElementCollection private List<String> helpfulStrategies;

  @ElementCollection private List<String> hardTimesOfYear;

  @ElementCollection private List<String> safetyConceptStruggles;

  @ElementCollection private List<String> helpfulAccommodations;

  @ElementCollection private List<String> morningHelps;

  @ElementCollection private List<String> eveningHelps;

  @ElementCollection private List<String> independentlyCapableTasks;

  @ElementCollection private List<String> helpRequiredTasks;
}
