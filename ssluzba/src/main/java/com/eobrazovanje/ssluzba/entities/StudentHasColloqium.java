package com.eobrazovanje.ssluzba.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.eobrazovanje.ssluzba.entities.compositeKeys.StudentSubjectKey;

import lombok.Getter;
import lombok.Setter;

@Entity(name="student_has_colloqium")
@Table(name = "student_has_colloqium")
@Getter
@Setter
public class StudentHasColloqium {
	
	@EmbeddedId
	StudentSubjectKey id;
	
	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	@Getter
	@Setter
	private Student student;
	
	@ManyToOne
	@MapsId("colloqium_id")
	@JoinColumn(name = "colloqium_id")
	@Getter
	@Setter
	private Colloqium colloqium;

	public StudentHasColloqium(StudentSubjectKey id, Student student, Colloqium colloqium) {
		super();
		this.id = id;
		this.student = student;
		this.colloqium = colloqium;
	}

	@Override
	public String toString() {
		return "StudentHasColloqium [id=" + id + ", student=" + student + ", colloqium=" + colloqium + "]";
	}
	
	
	

}
