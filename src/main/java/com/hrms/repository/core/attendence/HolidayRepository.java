package com.hrms.repository.core.attendence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.Holiday;
@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
