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
@Table(name = "payslips_table")
@Setter
@Getter
@NoArgsConstructor
public class Payslips {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "payslip_number", unique = true)
	private Integer payslipNum;

	@Column(name = "generated_date", nullable = false)
	private Date generatedDate;

	@Column(name = "file_path", nullable = false)
	private String filePath;

	@Column(name = "is_sent_to_emp", nullable = false)
	private String isSenttoEmp;

	// Mapping
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "payroll_records")
	private Payroll_Records payroll;

}
