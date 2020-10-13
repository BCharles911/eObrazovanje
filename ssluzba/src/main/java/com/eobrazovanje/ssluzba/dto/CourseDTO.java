package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class CourseDTO implements Serializable {
	
	
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String courseName;
	@Getter
	@Setter
	private String shortName;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private List<SubjectDTO> subjects;
	
	public CourseDTO() {
		super();
	}

	public CourseDTO(Long id, String courseName, String shortName, String description, List<SubjectDTO> subjects) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.shortName = shortName;
		this.description = description;
		this.subjects = subjects;
	}
	
	
	

}
