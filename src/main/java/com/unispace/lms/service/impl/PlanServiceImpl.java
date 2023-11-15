package com.unispace.lms.service.impl;

import com.unispace.lms.dto.plan.AnnualPlanDto;
import com.unispace.lms.dto.plan.FetchYearsResponse;
import com.unispace.lms.dto.plan.PlanQuarterlyAssessmentDto;
import com.unispace.lms.mapper.PlanMapper;
import com.unispace.lms.model.plan.AnnualPlan;
import com.unispace.lms.model.plan.PlanQuarterlyAssessment;
import com.unispace.lms.repository.AnnualPlanRepository;
import com.unispace.lms.service.PlanService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
  @Autowired AnnualPlanRepository annualPlanRepository;
  @Autowired PlanMapper planMapper;

  @Override
  public AnnualPlanDto createOrUpdate(AnnualPlanDto annualPlanDto) {
    AnnualPlan existingPlan =
        annualPlanRepository.findByStudentIdAndYear(
            annualPlanDto.getStudentId(), annualPlanDto.getYear());
    AnnualPlan toPersist = planMapper.mapDtoToEntity(annualPlanDto);
    if (Objects.isNull(existingPlan)) {
      return planMapper.mapEntityToDto(annualPlanRepository.save(toPersist));
    }
    AnnualPlan.prepareForUpsert(toPersist, existingPlan);
    return planMapper.mapEntityToDto(annualPlanRepository.save(toPersist));
  }

  @Override
  public void delete(Integer studentId, Integer year) {
    // todo: handle child cleanup
    annualPlanRepository.deleteByStudentIdAndYear(studentId, year);
  }

  @Override
  public AnnualPlanDto fetch(Integer studentId, Integer year) {
    return planMapper.mapEntityToDto(annualPlanRepository.findByStudentIdAndYear(studentId, year));
  }

  @Override
  public Map<Integer, FetchYearsResponse> fetchYears(Integer studentId) {
    List<AnnualPlan> annualPlans = annualPlanRepository.findByStudentId(studentId);
    if (CollectionUtils.isEmpty(annualPlans)) {
      return new HashMap<>();
    }
    return annualPlans.stream()
        .collect(
            Collectors.toMap(
                AnnualPlan::getYear,
                annualPlan ->
                    FetchYearsResponse.builder()
                        .goalExists(Objects.nonNull(annualPlan.getGoal()))
                        .presentLevelExists(Objects.nonNull(annualPlan.getPresentLevel()))
                        .assessmentExists(Objects.nonNull(annualPlan.getAssessment()))
                        .visionExists(Objects.nonNull(annualPlan.getVision()))
                        .build()));
  }

  @Override
  public AnnualPlanDto fetchQuarterlyReport(
      Integer studentId, Integer year, Integer quarterNumber) {
    AnnualPlan annualPlan = annualPlanRepository.findByStudentIdAndYear(studentId, year);
    if (Objects.isNull(annualPlan)) {
      return null;
    }
    AnnualPlan.filterByQuarter(annualPlan, quarterNumber);
    return planMapper.mapEntityToDto(annualPlan);
  }

  @Override
  public AnnualPlanDto updateQuarterlyGrades(
      Integer studentId, Integer year, PlanQuarterlyAssessmentDto planQuarterlyAssessmentDto) {
    AnnualPlan annualPlan = annualPlanRepository.findByStudentIdAndYear(studentId, year);
    if (Objects.isNull(annualPlan) || Objects.isNull(planQuarterlyAssessmentDto)) {
      // todo: return bad request
      return null;
    }
    PlanQuarterlyAssessment updatedQuarterlyAssessment =
        planMapper.mapDtoToEntity(planQuarterlyAssessmentDto);
    if (Objects.isNull(annualPlan.getQuarterlyAssessments())) {
      annualPlan.setQuarterlyAssessments(List.of(updatedQuarterlyAssessment));
    } else {
      annualPlan
          .getQuarterlyAssessments()
          .removeIf(
              planQuarterlyAssessment ->
                  planQuarterlyAssessment
                      .getQuarterNumber()
                      .equals(updatedQuarterlyAssessment.getQuarterNumber()));
      annualPlan.getQuarterlyAssessments().add(updatedQuarterlyAssessment);
    }
    return planMapper.mapEntityToDto(annualPlanRepository.save(annualPlan));
  }
}
