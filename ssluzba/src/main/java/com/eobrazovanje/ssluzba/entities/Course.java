package com.eobrazovanje.ssluzba.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "course")
//@EqualsAndHashCode
@Getter
@Setter
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	
	@Column(name = "course_name", nullable = false)
	@Getter
	@Setter
	private String courseName;
	
	@Column(name = "short_name", nullable = false)
	@Getter
	@Setter
	private String shortName;
	
	
	@Column(name = "description", nullable = true)
	@Getter
	@Setter
	private String description;
	
	@ManyToMany
	@Getter
	@Setter
	private Set<Subject> subject;
	
    @OneToMany(
            cascade = CascadeType.MERGE,
            orphanRemoval = true
        )
	@Getter
	@Setter
    private List<Student> student = new ArrayList<>();
     



}
