package com.unispace.lms.service.impl;

import com.unispace.lms.dto.student.StudentRequest;
import com.unispace.lms.mapper.StudentMapper;
import com.unispace.lms.model.Student;
import com.unispace.lms.model.User;
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
  public List<StudentRequest> fetchRoster(String jwt) {
    Integer ownerUserId = null;
    if (Objects.nonNull(SecurityContextHolder.getContext().getAuthentication())
        && Objects.nonNull(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
      User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      if (Objects.nonNull(user)) {
        ownerUserId = user.getId();
      }
    }

    if (Objects.isNull(ownerUserId)) {
      // todo: return bad request
      return null;
    }

    return studentRepository.findAllByOwnerUserId(ownerUserId).stream()
        .map(student -> studentMapper.mapEntityToResponse(student))
        .collect(Collectors.toList());
  }
}
