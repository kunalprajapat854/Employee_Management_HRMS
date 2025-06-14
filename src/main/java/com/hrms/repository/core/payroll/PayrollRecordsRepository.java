package com.hrms.repository.core.payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.Payroll_Records;

@Repository
public interface PayrollRecordsRepository extends JpaRepository<Payroll_Records, Long> {

}
