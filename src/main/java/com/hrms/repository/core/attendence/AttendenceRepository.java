package com.hrms.repository.core.attendence;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.Attendence;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendence, Long> {

	public List<Attendence> findByEmployeeId(Long employeeId);

	public Optional<Attendence> findByEmployeeIdAndDate(Long employeeId, LocalDate date);

	public List<Attendence> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate from, LocalDate to);

	public List<Attendence> findByDate(LocalDate date);
}
