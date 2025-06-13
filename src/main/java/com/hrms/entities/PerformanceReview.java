package com.hrms.entities;

import java.time.LocalDateTime;

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
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "performance_review_table")
public class PerformanceReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "review_type")
	private ReviewType reviewType;

	@Column(name = "overall_rating")
	private Integer overallRating;

	@Column(columnDefinition = "TEXT")
	private String strengths;

	@Column(name = "areas_for_improvement", columnDefinition = "TEXT")
	private String areasForImprovement;

	@Column(name = "goals_for_next_period", columnDefinition = "TEXT")
	private String goalsForNextPeriod;

	@Enumerated(EnumType.STRING)
	private ReviewStatus status;

	@Column(name = "submitted_date")
	private LocalDateTime submittedDate;

	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	// Mapping
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reviewer_id")
	private Employee reviewer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "performance_cycle_id")
	private PerformanceCycle performanceCycle;
	

	public enum ReviewType {
		SELF, MANAGER, PEER, SUBORDINATE
	}

	public enum ReviewStatus {
		DRAFT, SUBMITTED, COMPLETED
	}

}
