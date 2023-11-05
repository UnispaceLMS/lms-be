package com.unispace.lms.controller;

import com.unispace.lms.dto.student.StudentRequest;
import com.unispace.lms.service.StudentService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
  //  @PreAuthorize("hasRole('Role.ADMIN')")
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

  @GetMapping(value = "/roster", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<StudentRequest>> fetchRoster() {
    return ResponseEntity.ok(studentService.fetchRoster());
  }

  @DeleteMapping(value = "/delete")
  public ResponseEntity<List<StudentRequest>> deleteStudents(
      @RequestBody List<Integer> studentIdList) {
    studentService.deleteStudents(studentIdList);
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(studentService.deleteStudents(studentIdList));
  }
}
