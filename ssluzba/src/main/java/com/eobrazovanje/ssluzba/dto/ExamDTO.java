package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 886609731829829552L;
	
	
	private Long id;
	private boolean hasPassed;
	private int pointsNumber;
	private boolean isDeleted;
	private Date examDate;
	private String examPlace;
	private String examName;
	private String studentId;
	private Long subjectId;
	
	//private StudentHasSubjectDTO studentHasSubject;
	
	public ExamDTO(Long id, boolean hasPassed, int pointsNumber, boolean isDeleted) {
		super();
		this.id = id;
		this.hasPassed = hasPassed;
		this.pointsNumber = pointsNumber;
		this.isDeleted = isDeleted;
		
		//this.studentHasSubject = studentHasSubject;
	}
	
	
	public ExamDTO() {
		super();
	}

}
