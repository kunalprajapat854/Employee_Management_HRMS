package com.hrms.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hrms.enums.common.GoalStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goal_table")
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "goal_title", nullable = false)
	private String title;

	@Column(name = "goal_description", nullable = false)
	private String description;

	@Column(name = "weight_percentage")
	private double weightpercentage;

	@Column(name = "target_complete_date", nullable = false)
	private LocalDate targetCompleteDate;
	private GoalStatus status;

	@Column(name = "achievement_percentage", nullable = false)
	private double achievementPercentage;

	@CreationTimestamp
	@Column(name = "created_data", updatable = false)
	private LocalDate createdAT;

	@UpdateTimestamp
	@Column(name = "updated_date", insertable = false)
	private LocalDate updatedAt;

	// Mapping
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "performanceCycleId"  , nullable = false)
	private PerformanceCycle performanceCycleId;
	
	
	
	


}
