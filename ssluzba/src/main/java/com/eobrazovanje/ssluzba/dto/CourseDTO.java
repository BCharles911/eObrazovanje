package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8485305822931255056L;

	private Long id;
	private String courseName;
	private String shortName;
	private String description;
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
