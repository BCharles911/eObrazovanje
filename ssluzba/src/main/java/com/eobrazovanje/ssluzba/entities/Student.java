package com.eobrazovanje.ssluzba.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student extends Person {

	
	@NotNull
	@NotBlank
	@Column(name = "first_name", nullable = false)
	@Getter
	@Setter
	private String firstName;
	

	@NotBlank
	@Column(name = "last_name", nullable = false)
	@Getter
	@Setter
	private String lastName;
	
	@NotBlank
	@Column(name = "index_name", nullable = false, unique = true)
	@Getter
	@Setter
	private String indexNumber;
	
	@Column(name = "high_school", nullable = false)
	@Getter
	@Setter
	private String highSchool;
	
	@Column(name = "hs_finish_year")
	@Getter
	@Setter
	private String hsFinishYear;
	
	@Column(name = "parent_name")
	@Getter
	@Setter
	private String parentName;
	
	@Column(name = "current_year", nullable = false)
	@Getter
	@Setter
	private int currentYear;
	
	// da li dodati polje avg grade?
	@Column(name = "avg_grade")
	@Getter
	@Setter
	private Double avgGrade;
	
	
	@OneToMany(mappedBy = "student")
	@Getter
	@Setter
	Set<StudentHasSubject> studentHasSubject;

	public Student() {
		
	}
	
	
	
	

	public Student(@NotNull @NotBlank String firstName, @NotBlank String lastName, @NotBlank String indexNumber,
			String highSchool, String hsFinishYear, String parentName, int currentYear, Double avgGrade,
			Set<StudentHasSubject> studentHasSubject) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.indexNumber = indexNumber;
		this.highSchool = highSchool;
		this.hsFinishYear = hsFinishYear;
		this.parentName = parentName;
		this.currentYear = currentYear;
		this.avgGrade = avgGrade;
		this.studentHasSubject = studentHasSubject;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", indexNumber=" + indexNumber
				+ ", highSchool=" + highSchool + ", hsFinishYear=" + hsFinishYear + ", parentName=" + parentName
				+ ", currentYear=" + currentYear + ", avgGrade=" + avgGrade + ", studentHasSubject=" + studentHasSubject
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
}
