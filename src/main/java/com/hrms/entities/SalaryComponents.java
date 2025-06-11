package com.hrms.entities;

import java.util.ArrayList;
import java.util.List;

import com.hrms.enums.common.SalaryType;
import com.hrms.enums.common.Salaryname;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "salary_components_table")
public class SalaryComponents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "salary_name")
	private Salaryname salary;

	@Column(name = "salary_type")
	private SalaryType type;

	@Column(name = "is_taxable")
	private String istaxable;

	@Column(name = "is_active")
	private boolean isActive;

	@OneToMany(mappedBy = "salaryComponents", orphanRemoval = true)
	private List<EmployeeSalary> list = new ArrayList<>();

}
