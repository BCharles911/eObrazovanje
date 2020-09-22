package com.eobrazovanje.ssluzba.entities;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "lecturer")
@Table(name = "lecturer")
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
	

    @OneToMany(mappedBy="lecturer")
    @Getter
    @Setter
    private Set<Exam> exam;
	


	
	
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
	
	
	
	
	
	
	
	
	
	

	@Override
	public String toString() {
		return "Lecturer [firstName=" + firstName + ", lastName=" + lastName + ", exam=" + exam + ", subjects="
				+ subjects + ", roles=" + roles + "]";
	}








	public Lecturer() {
		
	}


	public Lecturer(@NotNull @NotBlank String firstName, @NotBlank String lastName, Set<Exam> exam,
			Set<Subject> subjects, Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.exam = exam;
		this.subjects = subjects;
		this.roles = roles;
	}
	
	
	
	
	
	
	

}
