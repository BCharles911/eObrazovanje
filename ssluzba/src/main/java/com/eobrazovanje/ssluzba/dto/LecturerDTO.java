package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import com.eobrazovanje.ssluzba.entities.Role;
import com.eobrazovanje.ssluzba.entities.Subject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LecturerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4676112629393183460L;

	
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
	private String emailAddress;
	private String citizenship;
	private String ethnicity;
	private Collection<Role> roles;

	
	public LecturerDTO() {
		super();
	}

	public LecturerDTO(Long id, String firstName, String lastName, boolean deleted, String username, String gender,
			Date dateOfBirth, String placeOfBirth, String stateOfBirth, String residence_address, String township,
			String city, String phoneNumber, String mobilePhoneNumber, String emailAddress, String citizenship,
			String ethnicity, Collection<Role> roles) {
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
		this.emailAddress = emailAddress;
		this.citizenship = citizenship;
		this.ethnicity = ethnicity;
		this.roles = roles;
			
		
	}
	
	
	
}
