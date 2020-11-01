package com.eobrazovanje.ssluzba.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.eobrazovanje.ssluzba.entities.compositeKeys.StudentColloqiumKey;

import lombok.Getter;
import lombok.Setter;

@Entity(name="student_has_colloqium")
@Table(name = "student_has_colloqium")
@Getter
@Setter
public class StudentHasColloqium {
	
	@EmbeddedId
	StudentColloqiumKey id;
	
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
	
	@Column(name = "points_acquired")
	@Getter
	@Setter
	private int pointsAcquired;
	

	public StudentHasColloqium(StudentColloqiumKey id, Student student, Colloqium colloqium) {
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
