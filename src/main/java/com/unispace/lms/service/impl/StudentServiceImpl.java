package com.unispace.lms.service.impl;

import com.unispace.lms.auth.JwtUtil;
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
  public List<StudentRequest> fetchRoster() {
    Integer ownerUserId = JwtUtil.extractOwnerUserIdFromJwt();
    if (Objects.isNull(ownerUserId)) {
      // todo: return bad request
      return null;
    }

    return studentRepository.findAllByOwnerUserId(ownerUserId).stream()
        .map(student -> studentMapper.mapEntityToResponse(student))
        .collect(Collectors.toList());
  }

  @Override
  public List<StudentRequest> deleteStudents(List<Integer> studentIdList) {
    Integer ownerUserId = JwtUtil.extractOwnerUserIdFromJwt();
    if (Objects.isNull(ownerUserId)) {
      // todo: return bad request
      return null;
    }

    List<Student> students = studentRepository.findAllByOwnerUserId(ownerUserId);

    List<Integer> idsToBeRemoved =
        students.stream().map(Student::getId).filter(studentIdList::contains).toList();
    studentRepository.deleteAllById(idsToBeRemoved);

    return students.stream()
        .filter(student -> !studentIdList.contains(student.getId()))
        .map(student -> studentMapper.mapEntityToResponse(student))
        .toList();
  }
}
