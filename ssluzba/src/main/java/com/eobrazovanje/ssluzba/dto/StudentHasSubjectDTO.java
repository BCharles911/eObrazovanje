package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentHasSubjectDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3594709586318176040L;
	
	
	private Long studentId;
	private Long subjectId;
	private String studentName;
	private int ocena;
	private int brPokusaja;
	private boolean passed;
	private String indexNumber;
	private Date examDate;
	@JsonIgnore
	private List<ExamDTO> exams;
	private boolean prijavio;
	
	
	
	public StudentHasSubjectDTO() {
		super();
	}


	public StudentHasSubjectDTO(Long studentId, Long subjectId, int ocena, int brPokusaja, boolean passed,
			List<ExamDTO> exams, boolean prijavio, String studentName, String indexNumber, Date examDate) {
		super();
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.ocena = ocena;
		this.brPokusaja = brPokusaja;
		this.passed = passed;
		this.exams = exams;
		this.prijavio = prijavio;
		this.studentName = studentName;
		this.indexNumber = indexNumber;
		this.examDate = examDate;
		
	}
	
	
	
	

}
