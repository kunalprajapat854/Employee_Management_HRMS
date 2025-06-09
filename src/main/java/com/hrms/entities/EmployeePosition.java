package com.hrms.entities;

import java.sql.Date;

import java.time.LocalDate;

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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
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
	
	// Many EmployeePositions -> One Employee
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id" , nullable = false)
	private Employee employee ; 
	
	// Many EmployeePositions -> One Department
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id" , nullable = false)
	private Department department ;
	
	// Many EmployeePositions -> One position
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id" , nullable = false)
	private Position position ;

	
	
	
   

	
	
	
	


}
