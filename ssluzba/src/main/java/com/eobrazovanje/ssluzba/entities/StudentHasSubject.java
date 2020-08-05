package com.eobrazovanje.ssluzba.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.eobrazovanje.ssluzba.entities.compositeKeys.StudentSubjectKey;

import lombok.Getter;
import lombok.Setter;

@Entity(name="student_has_subject")
@Table(name = "student_has_subject")
@Getter
@Setter
public class StudentHasSubject {
	
	@EmbeddedId
	StudentSubjectKey id;
	
	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	@Getter
	@Setter
	private Student student;
	
	@ManyToOne
	@MapsId("subject_id")
	@JoinColumn(name = "subject_id")
	@Getter
	@Setter
	private Subject subject;
	
	@Column(name = "ocena")
	@Getter
	@Setter
	private int ocena;
	
	
	@Column(name = "br_pokusaja")
	@Getter
	@Setter
	private int brPokusaja;

	public StudentHasSubject() {
		
	}
	
	public StudentHasSubject(StudentSubjectKey id, Student student, Subject subject, int ocena, int brPokusaja) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.ocena = ocena;
		this.brPokusaja = brPokusaja;
	}


	@Override
	public String toString() {
		return "StudentHasSubject [id=" + id + ", student=" + student + ", subject=" + subject + ", ocena=" + ocena
				+ ", brPokusaja=" + brPokusaja + "]";
	}
	
	
	

}
