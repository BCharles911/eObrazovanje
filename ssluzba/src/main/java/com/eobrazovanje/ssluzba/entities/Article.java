package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "article")
@Table(name = "article")
@Getter
@Setter
public class Article {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	

	@Column(name = "article_name")
	private String articleName;
	
	
	@Column(columnDefinition = "TEXT", name="article_text")
	private String articeText;
	
    @ManyToOne
    @JoinColumn(name="lecturer_id", nullable=true)
    private Lecturer lecturer;
    
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean important;
    
    @Column(name="date_created")
    private Date dateCreated;
    
    
    @Column(columnDefinition="tinyint(1) default 0")
    private boolean deleted;
    
    public Article() {
    	super();
    }

	public Article(String id, @NotNull @NotBlank String articleName, String articeText, Lecturer lecturer,
			boolean important, Date dateCreated, boolean deleted) {
		super();
		this.id = id;
		this.articleName = articleName;
		this.articeText = articeText;
		this.lecturer = lecturer;
		this.important = important;
		this.dateCreated = dateCreated;
		this.deleted = deleted;
	}


    
    
    
	
	
}
