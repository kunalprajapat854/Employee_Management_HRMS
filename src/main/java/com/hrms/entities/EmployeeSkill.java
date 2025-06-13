package com.hrms.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Setter
@Getter
@NoArgsConstructor
@Table(name = "employee_skill")
public class EmployeeSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "years_of_experince", nullable = false)
	private Integer yearsOfExperience;

	@Column(name = "last_accessed_date", nullable = false)
	private Date lastAccessedDate;

	// Mapping
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee", nullable = false, unique = true)
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id", nullable = true, unique = true)
	private Skill skill_id;

	// Enum

	private Proficiency proficiencylevel;

	public enum Proficiency {
		BEGINNER, INTERMEDIATE, ADVANCED, EXPERT
	}

}
