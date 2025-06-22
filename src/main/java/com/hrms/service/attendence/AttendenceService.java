package com.hrms.service.attendence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.hrms.entities.Attendence;

public interface AttendenceService {

	public void markAttendence(Long employeeId, LocalDate date, Attendence attendencedate);

	public List<Attendence> getAttendenceByEmployee(Long employeeId);

	public List<Attendence> getAttendencesBetweenDates(Long employeeId, LocalDate fromDate, LocalDate toDate);

	public boolean updateAttendence(Long employeeId, Attendence updateAttendence);

	public String deleteAttendence(Long attendenceId);

	public Attendence getTodayAttendence(Long employeeId);

	public BigDecimal calculateMonthlyWorkhours(Long employeeId, int year, int month);

	public List<Long> getListOfEmployeeAbsents(LocalDate date);

	public BigDecimal calculateOvertimeInRange(Long employeeId, LocalDate from, LocalDate to);

}
