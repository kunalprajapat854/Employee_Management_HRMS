package com.hrms.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "document_type")
@Getter
@Setter
@NoArgsConstructor
public class DocumentType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description of document", nullable = false)
	private String description;

	@Column(name = "is_mandatory", nullable = false)
	private String isMandatory;

	@Column(name = "expiry_applicable", nullable = false)
	private String expiryApplicable;

	@OneToMany(mappedBy = "documenttypeId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EmployeeDocument> documents = new ArrayList<>();

	// Enum

	private DocumentName name;

	public enum DocumentName {
		RESUME, ID_PROOF, ADDRESS_PROOF, CONTRACT, APPRAISA
	}

}
