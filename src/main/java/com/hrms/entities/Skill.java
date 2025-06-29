package com.hrms.entities;

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
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "skill_name", nullable = false)
	private String name;

	@NotNull(message = "skill description is required")
	@Column(name = "description", nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	private SkillCategory category;

	// Mapping

	@OneToMany(mappedBy = "skill_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmployeeSkill> employeeSkills = new ArrayList<>();

	// Enum

	public enum SkillCategory {
		TECHNICAL, SOFT_SKILL, DOMAIN_KNOWLEDGE
	}

}
