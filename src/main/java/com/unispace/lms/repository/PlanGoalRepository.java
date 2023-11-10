package com.unispace.lms.repository;

import com.unispace.lms.model.plan.goal.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanGoalRepository extends JpaRepository<Goal, Integer> {}
