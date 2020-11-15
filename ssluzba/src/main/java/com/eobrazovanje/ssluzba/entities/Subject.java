package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "subject")
@EqualsAndHashCode
@ToString
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
	
	
	@Column(name = "place_of_exam", nullable = true)
	private String placeOfExam;
	
	@Column(name = "exam_date")
	private Date examDate;

	@ManyToMany
	@JoinTable(
			name = "subject_lecturer",
			joinColumns = @JoinColumn(name = "subject_id"),
			inverseJoinColumns = @JoinColumn(name = "lecturer_id")
			)
	@Getter
	@Setter
	private Set<Lecturer> lecturer;
	
	@ManyToMany
	@JoinTable(
			name = "subject_course",
			joinColumns = @JoinColumn(name = "subject_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id")
			)
	
	@Getter
	@Setter
	private Set<Course> course;
	
	
	//mappedBy property koristimo da kazemo hibernateu
	//koju varijablu koristimo da reprezentujemo roditeljsku
	//klasu u children klasi
	@OneToMany(mappedBy="subject")
	@Getter
	@Setter
	private Set<Colloqium> colloqium;
	
	@OneToMany(mappedBy = "subject")
	private Set<StudentHasSubject> studentHasSubject;

	public Subject() {
		
	}
	

	
	
	public void SetIfNotEmptyLecturer(Set<Lecturer> lecturer, Lecturer l) {
		this.lecturer = lecturer;
		lecturer.add(l);
	}

	public Subject(Long id, String subjectName, String shortName, int ectsPoints, String description,
			String placeOfExam, Date examDate, Set<Lecturer> lecturer, Set<Course> course, Set<Colloqium> colloqium,
			Set<StudentHasSubject> studentHasSubject) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.shortName = shortName;
		this.ectsPoints = ectsPoints;
		this.description = description;
		this.placeOfExam = placeOfExam;
		this.examDate = examDate;
		this.lecturer = lecturer;
		this.course = course;
		this.colloqium = colloqium;
		this.studentHasSubject = studentHasSubject;
	}

}
