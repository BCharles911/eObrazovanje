package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class SubjectDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5101389299406024438L;
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String subjectName;
	@Getter
	@Setter
	private String shortName;
	@Getter
	@Setter
	private int ectsPoints;
	@Getter
	@Setter
	private List<LecturerDTO> lecturerDTO;
	@Getter
	@Setter
	private List<CourseDTO> coursesDTO;
	@Getter
	@Setter
	private List<ColloqiumDTO> colloqiumsDTO;
	@Getter
	@Setter
	private List<StudentHasSubjectDTO> studentHasSubDTO;

	
	
	
	public SubjectDTO() {
		super();
	}



	public SubjectDTO(Long id, String subjectName, String shortName, int ectsPoints, List<LecturerDTO> lecturerDTO,
			List<CourseDTO> coursesDTO, List<ColloqiumDTO> colloqiumsDTO,
			List<StudentHasSubjectDTO> studentHasSubDTO) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.shortName = shortName;
		this.ectsPoints = ectsPoints;
		this.lecturerDTO = lecturerDTO;
		this.coursesDTO = coursesDTO;
		this.colloqiumsDTO = colloqiumsDTO;
		this.studentHasSubDTO = studentHasSubDTO;
		
	}
	
	
	
	
	
	
}
