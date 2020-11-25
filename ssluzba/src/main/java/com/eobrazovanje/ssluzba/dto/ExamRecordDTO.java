package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.eobrazovanje.ssluzba.entities.ExamPeriod;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamRecordDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5933713732794315523L;
	
	
	private String id;
	private String note;
	//private StudentHasSubjectDTO studentHasSubject;
	private Long studentId;
	private Long subjectId;
	private String subjectShortName;
	private String subjectName;
	
	private Long lecturerId;	
	private String lecturerName;
	
	
	//private Student student;
	//private Subject subject;
	private ExamPeriod examPeriod;
	private Date examDate;
	private int ocena;

	
	public ExamRecordDTO() {
		super();
	}


	public ExamRecordDTO(String id, String note, /*StudentHasSubjectDTO studentHasSubject */ Long studentId, Long subjectId, String subjectShortName, String subjectName, Long lecturerId, String lecturerName, ExamPeriod examPeriod, Date examDate, Integer ocena) {
		super();
		this.id = id;
		this.note = note;
		//this.studentHasSubject = studentHasSubject;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.subjectShortName = subjectShortName;
		this.subjectName = subjectName;
		
		this.lecturerId = lecturerId;
		this.lecturerName = lecturerName;
		
		
		//this.student = student;
		//subject = subject;
		this.examPeriod = examPeriod;
		this.examDate = examDate;
		this.ocena = ocena;
	}
	
	
}
