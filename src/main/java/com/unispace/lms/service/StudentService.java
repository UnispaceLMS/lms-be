package com.unispace.lms.service;

import com.unispace.lms.dto.student.StudentRequest;
import java.util.List;

public interface StudentService {
  StudentRequest createOrUpdate(StudentRequest request);

  StudentRequest fetch(Integer id);

  List<StudentRequest> fetchRoster(int page, int size);

  List<StudentRequest> deleteStudents(List<Integer> studentIdList);
}
