package com.hrms.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "position")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Title is required")
	@Column(name = "job_title", nullable = false)
	private String title;

	@NotBlank(message = "Description is required")
	@Size(max = 255, message = "Characters must not be exceed 255")
	@Column(name = "description", length = 255, nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "level", nullable = false)
	private Level level;

	@Pattern(regexp = "^\\\\d+(\\\\.\\\\d{1,2})?$", message = "Mininum salary must be valid number")
	@Column(name = "min_salary")
	private String minSalary;

	@Pattern(regexp = "^\\\\d+(\\\\.\\\\d{1,2})?$", message = "Maximum salary must be valid number")
	@Column(name = "max_salary")
	private String maxSalary;

	@Column(name = "required_skill", nullable = false)
	private String requiredSkill;

	@Column(name = "is_active")
	private boolean isactive;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDate createdAt;

	@UpdateTimestamp
	@Column(name = "update_date", insertable = false)
	private LocalDate updatedAt;

	public enum Level {
		JUNIOR, SENIOR, LEAD, MANAGER, DIRECTOR
	}

	// One Position -> Many EmployeePosition
	@OneToMany(mappedBy = "position", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EmployeePosition> employeePositions = new ArrayList<>();

	// Many Positions -> One Department
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

}