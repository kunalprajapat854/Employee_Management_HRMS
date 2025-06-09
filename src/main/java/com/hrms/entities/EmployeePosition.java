package com.hrms.entities;

import java.sql.Date;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "employee_position")
public class EmployeePosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Start Date is required")
	@PastOrPresent(message = "Start date must be in past or today")
	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@NotBlank(message = "End date is required")
	@PastOrPresent(message = "End date must be in past or today")
	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Column(name = "is_current")
	private boolean iscurrent;

	@Column(name = "salary_at_time")
	private LocalDate salaryAtTime;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDate createAt;

	@UpdateTimestamp
	@Column(name = "update_date", insertable = false)
	private LocalDate updateAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isIscurrent() {
		return iscurrent;
	}

	public void setIscurrent(boolean iscurrent) {
		this.iscurrent = iscurrent;
	}

	public LocalDate getSalaryAtTime() {
		return salaryAtTime;
	}

	public void setSalaryAtTime(LocalDate salaryAtTime) {
		this.salaryAtTime = salaryAtTime;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public LocalDate getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDate updateAt) {
		this.updateAt = updateAt;
	}

	public EmployeePosition() {
		super();
	}

}
