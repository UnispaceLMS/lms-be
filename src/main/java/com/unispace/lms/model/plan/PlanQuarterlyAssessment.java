package com.unispace.lms.model.plan;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
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

  @Transient
  public static void prepareForUpsert(
      List<PlanQuarterlyAssessment> newEntities, List<PlanQuarterlyAssessment> existingEntities) {
    if (CollectionUtils.isEmpty(newEntities) || CollectionUtils.isEmpty(existingEntities)) {
      return;
    }
    Map<Integer, PlanQuarterlyAssessment> newMap =
        newEntities.stream()
            .collect(
                Collectors.toMap(PlanQuarterlyAssessment::getQuarterNumber, Function.identity()));
    Map<Integer, PlanQuarterlyAssessment> existingMap =
        existingEntities.stream()
            .collect(
                Collectors.toMap(PlanQuarterlyAssessment::getQuarterNumber, Function.identity()));
    for (int i = 1; i < 5; i++) {
      if (!newMap.containsKey(i) && existingMap.containsKey(i)) {
        newEntities.add(existingMap.get(i));
      }
    }
  }
}
