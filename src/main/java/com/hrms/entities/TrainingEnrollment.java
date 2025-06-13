package com.hrms.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "training_enrollment")
public class TrainingEnrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "enrollment_date", nullable = false)
	private Date enrollmentDate;

	@Column(name = "completion_date", nullable = false)
	private Date completionDate;

	@Column(name = "feedback_comments", nullable = false)
	private String feedbackComments;

	@Column(name = "certificate_issued", nullable = false)
	private String certificateIssued;

	@NotBlank(message = "feedback rating between 1 - 5 ")
	@Column(name = "feedback_rating")
	private Integer feedbackRating;

	// Mapping
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee", nullable = false, unique = true)
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "training_programs", nullable = false, unique = true)
	private TrainingPrograms training_programs;

	// Enums
	@Enumerated(EnumType.STRING)
	private Status status;

	public enum Status {
		ENROLLED, COMPLETED, DROPPED, NO_SHOW
	}

}
