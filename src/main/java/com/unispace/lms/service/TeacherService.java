package com.unispace.lms.service;

import com.unispace.lms.dto.teacher.TeacherRequest;

public interface TeacherService {
  TeacherRequest createOrUpdate(TeacherRequest request);

  TeacherRequest fetch(String email);
}
