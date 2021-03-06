package com.eobrazovanje.ssluzba.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subject")
@EqualsAndHashCode
@Getter
@Setter
public class Subject {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	
	@Column(name = "subject_name", nullable = false)
	@Getter
	@Setter
	private String subjectName;
	
	@Column(name = "short_name", nullable = false)
	@Getter
	@Setter
	private String shortName;
	
	@Column(name = "ects_points", nullable = false)
	@Getter
	@Setter
	private int ectsPoints;
	
	@Column(name = "description", nullable = true)
	@Getter
	@Setter
	private String description;
	
	@ManyToMany
	@Getter
	@Setter
	private Set<Lecturer> lecturer;
	
	
	//mappedBy property koristimo da kazemo hibernateu
	//koju varijablu koristimo da reprezentujemo roditeljsku
	//klasu u children klasi
	@OneToMany(mappedBy="subject")
	private Set<Colloqium> colloqium;
	
	@OneToMany(mappedBy = "subject")
	Set<StudentHasSubject> studentHasSubject;

	public Subject() {
		
	}
	
	public Subject(Long id, String subjectName, String shortName, int ectsPoints, String description,
			Set<Lecturer> lecturer, Set<Colloqium> colloqium, Set<StudentHasSubject> studentHasSubject) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.shortName = shortName;
		this.ectsPoints = ectsPoints;
		this.description = description;
		this.lecturer = lecturer;
		this.colloqium = colloqium;
		this.studentHasSubject = studentHasSubject;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + ", shortName=" + shortName + ", ectsPoints="
				+ ectsPoints + ", description=" + description + ", lecturer=" + lecturer + ", colloqium=" + colloqium
				+ ", studentHasSubject=" + studentHasSubject + "]";
	}
	
	
	

}
