package com.unispace.lms.repository;

import com.unispace.lms.model.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssistanceRepository extends JpaRepository<Assistance, Integer> {
  List<Assistance> findByStudentId(Integer studentId);
}
