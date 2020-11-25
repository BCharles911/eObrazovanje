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
	
	//isto
	@ManyToOne
	@JoinColumns({
		  @JoinColumn(name = "student_id", insertable = false, updatable = false),
		  @JoinColumn(name = "subject_id", insertable = false, updatable = false)
		})
	private StudentHasSubject studentHasSubject;
	
	@Column(columnDefinition = "TEXT", name="note")
	private String note;
	
	@Column(name= "exam_date")
	private Date examDate;
	
	@Column(name= "ocena")
	private int ocena;
	
	public ExamRecord() {
		super();
	}


	public ExamRecord(String id, ExamPeriod examPeriod, StudentHasSubject studentHasSubject, String note, Date examDate, Integer ocena) {
		super();
		this.id = id;
		this.examPeriod = examPeriod;
		this.studentHasSubject = studentHasSubject;
		this.note = note;
		this.examDate = examDate;
		this.ocena = ocena;
	}
	
	
	
}
