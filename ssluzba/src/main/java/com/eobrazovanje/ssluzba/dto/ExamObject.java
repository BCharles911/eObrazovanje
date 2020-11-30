package com.eobrazovanje.ssluzba.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamObject {
	
	private StudentDTO student;
	private int grade;
	private boolean passed;
	
	
	public ExamObject(StudentDTO student, int grade, boolean passed) {
		super();
		this.student = student;
		this.grade = grade;
		this.passed = passed;
	}
	
	
	
	

}
