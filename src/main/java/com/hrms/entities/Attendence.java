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
	private Long id;

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

	@Column(name = "check_in_time")
	private LocalDateTime checkInTime;

	@Column(name = "check_out_time")
	private LocalDateTime checkOutTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getBreakStartTime() {
		return breakStartTime;
	}

	public void setBreakStartTime(LocalDateTime breakStartTime) {
		this.breakStartTime = breakStartTime;
	}

	public LocalDateTime getBreakEndTime() {
		return breakEndTime;
	}

	public void setBreakEndTime(LocalDateTime breakEndTime) {
		this.breakEndTime = breakEndTime;
	}

	public BigDecimal getTotalHoursWork() {
		return totalHoursWork;
	}

	public void setTotalHoursWork(BigDecimal totalHoursWork) {
		this.totalHoursWork = totalHoursWork;
	}

	public BigDecimal getOverTimehours() {
		return overTimehours;
	}

	public void setOverTimehours(BigDecimal overTimehours) {
		this.overTimehours = overTimehours;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

}