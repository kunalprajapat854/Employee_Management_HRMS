package com.hrms.entities;

import java.sql.Date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hrms.enums.common.EmployementType;
import com.hrms.enums.common.Gender;
import com.hrms.enums.common.Marital;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "employee_id", nullable = false, unique = true, length = 20)
	private String employeeId;

	@NotBlank(message = "first name must be required")
	@Column(name = "first_name", length = 55, nullable = false, unique = true)
	private String firstName;

	@Column(name = "middle_name", length = 45)
	private String middleName;

	@Column(name = "last_name", length = 45, unique = true, nullable = false)
	private String lastName;

	@NotBlank(message = "Date of birth is required")
	@Past(message = "Date of birth must be in the past")
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	@NotNull(message = "Gender is required")
	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false, length = 10)
	private Gender gender;

	@NotBlank(message = "Marital status is required")
	@Enumerated(EnumType.STRING)
	@Column(name = "marital_status", nullable = false, length = 15)
	private Marital maritalStatus;

	@NotBlank(message = "Nationality is required")
	@Column(name = "nationality", length = 50, nullable = false)
	private String nationality;

	@Email(message = "Invalid personal email format")
	@Column(name = "personal_email", length = 100)
	private String personalEmail;

	@Email(message = "Invalid work email format")
	@Column(name = "work_email", length = 100)
	private String workEmail;

	@Pattern(regexp = "^\\\\+?[0-9]{10,15}$", message = "Invalid phone number")
	@Column(name = "phone_number", length = 20)
	private String phoneNumber;

	@Pattern(regexp = "^\\\\+?[0-9]{10,15}$", message = "Invalid emergency number")
	@Column(name = "emergency_contact_number", length = 20)
	private String emergencyContactNumber;

	@Column(name = "current_address", length = 255)
	private String currentAddress;

	@Column(name = "permanent_address", length = 255)
	private String permanentAddress;

	@PastOrPresent(message = "Hire date must be past or present")
	@Column(name = "hire_date")
	private Date hireDate;

	@PastOrPresent(message = "Confirmation date must be in past or today")
	@Column(name = "confirmation_date")
	private Date confirmationDate;

	@Column(name = "employee_status", nullable = false, length = 25)
	@Enumerated(EnumType.STRING)
	private EmployementType employementStatus;

	@NotBlank(message = "Employement type is required")
	@Enumerated(EnumType.STRING)
	@Column(name = "employement_type", nullable = false, length = 25)
	private EmployementType employementType;

	@Pattern(regexp = "^\\\\d{4}-\\\\d{2}-\\\\d{2}$", message = "Probation end date must be in yyyy-MM-dd format\"")
	@Column(name = "probation_end_date", nullable = false, length = 10)
	private Date probationEndDate;

	@PastOrPresent(message = "Termination date must be in past or present")
	@Column(name = "termination_date", length = 10, nullable = false)
	private Date terminationDate;

	@Column(name = "termination_reason", length = 255, nullable = false)
	private String terminationReason;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDate createdAt;

	@UpdateTimestamp
	@Column(name = "update_date", insertable = false)
	private LocalDate updatedAt;

	// association mapping one to one with user
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private user user;

	// mapping with department table with many to one
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EmployeePosition> employeePositions = new ArrayList<>();

	// One Employee -> Many Attendence
	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Attendence> attendences = new ArrayList<>();

}