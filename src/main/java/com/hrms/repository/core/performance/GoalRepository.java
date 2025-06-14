package com.hrms.repository.core.performance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

}
