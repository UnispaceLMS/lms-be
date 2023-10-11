package com.unispace.lms.repository;

import com.unispace.lms.enums.Program;
import com.unispace.lms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
  Student findByEmail(String email);

  Student findByOwnerUserIdAndFirstNameAndLastNameAndProgram(
      Integer ownerUserId, String firstName, String lastName, Program program);
}
