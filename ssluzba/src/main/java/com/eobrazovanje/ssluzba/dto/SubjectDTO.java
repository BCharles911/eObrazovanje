package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class SubjectDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5101389299406024438L;

	private Long id;
	private String subjectName;
	private String shortName;
	private int ectsPoints;
	private List<LecturerDTO> lecturerDTO;
	private List<CourseDTO> coursesDTO;
	private List<ColloqiumDTO> colloqiumsDTO;
	private List<StudentHasSubjectDTO> studentHasSubDTO;
	private Date examDate;
	private String placeOfExam;	
	private Time examTime;
	
	
	public SubjectDTO() {
		super();
	}



	public SubjectDTO(Long id, String subjectName, String shortName, int ectsPoints, List<LecturerDTO> lecturerDTO,
			List<CourseDTO> coursesDTO, List<ColloqiumDTO> colloqiumsDTO, List<StudentHasSubjectDTO> studentHasSubDTO,
			Date examDate, String placeOfExam, Time examTime) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.shortName = shortName;
		this.ectsPoints = ectsPoints;
		this.lecturerDTO = lecturerDTO;
		this.coursesDTO = coursesDTO;
		this.colloqiumsDTO = colloqiumsDTO;
		this.studentHasSubDTO = studentHasSubDTO;
		this.examDate = examDate;
		this.placeOfExam = placeOfExam;
		this.examTime = examTime;
	}




	
	
	
	
	
}
