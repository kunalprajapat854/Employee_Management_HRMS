package com.hrms.service.attendence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.entities.Attendence;
import com.hrms.repository.core.attendence.AttendenceRepository;

@Service
public class AttendenceServiceImple implements AttendenceService {

	private AttendenceRepository attendenceRepository;

	public AttendenceServiceImple(AttendenceRepository attendenceRepository) {

		this.attendenceRepository = attendenceRepository;
	}

	
	public void markAttendence(Long employeeId, LocalDate date, Attendence attendencedate) {


	}


	public List<Attendence> getAttendenceByEmployee(Long employeeId) {

		return null;
	}


	public List<Attendence> getAttendencesBetweenDates(Long employeeId, LocalDate fromDate, LocalDate toDate) {

		return null;
	}


	public boolean updateAttendence(Long employeeId, Attendence updateAttendence) {

		return false;
	}


	public String deleteAttendence(Long attendenceId) {

		return null;
	}


	public Attendence getTodayAttendence(Long employeeId) {

		return null;
	}


	public BigDecimal calculateMonthlyWorkhours(Long employeeId, int year, int month) {

		return null;
	}


	public List<Long> getListOfEmployeeAbsents(LocalDate date) {

		return null;
	}


	public BigDecimal calculateOvertimeInRange(Long employeeId, LocalDate from, LocalDate to) {

		return null;
	}

}
