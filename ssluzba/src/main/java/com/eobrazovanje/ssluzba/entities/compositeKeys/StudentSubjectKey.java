package com.eobrazovanje.ssluzba.entities.compositeKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentSubjectKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -41880636394685178L;

	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "subject_id")
	private Long subjectId;
}
