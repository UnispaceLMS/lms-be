package com.unispace.lms.service;

import com.unispace.lms.dto.plan.AnnualPlanDto;
import com.unispace.lms.dto.plan.FetchYearsResponse;
import java.util.Map;

public interface PlanService {
  AnnualPlanDto createOrUpdate(AnnualPlanDto annualPlan);

  void delete(Integer studentId, Integer year);

  AnnualPlanDto fetch(Integer studentId, Integer year);

  Map<Integer, FetchYearsResponse> fetchYears(Integer studentId);

  AnnualPlanDto fetchQuarterlyReport(Integer studentId, Integer year, Integer quarterNumber);
}
