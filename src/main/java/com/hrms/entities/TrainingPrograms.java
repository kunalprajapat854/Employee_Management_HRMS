package com.hrms.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "training_programs")
@Getter
@Setter
@NoArgsConstructor
public class TrainingPrograms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "training_title")
	private String title;

	@Column(name = "description of training", nullable = false)
	private String description;

	@Column(name = "trainer_name", nullable = false)
	private String trainerName;

	@Column(name = "duration_hours", nullable = false)
	private Integer durationHours;

	@Column(name = "max_participants", unique = true)
	private Integer maxParticipants;

	@Column(name = "cost_per_participants", nullable = false, unique = true)
	private double costperParticipants;

	@Enumerated(EnumType.STRING)
	private Trainingtype trainingtype;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Column(name = "location_of_training", nullable = false)
	private String location;

	@Enumerated(EnumType.STRING)
	private Status status;

	// Mapping

	@OneToMany(mappedBy = "training_programs", cascade = CascadeType.ALL)
	private List<TrainingEnrollment> enrollments = new ArrayList<>();

	// Enums

	public enum Trainingtype {
		INTERNAL, EXTERNAL, ONLINE
	}

	public enum Status {
		PLANNED, ONGOING, COMPLETED, CANCELLED
	}

}
