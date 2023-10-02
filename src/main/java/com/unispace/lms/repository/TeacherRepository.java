package com.unispace.lms.repository;

import com.unispace.lms.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

  Teacher findByEmail(String email);
}
