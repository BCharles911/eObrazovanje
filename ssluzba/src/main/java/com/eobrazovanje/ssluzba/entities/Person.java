package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 *  @author Andrej Dapic
 *	@MappedSuperClass annotation
 *  Designates a class whose mapping information is applied
 *  to the entities that inherit from it. 
 *  A mapped superclass has no separate table defined for it.
 *  A class designated with the MappedSuperclass annotation can be mapped in the same way as an entity except that themappings will apply only to its subclasses since no tableexists for the mapped superclass itself. When applied to thesubclasses the inherited mappings will apply in the contextof the subclass tables. Mapping information may be overriddenin such subclasses by using the AttributeOverride and Association
 *  Override annotations or corresponding XML elements.
 */
@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
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
	
	@JsonIgnore
	@Column(name = "password", length=250)
	@Getter
	@Setter
	private String password;
	
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	@Getter
	@Setter
	private boolean deleted;
	
	
	@Column
	@Getter
	@Setter
	private String username;
	
	@Column(name = "gender")
	@Getter
	@Setter
	private String gender;
	
	
	@Column(name = "date_of_birth")
	@Getter
	@Setter
	private Date dateOfBirth;
	
	@Column(name = "place_of_birth")
	@Getter
	@Setter
	private String placeOfBirth;
	
	@Column(name = "state_of_birth")
	@Getter
	@Setter
	private String stateOfBirth;
	
	@Column(name = "residence_address")
	@Getter
	@Setter
	private String residence_address;
	
	@Column(name = "township")
	@Getter
	@Setter
	private String township;
	
	@Column(name = "city")
	@Getter
	@Setter
	private String city;
	
	@Column(name = "phone_number")
	@Getter
	@Setter
	private String phoneNumber;
	
	@Column(name = "mobile_phone_number")
	@Getter
	@Setter
	private String mobilePhoneNumber;
	
	@Column(name = "email_address")
	@Getter
	@Setter
	private String emailAddress;
	
	@Column(name = "citizenship")
	@Getter
	@Setter
	private String citizenship;
	
	@Column(name = "ethnicity")
	@Getter
	@Setter
	private String ethnicity;
	
	@Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1)")
	@Getter
	@Setter
	private boolean isDeleted;
	
	@ManyToMany
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
					name = "id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"
					
					)
			)
	private Collection<Role> roles;
	
	
	
	
	@Override
	public String toString() {
		return String.format("User type %s with id: %s", this.getClass().getName(),this.getId());
		
	}

}
