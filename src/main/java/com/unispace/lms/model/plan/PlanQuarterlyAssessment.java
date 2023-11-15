package com.unispace.lms.model.plan;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(
    name = "plan_quarterly_assessment",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"quarterNumber", "annual_plan_id"})})
public class PlanQuarterlyAssessment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer quarterNumber;

  private String studentStrengths;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "plan_quarterly_assessment_scores")
  private List<PlanAssessmentScore> scores;
}
