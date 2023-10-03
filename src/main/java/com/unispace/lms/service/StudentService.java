package com.unispace.lms.service;

import com.unispace.lms.dto.student.AssistanceRequest;
import com.unispace.lms.dto.student.StudentRequest;
import java.util.List;

public interface StudentService {
  StudentRequest createOrUpdate(StudentRequest request);

  StudentRequest fetch(Integer id);

  AssistanceRequest createOrUpdateAssistance(AssistanceRequest assistanceRequest);

  List<AssistanceRequest> fetchAssistance(Integer studentId);
}
