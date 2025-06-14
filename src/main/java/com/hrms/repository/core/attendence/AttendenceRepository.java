package com.hrms.repository.core.attendence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.Attendence;
@Repository
public interface AttendenceRepository  extends JpaRepository<Attendence, Long>{ 

}
