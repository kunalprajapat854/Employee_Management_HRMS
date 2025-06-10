package com.hrms.entities;

import java.sql.Date;
import java.time.LocalDate;

import com.hrms.enums.common.LeaveStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "leave_application")
@Setter
@Getter
@NoArgsConstructor
public class Leave_Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@PastOrPresent(message = "start date must be past or present")
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

	@Column(name = "total_days")
	private Integer totalDays;

	@NotBlank(message = "Reason is compulsory!")
	private String reason;

	@Column(name = "applied_date", nullable = false)
	private Date appliedDate;

	@Column(name = "approved_date")
	private Date approvedDate;

	@Column(name = "rejection_reason", nullable = false)
	private String rejectionReason;

	@Column(name = "supporting_document_url")
	private String supportingDocument_url;

	private LeaveStatus leaveapplicationStatus;

	// Mapping
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "leave_Types" , nullable = false)
	private Leave_Types leave_Types ;

}
