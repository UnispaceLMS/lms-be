package com.unispace.lms.service.impl;

import com.unispace.lms.dto.plan.AnnualPlanDto;
import com.unispace.lms.mapper.PlanMapper;
import com.unispace.lms.model.plan.AnnualPlan;
import com.unispace.lms.repository.AnnualPlanRepository;
import com.unispace.lms.service.PlanService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
