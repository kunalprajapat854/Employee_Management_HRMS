package com.hrms.entities;

import java.sql.Date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Not;
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
	private Long employeeId;

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

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Work_Schedule> workscheduleList = new ArrayList<>();

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Leave_Balances> leaveList = new ArrayList<>();

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Leave_Application> leaveappList = new ArrayList<>();

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EmployeeSalary> employeeSalaryList = new ArrayList<>();

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Payroll_Records> payrolllist = new ArrayList<>();

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Goal> goalsList = new ArrayList<>();

	@OneToMany(mappedBy = "createdBy", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<PerformanceCycle> performanceList = new ArrayList<>();

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<PerformanceReview> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "reviewer", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<PerformanceReview> performanceReviews = new ArrayList<>();

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<TrainingEnrollment> enrollments = new ArrayList<>();

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EmployeeSkill> employeeSkills = new ArrayList<>();

	@OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EmployeeDocument> documents = new ArrayList<>();

	@OneToMany(mappedBy = "recipient", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Notification> notifications = new ArrayList<>();

	@OneToMany(mappedBy = "sender", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Notification> allnotlist = new ArrayList<>();

	@OneToMany(mappedBy = "relatedEmployee", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Notification> list = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Marital getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Marital maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public EmployementType getEmployementStatus() {
		return employementStatus;
	}

	public void setEmployementStatus(EmployementType employementStatus) {
		this.employementStatus = employementStatus;
	}

	public EmployementType getEmployementType() {
		return employementType;
	}

	public void setEmployementType(EmployementType employementType) {
		this.employementType = employementType;
	}

	public Date getProbationEndDate() {
		return probationEndDate;
	}

	public void setProbationEndDate(Date probationEndDate) {
		this.probationEndDate = probationEndDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String getTerminationReason() {
		return terminationReason;
	}

	public void setTerminationReason(String terminationReason) {
		this.terminationReason = terminationReason;
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

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<EmployeePosition> getEmployeePositions() {
		return employeePositions;
	}

	public void setEmployeePositions(List<EmployeePosition> employeePositions) {
		this.employeePositions = employeePositions;
	}

	public List<Attendence> getAttendences() {
		return attendences;
	}

	public void setAttendences(List<Attendence> attendences) {
		this.attendences = attendences;
	}

	public List<Work_Schedule> getWorkscheduleList() {
		return workscheduleList;
	}

	public void setWorkscheduleList(List<Work_Schedule> workscheduleList) {
		this.workscheduleList = workscheduleList;
	}

	public List<Leave_Balances> getLeaveList() {
		return leaveList;
	}

	public void setLeaveList(List<Leave_Balances> leaveList) {
		this.leaveList = leaveList;
	}

	public List<Leave_Application> getLeaveappList() {
		return leaveappList;
	}

	public void setLeaveappList(List<Leave_Application> leaveappList) {
		this.leaveappList = leaveappList;
	}

	public List<EmployeeSalary> getEmployeeSalaryList() {
		return employeeSalaryList;
	}

	public void setEmployeeSalaryList(List<EmployeeSalary> employeeSalaryList) {
		this.employeeSalaryList = employeeSalaryList;
	}

	public List<Payroll_Records> getPayrolllist() {
		return payrolllist;
	}

	public void setPayrolllist(List<Payroll_Records> payrolllist) {
		this.payrolllist = payrolllist;
	}

	public List<Goal> getGoalsList() {
		return goalsList;
	}

	public void setGoalsList(List<Goal> goalsList) {
		this.goalsList = goalsList;
	}

	public List<PerformanceCycle> getPerformanceList() {
		return performanceList;
	}

	public void setPerformanceList(List<PerformanceCycle> performanceList) {
		this.performanceList = performanceList;
	}

	public List<PerformanceReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<PerformanceReview> reviews) {
		this.reviews = reviews;
	}

	public List<PerformanceReview> getPerformanceReviews() {
		return performanceReviews;
	}

	public void setPerformanceReviews(List<PerformanceReview> performanceReviews) {
		this.performanceReviews = performanceReviews;
	}

	public List<TrainingEnrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<TrainingEnrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public List<EmployeeSkill> getEmployeeSkills() {
		return employeeSkills;
	}

	public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	public List<EmployeeDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<EmployeeDocument> documents) {
		this.documents = documents;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Notification> getAllnotlist() {
		return allnotlist;
	}

	public void setAllnotlist(List<Notification> allnotlist) {
		this.allnotlist = allnotlist;
	}

	public List<Notification> getList() {
		return list;
	}

	public void setList(List<Notification> list) {
		this.list = list;

	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}