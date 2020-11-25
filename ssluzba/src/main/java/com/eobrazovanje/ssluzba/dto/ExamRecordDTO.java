package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;

import com.eobrazovanje.ssluzba.entities.ExamPeriod;

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
	private StudentHasSubjectDTO studentHasSubject;
	private ExamPeriod examPeriod;
	private Date examDate;
	private int ocena;

	
	public ExamRecordDTO() {
		super();
	}


	public ExamRecordDTO(String id, String note, StudentHasSubjectDTO studentHasSubject, ExamPeriod examPeriod, Date examDate, Integer ocena) {
		super();
		this.id = id;
		this.note = note;
		this.studentHasSubject = studentHasSubject;
		this.examPeriod = examPeriod;
		this.examDate = examDate;
		this.ocena = ocena;
	}
	
	
}
