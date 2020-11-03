package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="exam")
@Table(name = "exam")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	
	@Column(name  = "passed", nullable = false, columnDefinition = "TINYINT(1)")
	@Getter
	@Setter
	private boolean hasPassed;
	
	
	@Column(name = "points")
	@Getter
	@Setter
	private int pointsNumber;
	
	
	@Column(name = "isDeleted", nullable = false, columnDefinition = "TINYINT(1)")
	@Getter
	@Setter
	private boolean isDeleted;
	
	@Column(name = "exam_date")
	@Getter
	@Setter
	private Date examDate;
	
	@Column(name = "exam_place")
	@Getter
	@Setter
	private String examPlace;
	
	@Column(name = "exam_name")
	@Getter
	@Setter
	private String examName;
	
	
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn (name="lecturer_id",referencedColumnName="id",nullable=false,unique=true)
	  private Lecturer lecturer;

	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumns({
			  @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
			  @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")

	  })
	  private StudentHasSubject student_has_subject;
	  



	
	
	public Exam() {
		
	}


	public Exam(Long id, boolean hasPassed, int pointsNumber, boolean isDeleted) {
		super();
		this.id = id;
		this.hasPassed = hasPassed;
		this.pointsNumber = pointsNumber;
		this.isDeleted = isDeleted;
	}


	public Exam(Long id, boolean hasPassed, int pointsNumber, boolean isDeleted, Date examDate, String examPlace,
			String examName, Lecturer lecturer, StudentHasSubject student_has_subject) {
		super();
		this.id = id;
		this.hasPassed = hasPassed;
		this.pointsNumber = pointsNumber;
		this.isDeleted = isDeleted;
		this.examDate = examDate;
		this.examPlace = examPlace;
		this.examName = examName;
		this.lecturer = lecturer;
		this.student_has_subject = student_has_subject;
	}
	
	

}
