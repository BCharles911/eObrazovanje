package com.eobrazovanje.ssluzba.entities.compositeKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentColloqiumKey implements Serializable {
	

		/**
	 * 
	 */
	private static final long serialVersionUID = 9163979653773224277L;

		@Column(name = "student_id")
		private Long studentId;
		
		@Column(name = "colloqium_id")
		private Long colloqiumId;

}
