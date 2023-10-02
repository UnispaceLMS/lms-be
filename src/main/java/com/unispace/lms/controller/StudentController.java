package com.unispace.lms.controller;

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
  public ResponseEntity<StudentRequest> fetch(@RequestParam("email") String email) {
    return ResponseEntity.ok(studentService.fetch(email));
  }
}
