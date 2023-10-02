package com.unispace.lms.controller;

import com.unispace.lms.dto.teacher.TeacherRequest;
import com.unispace.lms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1.0/teacher")
public class TeacherController {

  @Autowired private TeacherService teacherService;

  @PostMapping(
      value = "/createOrUpdate",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TeacherRequest> createOrUpdate(@RequestBody TeacherRequest teacherRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.createOrUpdate(teacherRequest));
  }

  @GetMapping(
      value = "/fetch",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TeacherRequest> fetch(@RequestHeader("email") String email) {
    return ResponseEntity.ok(teacherService.fetch(email));
  }
}
