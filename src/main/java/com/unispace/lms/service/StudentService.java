package com.unispace.lms.service;

import com.unispace.lms.dto.student.StudentRequest;

public interface StudentService {
  StudentRequest createOrUpdate(StudentRequest request);

  StudentRequest fetch(String email);
}
