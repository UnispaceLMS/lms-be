package com.unispace.lms.service.impl;

import com.unispace.lms.dto.student.AssistanceRequest;
import com.unispace.lms.dto.student.StudentRequest;
import com.unispace.lms.mapper.AssistanceMapper;
import com.unispace.lms.mapper.StudentMapper;
import com.unispace.lms.model.Assistance;
import com.unispace.lms.model.Student;
import com.unispace.lms.model.User;
import com.unispace.lms.repository.AssistanceRepository;
import com.unispace.lms.repository.StudentRepository;
import com.unispace.lms.service.StudentService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
  @Autowired private StudentRepository studentRepository;
  @Autowired private StudentMapper studentMapper;
  @Autowired private AssistanceRepository assistanceRepository;
  @Autowired private AssistanceMapper assistanceMapper;

  @Override
  public StudentRequest createOrUpdate(StudentRequest request) {
    if (Objects.isNull(request)) {
      return null;
    }
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Optional<Student> existing = Optional.empty();
    if (Objects.nonNull(request.getId())) {
      existing = studentRepository.findById(request.getId());
    }
    Student toPersist = studentMapper.mapRequestToEntity(request);
    toPersist.setOwnerUserId(user.getId());
    if (existing.isPresent()) {
      if (Objects.equals(existing.get().getOwnerUserId(), user.getId())) {
        Student.prepareForUpsert(toPersist, existing.get());
      } else {
        // todo: return bad request in this case
        return null;
      }
    }
    return studentMapper.mapEntityToResponse(studentRepository.save(toPersist));
  }

  @Override
  public StudentRequest fetch(Integer id) {
    return studentMapper.mapEntityToResponse(studentRepository.findById(id).orElse(null));
  }

  @Override
  public AssistanceRequest createOrUpdateAssistance(AssistanceRequest assistanceRequest) {
    Optional<Assistance> existing = Optional.empty();
    if (Objects.nonNull(assistanceRequest.getId())) {
      existing = assistanceRepository.findById(assistanceRequest.getId());
    }
    Assistance toPersist = assistanceMapper.mapRequestToEntity(assistanceRequest);
    if (existing.isPresent()
        && Objects.equals(existing.get().getStudentId(), assistanceRequest.getStudentId())) {
      toPersist.setId(existing.get().getId());
    }
    return assistanceMapper.mapEntityToResponse(assistanceRepository.save(toPersist));
  }

  @Override
  public List<AssistanceRequest> fetchAssistance(Integer studentId) {
    return assistanceRepository.findByStudentId(studentId).stream()
        .map(assistance -> assistanceMapper.mapEntityToResponse(assistance))
        .collect(Collectors.toList());
  }
}
