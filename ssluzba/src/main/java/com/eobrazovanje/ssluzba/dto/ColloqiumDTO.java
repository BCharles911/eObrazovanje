package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ColloqiumDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6527521118833164794L;

	
	private Long id;
	private String place;
	private Date startDate;
	private int pointNumber;
	private Long subjectId;
	
	public ColloqiumDTO() {
		super();
	}

	public ColloqiumDTO(Long id, String place, Date startDate, int pointNumber, Long subjectId) {
		super();
		this.id = id;
		this.place = place;
		this.startDate = startDate;
		this.pointNumber = pointNumber;
		this.subjectId = subjectId;
	}
	
	
	
	
}
