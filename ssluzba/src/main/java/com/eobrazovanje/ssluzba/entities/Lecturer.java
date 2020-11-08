package com.eobrazovanje.ssluzba.entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity(name = "lecturer")
@Table(name = "lecturer")
@Getter
@Setter
public class Lecturer extends Person {	

    @OneToMany(mappedBy="lecturer")
    @Getter
    @Setter
    private Set<Exam> exam;
	
	
	@ManyToMany(mappedBy= "lecturer")
	private Set<Subject> subjects;
	
	
	@OneToMany(mappedBy="lecturer")
	private Set<Document> documents;


	public Lecturer() {
		
	}

	public Lecturer orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String toString() {
		return "Lecturer [exam=" + exam + ", subjects=" + subjects + "]";
	}


	public Lecturer(Set<Exam> exam, Set<Subject> subjects) {
		super();
		this.exam = exam;
		this.subjects = subjects;
	}
	

}
