package com.hrms.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.hrms.enums.common.PayrollStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payroll_records")
public class Payroll_Records {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Payment period start must be required")
	@Column(name = "pay_period_start", nullable = false)
	private Date payPeriodstart;

	@Column(name = "pay_period_end", nullable = false)
	private Date payPeriodend;

	@Column(name = "basic_salary", nullable = false)
	private double basicSalary;

	@Column(name = "total_earning", nullable = false)
	private double totalEarning;

	@Column(name = "total_deduction", nullable = false)
	private double totalDeduction;

	@Column(name = "net_salary", nullable = false)
	private Integer netSalary;

	@Column(name = "overtime_amount")
	private double overtimeAmount;

	@Column(name = "bonus_amouont", nullable = false)
	private double bonusAmount;

	@Column(name = "tax_deducted", nullable = false)
	private double taxDeducted;

	@Column(name = "paid_Date", nullable = false)
	private Date paidDate;

	@Column(name = "processed_date", nullable = false)
	private Date processedDate;
	private PayrollStatus status;

	// Mapping
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@OneToMany(mappedBy = "payroll", orphanRemoval = true)
	private List<Payslips> payslipsList = new ArrayList<>();

}
