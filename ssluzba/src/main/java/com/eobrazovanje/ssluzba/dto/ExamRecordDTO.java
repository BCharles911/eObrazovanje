package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;


import com.eobrazovanje.ssluzba.entities.ExamPeriod;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.Subject;


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
	private Student student;
	private Subject subject;
	private String studentId;
	private Long subjectId;
	private String subjectShortName;
	private String subjectName;
	private boolean passed;
	private Long lecturerId;	
	private String lecturerName;
	private ExamPeriod examPeriod;
	private Date examDate;
	private int ocena;

	
	public ExamRecordDTO() {
		super();
	}


	public ExamRecordDTO(String id, String note, /*StudentHasSubjectDTO studentHasSubject */ boolean passed, String studentId, Long subjectId, String subjectShortName, String subjectName, Long lecturerId, String lecturerName, ExamPeriod examPeriod, Date examDate, Integer ocena) {
		super();
		this.id = id;
		this.note = note;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.subjectShortName = subjectShortName;
		this.subjectName = subjectName;
		this.lecturerId = lecturerId;
		this.lecturerName = lecturerName;
		this.passed = passed;
		this.examPeriod = examPeriod;
		this.examDate = examDate;
		this.ocena = ocena;
	}


	public ExamRecordDTO(String id, String note, Student student, Subject subject, String subjectShortName,
			String subjectName, Long lecturerId, String lecturerName, ExamPeriod examPeriod, Date examDate, int ocena, boolean passed) {
		super();
		this.id = id;
		this.note = note;
		this.student = student;
		this.subject = subject;
		this.subjectShortName = subjectShortName;
		this.subjectName = subjectName;
		this.lecturerId = lecturerId;
		this.lecturerName = lecturerName;
		this.examPeriod = examPeriod;
		this.examDate = examDate;
		this.ocena = ocena;
		this.passed = passed;

	}
	
	
}
