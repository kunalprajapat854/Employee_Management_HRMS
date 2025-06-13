package com.hrms.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "performance_cycle_table")
public class PerformanceCycle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Enumerated(EnumType.STRING)
	private CycleType type;

	@Enumerated(EnumType.STRING)
	private CycleStatus status;

	// Mappings

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by")
	private Employee createdBy;

	@OneToMany(mappedBy = "performanceCycleId", fetch = FetchType.LAZY)
	private List<Goal> goals = new ArrayList<>();

	@OneToMany(mappedBy = "performanceCycle", fetch = FetchType.LAZY)
	private List<PerformanceReview> reviews = new ArrayList<>();

	public enum CycleType {
		ANNUAL, HALF_YEARLY, QUARTERLY
	}

	public enum CycleStatus {
		ACTIVE, COMPLETED, DRAFT
	}
}
