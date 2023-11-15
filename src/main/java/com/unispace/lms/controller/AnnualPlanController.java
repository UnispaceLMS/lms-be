package com.unispace.lms.controller;

import com.unispace.lms.dto.plan.AnnualPlanDto;
import com.unispace.lms.dto.plan.FetchYearsResponse;
import com.unispace.lms.dto.plan.PlanQuarterlyAssessmentDto;
import com.unispace.lms.service.PlanService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// todo: add authorization (user should own the studentId)
@RestController
@RequestMapping("v1.0/annualPlan")
public class AnnualPlanController {
  @Autowired private PlanService planService;

  @PutMapping(
      value = "/createOrUpdate",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AnnualPlanDto> createOrUpdate(@RequestBody AnnualPlanDto annualPlanDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(planService.createOrUpdate(annualPlanDto));
  }

  @GetMapping(value = "/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AnnualPlanDto> fetch(
      @RequestParam Integer studentId, @RequestParam Integer year) {
    return ResponseEntity.ok(planService.fetch(studentId, year));
  }

  @DeleteMapping(
      value = "/delete",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> delete(@RequestParam Integer studentId, @RequestParam Integer year) {
    planService.delete(studentId, year);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping(value = "/fetchYears", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<Integer, FetchYearsResponse>> fetchYears(
      @RequestParam Integer studentId) {
    return ResponseEntity.ok(planService.fetchYears(studentId));
  }

  @GetMapping(value = "/quarterlyReport", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AnnualPlanDto> fetchQuarterlyReport(
      @RequestParam Integer studentId,
      @RequestParam Integer year,
      @RequestParam Integer quarterNumber) {
    return ResponseEntity.ok(planService.fetchQuarterlyReport(studentId, year, quarterNumber));
  }

  @PutMapping(
      value = "/quarterlyReport/grades/update",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AnnualPlanDto> updateQuarterlyGrades(
      @RequestParam Integer studentId,
      @RequestParam Integer year,
      @RequestBody PlanQuarterlyAssessmentDto planQuarterlyAssessmentDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(planService.updateQuarterlyGrades(studentId, year, planQuarterlyAssessmentDto));
  }
}
