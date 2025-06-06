package com.hrms.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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

	public enum Role {
		ADMIN("ADMIN"), HR_MANAGER("HR_MANAGER"), MANAGER("MANAGER"), EMPLOYEE("EMPLOYEE");

		Role(String string) {
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public user(Long id,
			@NotBlank(message = "username is required") @Size(min = 3, max = 50, message = "username must be between 3 to 50 characters") String username,
			@NotBlank(message = "email is required") @Email(message = "Email should be valid") @Size(max = 100, message = "Email size should be exceed 100 characters") String email,
			@NotBlank(message = "password is required") @Size(min = 8, message = "password must be at least 8 characters long") String password,
			@NotBlank(message = "Role is required") Role role, boolean isactive, LocalDate createdDate,
			LocalDate updatedDate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.isactive = isactive;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
				+ role + ", isactive=" + isactive + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}

}
