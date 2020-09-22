package com.eobrazovanje.ssluzba.entities;

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

@Entity(name="exam")
@Table(name = "exam")
@Getter
@Setter
@EqualsAndHashCode
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	
	@Column(name  = "passed")
	@Getter
	@Setter
	private boolean hasPassed;
	
	
	@Column(name = "points")
	@Getter
	@Setter
	private int pointsNumber;
	
	
	@Column(name = "isDeleted")
	@Getter
	@Setter
	private boolean isDeleted;

	
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn (name="lecturer_id",referencedColumnName="id",nullable=false,unique=true)
	  private Lecturer lecturer;

	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumns({
			  @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
			  @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")

	  })
	  private StudentHasSubject student_has_subject;
	  

	@Override
	public String toString() {
		return "Exam [id=" + id + ", hasPassed=" + hasPassed + ", pointsNumber=" + pointsNumber + "]";
	}



	
	
	public Exam() {
		
	}


	public Exam(Long id, boolean hasPassed, int pointsNumber, boolean isDeleted) {
		super();
		this.id = id;
		this.hasPassed = hasPassed;
		this.pointsNumber = pointsNumber;
		this.isDeleted = isDeleted;
	}
	
	

}
