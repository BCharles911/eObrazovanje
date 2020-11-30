package com.eobrazovanje.ssluzba.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamObject {
	

	private Long studentId;
	private int grade;
	private int pointNumber;
	private boolean passed;
	
	
	public ExamObject(Long studentId, int grade, boolean passed, int pointNumber) {
		super();
		this.studentId = studentId;
		this.grade = grade;
		this.pointNumber = pointNumber;
		this.passed = passed;
	}
	
	
	
	

}
