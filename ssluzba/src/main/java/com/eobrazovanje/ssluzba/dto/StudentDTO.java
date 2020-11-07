package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import com.eobrazovanje.ssluzba.entities.Role;
import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8381966922184846861L;

	
	private Long id;
	private String firstName;
	private String lastName;
	private boolean deleted;
	private String username;
	private String gender;
	private Date dateOfBirth;
	private String placeOfBirth;
	private String stateOfBirth;
	private String residence_address;
	private String township;
	private String city;
	private String phoneNumber;
	private String mobilePhoneNumber;
	private String citizenship;
	private String ethnicity;
	private String indexNumber;
	private String highSchool;
	private String hsFinishYear;
	private String parentName;
	private int currentYear;
	private CourseDTO course;
	private double avgGrade;
	private FinancialCardDTO financialCard;
	private STUDENT_STATUS studentStatus;
	private List<StudentHasSubjectDTO> studentHasSubjectDTO;
	private Collection<Role> roles;
	
	public StudentDTO() {
		
	}

	public StudentDTO(Long id, String firstName, String lastName, boolean deleted, String username, String gender,
			Date dateOfBirth, String placeOfBirth, String stateOfBirth, String residence_address, String township,
			String city, String phoneNumber, String mobilePhoneNumber, String citizenship, String ethnicity,
			String indexNumber, String highSchool, String hsFinishYear, String parentName, int currentYear,
			CourseDTO course, double avgGrade, STUDENT_STATUS studentStatus,
			List<StudentHasSubjectDTO> studentHasSubjectDTO, Collection<Role> roles , FinancialCardDTO financialCard) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deleted = deleted;
		this.username = username;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.stateOfBirth = stateOfBirth;
		this.residence_address = residence_address;
		this.township = township;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.citizenship = citizenship;
		this.ethnicity = ethnicity;
		this.indexNumber = indexNumber;
		this.highSchool = highSchool;
		this.hsFinishYear = hsFinishYear;
		this.parentName = parentName;
		this.currentYear = currentYear;
		this.course = course;
		this.avgGrade = avgGrade;
		this.studentStatus = studentStatus;
		this.studentHasSubjectDTO = studentHasSubjectDTO;
		this.roles = roles;
		this.financialCard = financialCard;
	}
	
	
	
	
}
