package com.unispace.lms.model.plan;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "plan_assessment")
public class PlanAssessment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String purpose;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "plan_assessment_scores")
  private List<PlanAssessmentScore> scores;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "plan_assessment_additional_scores")
  private List<PlanAssessmentAdditionalScore> additionalScores;
}
