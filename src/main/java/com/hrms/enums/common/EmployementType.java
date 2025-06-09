package com.hrms.enums.common;

public enum EmployementType {

	FULL_TIME("FULL_TIME"), PART_TIME("PART TIME"), CONTRACT("CONTRACT"), INTERN("INTERN");

	private final String displayemployementType;

	EmployementType(String displayemployementType) {
		this.displayemployementType = displayemployementType;
	}

	public String getDisplayemployementType() {
		return displayemployementType;
	}

}
