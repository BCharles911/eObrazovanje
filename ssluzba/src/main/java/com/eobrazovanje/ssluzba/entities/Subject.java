package com.eobrazovanje.ssluzba.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Long id;
	
	
	@Column(name = "subject_name", nullable = false)
	private String subjectName;
	
	@Column(name = "short_name", nullable = false)
	private String shortName;
	
	@Column(name = "ects_points", nullable = false)
	private int ectsPoints;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	
	//mappedBy property koristimo da kazemo hibernateu
	//koju varijablu koristimo da reprezentujemo roditeljsku
	//klasu u children klasi
	@OneToMany(mappedBy="subject")
	private Set<Colloqium> colloqium;
	
	@OneToMany(mappedBy = "subject")
	Set<StudentHasSubject> studentHasSubject;

}
