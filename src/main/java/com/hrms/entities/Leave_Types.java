package com.hrms.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.hrms.enums.common.LeaveTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "leave_types")
public class Leave_Types {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Description is required")
	private String description;

	@Column(name = "is_paid", nullable = false)
	private String ispaid;

	@Column(name = "required_document", nullable = false)
	private String requiredDocument;

	@Column(name = "is_active", nullable = false)
	private boolean isactive;

	@Column(name = "advanced_notice_days", nullable = false)
	private String advanceNoticeDays;

	private LeaveTypes leavetypes;

	// Mapping
	@OneToMany(mappedBy = "leave_Types", orphanRemoval = true)
	private List<Leave_Application> listapplication = new ArrayList<>();
}
