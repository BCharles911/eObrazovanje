package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "exam_record")
@Table(name = "exam_record")
@Getter
@Setter
public class ExamRecord {
	
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	//jedan examRecord ima vise examPerioda
	@ManyToOne
	@JoinColumn(name="exam_period_id", nullable = true)
	private ExamPeriod examPeriod;
	
/*	UBACUJEMO POJEDINACNO STUDENT I SUBJECT
	//isto
	@ManyToOne
	@JoinColumns({
		  @JoinColumn(name = "student_id", insertable = false, updatable = false),
		  @JoinColumn(name = "subject_id", insertable = false, updatable = false)
		})
	private StudentHasSubject studentHasSubject;
*/	
	
	@ManyToOne
	//@MapsId("student_id")
	@JoinColumn(name = "student_id")
	@Getter
	@Setter
	@JsonIgnore
	private Student student;
	
	@ManyToOne
	//@MapsId("subject_id")
	@JoinColumn(name = "subject_id")
	@Getter
	@Setter
	private Subject subject;
	
	
	@ManyToOne
	//@MapsId("lecturer_id")
	@JoinColumn(name = "lecturer_id")
	@Getter
	@Setter
	private Lecturer lecturer;
	
	
	
	
	
	
	@Column(columnDefinition = "TEXT", name="note")
	private String note;
	
	@Column(name= "exam_date")
	private Date examDate;
	
	@Column(name= "ocena")
	private int ocena;
	
	@Column(name =  "passed", nullable = false, columnDefinition = "TINYINT(1)")
	private boolean passed;
	
	public ExamRecord() {
		super();
	}


	public ExamRecord(String id, ExamPeriod examPeriod, Student student, Subject subject, Lecturer lecturer, String note, Date examDate, Integer ocena) {
		super();
		this.id = id;
		this.examPeriod = examPeriod;
		//this.studentHasSubject = studentHasSubject;
		this.student = student;
		this.subject = subject;
		this.lecturer = lecturer;
		this.note = note;
		this.examDate = examDate;
		this.ocena = ocena;
	}
	
	
	
}
