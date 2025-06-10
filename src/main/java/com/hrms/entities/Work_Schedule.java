package com.hrms.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "work_schedule_table")
public class Work_Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Schedule name must be required")
	@Column(name = "schedule_name", nullable = false, unique = true)
	private String scheduleName;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "effective_from", nullable = false)
	private LocalDate effectiveFrom;

	@Column(name = "effective_to", nullable = false)
	private LocalDate effectiveto;

	@Column(name = "monday_start")
	private LocalTime mondayStart;

	@Column(name = "monday_end")
	private LocalTime mondayEnd;

	@Column(name = "tuesday_start")
	private LocalTime tuesdayStart;

	@Column(name = "tuesday_end")
	private LocalTime tuesdayEnd;

	@Column(name = "wednesday_start")
	private LocalTime wednesdayStart;

	@Column(name = "wednesday_end")
	private LocalTime wednesdayEnd;

	@Column(name = "thursday_start")
	private LocalTime thursdayStart;

	@Column(name = "thursday_end")
	private LocalTime thursdayEnd;

	@Column(name = "friday_start")
	private LocalTime fridayStart;

	@Column(name = "friday_end")
	private LocalTime fridayEnd;

	@Column(name = "saturday_start")
	private LocalTime saturdayStart;

	@Column(name = "saturday_end")
	private LocalTime saturdayEnd;

	@Column(name = "sunday_start")
	private LocalTime sundayStart;

	@Column(name = "sunday_end")
	private LocalTime sundayEnd;

	// mapping
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", nullable = false, unique = true)
	private Employee employee;

}
