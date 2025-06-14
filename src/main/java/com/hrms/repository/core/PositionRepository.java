package com.hrms.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.EmployeePosition;

@Repository
public interface PositionRepository extends JpaRepository<EmployeePosition, Integer> {

}
