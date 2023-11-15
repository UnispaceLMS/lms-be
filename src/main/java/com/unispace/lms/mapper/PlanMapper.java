package com.unispace.lms.mapper;

import com.unispace.lms.dto.plan.AnnualPlanDto;
import com.unispace.lms.dto.plan.PlanQuarterlyAssessmentDto;
import com.unispace.lms.dto.plan.goal.PlanGoalDto;
import com.unispace.lms.model.plan.AnnualPlan;
import com.unispace.lms.model.plan.PlanQuarterlyAssessment;
import com.unispace.lms.model.plan.goal.PlanGoal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanMapper {
  AnnualPlanDto mapEntityToDto(AnnualPlan annualPlan);

  AnnualPlan mapDtoToEntity(AnnualPlanDto annualPlanDto);

  PlanGoalDto mapEntityToDto(PlanGoal goal);

  PlanGoal mapDtoToEntity(PlanGoalDto goalDto);

  PlanQuarterlyAssessment mapDtoToEntity(PlanQuarterlyAssessmentDto planQuarterlyAssessmentDto);
}
