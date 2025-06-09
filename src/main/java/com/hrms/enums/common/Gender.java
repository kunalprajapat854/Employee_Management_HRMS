package com.hrms.enums.common;

public enum Gender {

	MALE("MALE"), FEMALE("FEMALE"), OTHER("OTHER");

	private final String displayName;

	Gender(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
