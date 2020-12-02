package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;
import java.sql.Time;

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
	

	
	@ManyToOne
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	
	@ManyToOne
	@JoinColumn(name = "lecturer_id")
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
