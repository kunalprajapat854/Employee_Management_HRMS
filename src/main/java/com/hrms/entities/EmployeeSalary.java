package com.hrms.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Employee_Salary")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeSalary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "amount")
	private long amount;

	@Column(name = "percentage", nullable = false)
	private double percentage;

	@Column(name = "effective_from")
	private Date effectiveFrom;

	@Column(name = "effective_to")
	private Date effectiveTo;

	@Column(name = "is_active")
	private boolean isActive;

	// Mapping
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "component_id", nullable = false)
	private SalaryComponents salaryComponents;

}
