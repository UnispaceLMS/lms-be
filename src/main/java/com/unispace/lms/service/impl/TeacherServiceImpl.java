package com.unispace.lms.service.impl;

import com.unispace.lms.dto.teacher.TeacherRequest;
import com.unispace.lms.mapper.TeacherMapper;
import com.unispace.lms.model.Teacher;
import com.unispace.lms.repository.TeacherRepository;
import com.unispace.lms.service.TeacherService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
  @Autowired private TeacherRepository teacherRepository;
  @Autowired private TeacherMapper teacherMapper;

  @Override
  public TeacherRequest createOrUpdate(TeacherRequest request) {
    Teacher toPersist = teacherMapper.mapRequestToEntity(request);
    Teacher existing = teacherRepository.findByEmail(request.getEmail());
    if (Objects.nonNull(existing)) {
      toPersist.setId(existing.getId());
    }
      return teacherMapper.mapEntityToResponse(
          teacherRepository.save(toPersist));
  }

  @Override
  public TeacherRequest fetch(String email) {
    return teacherMapper.mapEntityToResponse(teacherRepository.findByEmail(email));
  }
}
