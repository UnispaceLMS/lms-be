package com.unispace.lms.repository;

import com.unispace.lms.model.student.Student;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
    extends JpaRepository<Student, Integer>, CustomStudentRepository {
  List<Student> findAllByOwnerUserId(Integer ownerUserId);

  Page<Student> findAllByOwnerUserId(Integer ownerUserId, Pageable pageable);
}
