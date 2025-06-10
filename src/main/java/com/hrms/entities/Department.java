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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
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
	
	//mappings one-to-many
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Employee> employees = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "department" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<EmployeePosition> employeePositions = new ArrayList<>();
	
	//one department have multiple position
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Position> positionslist = new ArrayList<>();

}