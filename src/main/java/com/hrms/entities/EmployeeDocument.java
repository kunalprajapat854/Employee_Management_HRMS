package com.hrms.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee_document")
public class EmployeeDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "document_name", nullable = false)
	private String documentName;

	@Column(name = "file_path", nullable = false)
	private String filePath;

	@Column(name = "upload_date")
	private Date uploadDate;

	@Column(name = "expiry_date")
	private Date expiryDate;

	// Mapping
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee", nullable = false)
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "documenttypeId", nullable = false)
	private DocumentType documenttypeId;

	// Enum

	private Status status;

	public enum Status {
		PENDING_VERIFICATION, VERIFIED, REJECTED, EXPIRED
	}

}
