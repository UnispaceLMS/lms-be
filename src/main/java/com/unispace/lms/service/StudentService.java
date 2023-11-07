package com.unispace.lms.service;

import com.unispace.lms.dto.PaginatedResponse;
import com.unispace.lms.dto.student.StudentRequest;
import java.util.List;

public interface StudentService {
  StudentRequest createOrUpdate(StudentRequest request);

  StudentRequest fetch(Integer id);

  PaginatedResponse<StudentRequest> fetchRoster(String searchQuery, int page, int size);

  List<StudentRequest> deleteStudents(List<Integer> studentIdList);
}
