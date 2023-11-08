package com.unispace.lms.repository;

import com.unispace.lms.model.student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomStudentRepository {
  Page<Student> findAllByOwnerUserId(String searchQuery, Integer ownerUserId, Pageable pageable);
}
