package com.hrms.entities;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hrms.enums.common.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "employee_attendence")
public class Attendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Date must be required")
	@PastOrPresent(message = "Date must be past or present required")
	@Column(name = "date")
	private LocalDate date;

	@Column(name = "break_start_time", nullable = false)
	private LocalDateTime breakStartTime;

	@Column(name = "break_end_time")
	private LocalDateTime breakEndTime;

	@Column(name = "total_hours_work", precision = 5, scale = 2)
	private BigDecimal totalHoursWork;

	@Column(name = "overtime_hours", precision = 5, scale = 2)
	private BigDecimal overTimehours;

	@Enumerated(EnumType.STRING)
	@NotBlank(message = "attendence status is required")
	@Column(name = "attendence_status", nullable = false)
	private Status status;

	@NotBlank(message = "notes")
	@Column(name = "notes")
	private String notes;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDate createdAt;

	@UpdateTimestamp
	@Column(name = "updated_date", insertable = false)
	private LocalDate updatedAt;

	// Many Attendance records -> One Employee
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

}