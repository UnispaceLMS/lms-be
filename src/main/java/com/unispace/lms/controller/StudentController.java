package com.unispace.lms.controller;

import com.unispace.lms.dto.student.AssistanceRequest;
import com.unispace.lms.dto.student.StudentRequest;
import com.unispace.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1.0/student")
public class StudentController {
  @Autowired private StudentService studentService;

  @PostMapping(
      value = "/createOrUpdate",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StudentRequest> createOrUpdate(@RequestBody StudentRequest studentRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(studentService.createOrUpdate(studentRequest));
  }

  @GetMapping(value = "/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StudentRequest> fetch(@RequestParam("id") Integer id) {
    StudentRequest student = studentService.fetch(id);
    if (Objects.isNull(student)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return ResponseEntity.ok(student);
  }

  @PostMapping(
      value = "/assistance/createOrUpdate",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AssistanceRequest> createOrUpdateAssistance(
      @RequestBody AssistanceRequest assistanceRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(studentService.createOrUpdateAssistance(assistanceRequest));
  }

  @GetMapping(value = "/assistance/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<AssistanceRequest>> fetchAssistance(
      @RequestParam("studentId") Integer studentId) {
    return ResponseEntity.ok(studentService.fetchAssistance(studentId));
  }
}
