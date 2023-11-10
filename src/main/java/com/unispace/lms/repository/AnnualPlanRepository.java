package com.unispace.lms.repository;

import com.unispace.lms.model.plan.AnnualPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualPlanRepository extends JpaRepository<AnnualPlan, Integer> {
  void deleteByStudentIdAndYear(Integer studentId, Integer year);

  AnnualPlan findByStudentIdAndYear(Integer studentId, Integer year);
}
