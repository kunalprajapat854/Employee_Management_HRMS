package com.hrms.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hrms.enums.common.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "username is required")
	@Size(min = 3, max = 50, message = "username must be between 3 to 50 characters")
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;

	@NotBlank(message = "email is required")
	@Email(message = "Email should be valid")
	@Size(max = 100, message = "Email size should be exceed 100 characters")
	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;

	@NotBlank(message = "password is required")
	@Size(min = 8, message = "password must be at least 8 characters long")
	@Column(name = "password", nullable = false)
	private String password;

	@NotBlank(message = "Role is required")
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false, length = 20)
	private Role role;

	@Column(name = "is_active", nullable = false)
	private boolean isactive;

	@CreationTimestamp
	@Column(updatable = false, nullable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(insertable = false, nullable = false)
	private LocalDate updatedDate;

	// association mapping with employee
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Employee employee;

}
