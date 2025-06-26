package com.hrms.service.attendence;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hrms.entities.Attendence;
import com.hrms.repository.core.attendence.AttendenceRepository;

@Service
public class AttendenceServiceImple implements AttendenceService {

	private AttendenceRepository attendenceRepository;

	public AttendenceServiceImple(AttendenceRepository attendenceRepository) {
		this.attendenceRepository = attendenceRepository;
	}

	public void markAttendence(Long employeeId, LocalDate date, Attendence attendenceData) {
		Optional<Attendence> existing = attendenceRepository.findByEmployeeIdAndDate(employeeId, date);
		if (existing.isPresent()) {
			throw new IllegalArgumentException("Attendence already marked for this date.");
		}
		attendenceData.setDate(date);
		attendenceRepository.save(attendenceData);

	}

	public List<Attendence> getAttendenceByEmployee(Long employeeId) {
		return attendenceRepository.findByEmployeeId(employeeId);

	}

	public List<Attendence> getAttendencesBetweenDates(Long employeeId, LocalDate fromDate, LocalDate toDate) {
		return attendenceRepository.findByEmployeeIdAndDateBetween(employeeId, fromDate, toDate);
	}

	public boolean updateAttendence(Long employeeId, Attendence updateAttendence) {
		Optional<Attendence> empId = attendenceRepository.findById(employeeId);
		if (empId.isPresent()) {
			Attendence attendence = empId.get();

		}
		return false;
	}

	public String deleteAttendence(Long attendenceId) {
		try {
			attendenceRepository.deleteById(attendenceId);
			return "Deleted";
		} catch (Exception e) {
			e.getStackTrace();
		}

		return "Not Deleted";
	}

	public Attendence getTodayAttendence(Long employeeId) {
		return attendenceRepository.findByEmployeeIdAndDate(employeeId, LocalDate.now()).orElse(null);
	}

	public BigDecimal calculateMonthlyWorkhours(Long employeeId, int year, int month) {
		LocalDate start = LocalDate.of(year, month, 1);
		LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

		List<Attendence> attendances = attendenceRepository.findByEmployeeIdAndDateBetween(employeeId, start, end);
		long totalMinutes = 0;

		for (Attendence att : attendances) {
			if (att.getCheckInTime() != null && att.getCheckOutTime() != null) {
				long minutes = Duration.between(att.getCheckInTime(), att.getCheckOutTime()).toMinutes();

				if (att.getBreakStartTime() != null && att.getBreakEndTime() != null) {
					long breakMinutes = Duration.between(att.getBreakStartTime(), att.getBreakEndTime()).toMinutes();
					minutes -= breakMinutes;
				}

				totalMinutes += Math.max(minutes, 0);
			}
		}

		return BigDecimal.valueOf(totalMinutes).divide(BigDecimal.valueOf(60), 2, BigDecimal.ROUND_HALF_UP);
	}

	public List<Long> getListOfEmployeeAbsents(LocalDate date) {
		List<Attendence> presentList = attendenceRepository.findByDate(date);
		// List<Long> presentIds =
		// presentList.stream().map(Attendence::getEmployeeId).collect(Collectors.toList());

		return List.of();
	}

	@SuppressWarnings("deprecation")
	public BigDecimal calculateOvertimeInRange(Long employeeId, LocalDate from, LocalDate to) {
		List<Attendence> attendances = attendenceRepository.findByEmployeeIdAndDateBetween(employeeId, from, to);
		long overtimeMinutes = 0;

		for (Attendence att : attendances) {
			if (att.getCheckInTime() != null && att.getCheckOutTime() != null) {
				long worked = Duration.between(att.getCheckInTime(), att.getCheckOutTime()).toMinutes();

				if (att.getBreakStartTime() != null && att.getBreakEndTime() != null) {
					worked -= Duration.between(att.getBreakStartTime(), att.getBreakEndTime()).toMinutes();
				}

				long overtime = worked - 480; // Assuming 8 hours = 480 min standard
				if (overtime > 0)
					overtimeMinutes += overtime;
			}
		}

		return BigDecimal.valueOf(overtimeMinutes).divide(BigDecimal.valueOf(60), 2, BigDecimal.ROUND_HALF_UP);

	}

}
