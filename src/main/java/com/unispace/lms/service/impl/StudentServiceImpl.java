package com.unispace.lms.service.impl;

import com.unispace.lms.auth.JwtUtil;
import com.unispace.lms.dto.PaginatedResponse;
import com.unispace.lms.dto.student.StudentRequest;
import com.unispace.lms.mapper.StudentMapper;
import com.unispace.lms.model.User;
import com.unispace.lms.model.student.Student;
import com.unispace.lms.repository.StudentRepository;
import com.unispace.lms.service.StudentService;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
  public PaginatedResponse<StudentRequest> fetchRoster(String searchQuery, int page, int size) {
    Page<Student> studentPage = fetchRosterFromDb(searchQuery, page, size);
    if (Objects.isNull(studentPage) || studentPage.isEmpty()) {
      return new PaginatedResponse<>(Collections.emptyList(), 0L, 0L, 0L);
    }
    return PaginatedResponse.<StudentRequest>builder()
        .response(
            studentPage.get().map(student -> studentMapper.mapEntityToResponse(student)).toList())
        .totalElements(studentPage.getTotalElements())
        .totalPages((long) studentPage.getTotalPages())
        .currentPage((long) page)
        .build();
  }

  private Page<Student> fetchRosterFromDb(String searchQuery, int page, int size) {
    Integer ownerUserId = JwtUtil.extractOwnerUserIdFromJwt();
    if (Objects.isNull(ownerUserId)) {
      // todo: return bad request
      return null;
    }
    Pageable pageable = PageRequest.of(page, size);
    Page<Student> paginatedStudents;
    if (StringUtils.isBlank(searchQuery)) {
      paginatedStudents = studentRepository.findAllByOwnerUserId(ownerUserId, pageable);
    } else {
      searchQuery = "%".concat(searchQuery).concat("%");
      paginatedStudents =
          studentRepository.findAllByOwnerUserId(searchQuery, ownerUserId, pageable);
    }
    return paginatedStudents;
  }

  @Override
  public PaginatedResponse<StudentRequest> deleteStudents(
      List<Integer> studentIdList, int page, int size) {
    Integer ownerUserId = JwtUtil.extractOwnerUserIdFromJwt();
    if (Objects.isNull(ownerUserId)) {
      // todo: return bad request
      return null;
    }
    studentRepository.deleteAllById(studentIdList);
    Pageable pageable = PageRequest.of(page, size);
    Page<Student> paginatedStudents = studentRepository.findAllByOwnerUserId(ownerUserId, pageable);
    if (paginatedStudents.hasContent()) {
      return PaginatedResponse.<StudentRequest>builder()
          .response(
              paginatedStudents
                  .get()
                  .map(student -> studentMapper.mapEntityToResponse(student))
                  .collect(Collectors.toList()))
          .currentPage((long) page)
          .totalPages((long) paginatedStudents.getTotalPages())
          .totalElements(paginatedStudents.getTotalElements())
          .build();
    }
    if (page < 1) {
      return null;
    } else {
      while (paginatedStudents.isEmpty() && page > 0) {
        page--;
        pageable = PageRequest.of(page, size);
        paginatedStudents = studentRepository.findAllByOwnerUserId(ownerUserId, pageable);
      }
      if (paginatedStudents.isEmpty()) {
        return null;
      }
      return PaginatedResponse.<StudentRequest>builder()
          .response(
              paginatedStudents
                  .get()
                  .map(student -> studentMapper.mapEntityToResponse(student))
                  .collect(Collectors.toList()))
          .currentPage((long) page)
          .totalPages((long) paginatedStudents.getTotalPages())
          .totalElements(paginatedStudents.getTotalElements())
          .build();
    }
  }
}
