package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;




import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ArticleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7339381418378423355L;

	private String id;
	private String articleName;
	private String articleText;
	private Date dateCreated;
	private LecturerDTO lecturer;
	private boolean important;
	
	public ArticleDTO() {
		super();
	}
	

	public ArticleDTO(String id, String articleName, String articleText, Date dateCreated, LecturerDTO lecturer,
			boolean important) {
		super();
		this.id = id;
		this.articleName = articleName;
		this.articleText = articleText;
		this.dateCreated = dateCreated;
		this.lecturer = lecturer;
		this.important = important;
	}
	
	
	
}
