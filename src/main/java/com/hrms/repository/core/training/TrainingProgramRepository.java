package com.hrms.repository.core.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.TrainingPrograms;
@Repository

public interface TrainingProgramRepository extends JpaRepository<TrainingPrograms, Long> {

}