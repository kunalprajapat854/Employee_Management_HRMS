package com.hrms.repository.core.attendence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.Leave_Application;

public interface LeaveApplicationRepo extends JpaRepository<Leave_Application, Long> {

}
