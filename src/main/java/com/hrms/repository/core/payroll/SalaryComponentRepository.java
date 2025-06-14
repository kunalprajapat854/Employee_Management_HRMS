package com.hrms.repository.core.payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.SalaryComponents;

@Repository
public interface SalaryComponentRepository extends JpaRepository<SalaryComponents, Long> {

}
