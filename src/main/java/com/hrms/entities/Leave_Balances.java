package com.hrms.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Leave_Balances {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "year")
	private String year;

	@Column(name = "allocated_days", nullable = false)
	private String allocatedDays;

	@Column(name = "used_days", nullable = false)
	private String usedDays;

	@Column(name = "remaining_days", nullable = false)
	private String remainingDays;

	@Column(name = "carry_forward_days", nullable = false)
	private String carryForwardDays;

	// Mapping 
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", unique = true)
	private Employee employee ;
	

}
