package com.hrms.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Department name is required")
	@Column(name = "department_name", nullable = false, unique = true, length = 45)
	private String name;

	@Column(name = "department_head_id", unique = true)
	private Integer departmentHeadId;

	@Column(name = "parent_department_id", unique = true)
	private Integer parentDepartmentId;

	@Column(name = "budget_allocated", nullable = false)
	private String budgetAllocated;

	@Column(name = "location", length = 255, nullable = false)
	private String location;

	@Column(name = "active_status")
	private boolean isactive;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDate createdAt;

	@UpdateTimestamp
	@Column(name = "updated_date", insertable = false)
	private LocalDate updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDepartmentHeadId() {
		return departmentHeadId;
	}

	public void setDepartmentHeadId(Integer departmentHeadId) {
		this.departmentHeadId = departmentHeadId;
	}

	public Integer getParentDepartmentId() {
		return parentDepartmentId;
	}

	public void setParentDepartmentId(Integer parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

	public String getBudgetAllocated() {
		return budgetAllocated;
	}

	public void setBudgetAllocated(String budgetAllocated) {
		this.budgetAllocated = budgetAllocated;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
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

	public Department() {
		super();
	}

}
