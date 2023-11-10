package com.unispace.lms.mapper;

import com.unispace.lms.dto.plan.AnnualPlanDto;
import com.unispace.lms.dto.plan.goal.GoalDto;
import com.unispace.lms.model.plan.AnnualPlan;
import com.unispace.lms.model.plan.goal.Goal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanMapper {
  AnnualPlanDto mapEntityToDto(AnnualPlan annualPlan);

  AnnualPlan mapDtoToEntity(AnnualPlanDto annualPlanDto);

  GoalDto mapEntityToDto(Goal goal);

  Goal mapDtoToEntity(GoalDto goalDto);
}