package com.eobrazovanje.ssluzba.entities;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "lecturer")
@Table(name = "student")
@Getter
@Setter
public class Lecturer extends Person {
	
	
	
	
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
	
	
	@ManyToMany
	Set<Subject> subjects;
	
	@ManyToMany
	@JoinTable(
			name = "lecturer_roles",
			joinColumns = @JoinColumn(
					name = "lecturer_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"
					
					)
			)
	private Collection<Role> roles;
	
	

}
