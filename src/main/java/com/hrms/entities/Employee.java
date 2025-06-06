package com.hrms.entities;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "user is required")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private user user;

	@Column(name = "employee_id", nullable = false, unique = true, length = 20)
	private String employeeId;

	@NotBlank(message = "Date of birth is required")
	@Past(message = "Date of birth must be in the past")
	@Column(name = "date_of_birth" , nullable = false)
	private LocalDate dateOfBirth;
	
	@NotNull(message = "Gender is required")
	@Enumerated(EnumType.STRING)
	@Column(name = "gender" , nullable = false , length = 10 )
	private Gender gender;
	private String marital_status;
	private String nationality;
	private String personal_email;
	private String work_email;
	private String phone_number;
	private String emergency_contact_number;
	private String current_address;
	private String permanent_address;
	private Date hire_date;
	private Date confirmation_date;
	private String employement_status;
	private String employement_type;
	private String probation_end_date;
	private Date termination_date;
	private String termination_reason;
	private LocalDate created_at;
	private LocalDate updated_at;
	
	public enum Gender {
		
	}

}
