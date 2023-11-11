package com.unispace.lms.model.plan.goal;

import com.unispace.lms.enums.plan.PlanGoalTransportationType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlanGoalTransportationEntry extends PlanGoalEntry {
  @Enumerated(EnumType.STRING)
  private PlanGoalTransportationType type;
}
