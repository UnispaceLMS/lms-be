package com.unispace.lms.service;

import com.unispace.lms.dto.plan.AnnualPlanDto;

public interface PlanService {
  AnnualPlanDto createOrUpdate(AnnualPlanDto annualPlan);

  void delete(Integer studentId, Integer year);

  AnnualPlanDto fetch(Integer studentId, Integer year);
}
