package com.unispace.lms.service.impl;

import com.unispace.lms.dto.student.StudentRequest;
import com.unispace.lms.mapper.StudentMapper;
import com.unispace.lms.model.Student;
import com.unispace.lms.repository.StudentRepository;
import com.unispace.lms.service.StudentService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
  @Autowired private StudentRepository studentRepository;
  @Autowired private StudentMapper studentMapper;

  @Override
  public StudentRequest createOrUpdate(StudentRequest request) {
    Student toPersist = studentMapper.mapRequestToEntity(request);
    Student existing =
        studentRepository.findByTeacherIdAndFirstNameAndLastNameAndProgram(
            request.getTeacherId(),
            request.getFirstName(),
            request.getLastName(),
            request.getProgram());
    if (Objects.nonNull(existing)) {
      toPersist.setId(existing.getId());
    }
    return studentMapper.mapEntityToResponse(studentRepository.save(toPersist));
  }

  @Override
  public StudentRequest fetch(String email) {
    return studentMapper.mapEntityToResponse(studentRepository.findByEmail(email));
  }
}
