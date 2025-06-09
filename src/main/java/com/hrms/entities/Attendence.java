package com.hrms.entities;

import java.sql.Date;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_attendence")
public class Attendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Employee employee;
	
	private Date date;
	private Date breakStartTime;
	private Date breakEndTime;
	private String totalHoursWork;
	private String overTimehours;

	@Enumerated(EnumType.STRING)
	private Status status;
	private String notes;
	private LocalDate createdAt;
	private LocalDate updatedAt;

	private enum Status {
		PRESENT, ABSENT, HALF_DAY, LATE, EARLY_DEPARTURE
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getBreakStartTime() {
		return breakStartTime;
	}

	public void setBreakStartTime(Date breakStartTime) {
		this.breakStartTime = breakStartTime;
	}

	public Date getBreakEndTime() {
		return breakEndTime;
	}

	public void setBreakEndTime(Date breakEndTime) {
		this.breakEndTime = breakEndTime;
	}

	public String getTotalHoursWork() {
		return totalHoursWork;
	}

	public void setTotalHoursWork(String totalHoursWork) {
		this.totalHoursWork = totalHoursWork;
	}

	public String getOverTimehours() {
		return overTimehours;
	}

	public void setOverTimehours(String overTimehours) {
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
	
	

}
