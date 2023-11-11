package com.unispace.lms.model.plan;

import com.unispace.lms.enums.GoalCategory;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.Table;
import java.util.Map;
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

  @ElementCollection(fetch = FetchType.LAZY)
  @MapKeyEnumerated(EnumType.STRING)
  @MapKeyColumn(name = "goal_category")
  @CollectionTable(name = "plan_assessment_scores")
  Map<GoalCategory, Integer> scores;

  @ElementCollection(fetch = FetchType.LAZY)
  @MapKeyEnumerated(EnumType.STRING)
  @MapKeyColumn(name = "additional_category")
  @CollectionTable(name = "plan_assessment_additional_scores")
  Map<String, Integer> additionalScores;
}
