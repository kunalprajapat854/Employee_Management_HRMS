package com.hrms.entities;

import java.sql.Date;

import com.hrms.enums.common.HolidayType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "holiday_table")
public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "holiday_name", nullable = false)
	private String name;

	@Column(name = "holiday_date", nullable = false)
	private Date date;

	@Column(name = "holiday_type")
	private HolidayType holidaytype;

	@Column(name = "is_optional")
	private String isOptional;

	@Column(name = "description_of_holiday", nullable = false)
	private String description;

}
