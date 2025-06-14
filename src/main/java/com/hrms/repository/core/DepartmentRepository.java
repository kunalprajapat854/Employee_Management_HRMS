package com.hrms.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
