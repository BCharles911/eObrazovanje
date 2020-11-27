package com.eobrazovanje.ssluzba.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private Long id;
	
	@Column(name = "role_name")
	@Getter
	@Setter
	private String name;
	
	
	@ManyToMany(mappedBy = "roles")
	@Getter
	@Setter
	@JsonIgnore
	private Collection<Lecturer> lecturers;
	
	@ManyToMany(mappedBy = "roles")
	@Getter
	@Setter
	@JsonIgnore
	private Collection<Student> students;	
	

	
	@Getter
	@Setter
    @ManyToMany
    @JoinTable(name = "roles_privilege",
    			joinColumns = @JoinColumn(
    					name = "role_id", referencedColumnName = "id"
    					),
    			inverseJoinColumns = @JoinColumn(
    					name = "privilege_id", referencedColumnName = "id"
    					))
    private Collection<Privilege> privileges; 
	
	
	public Role() {
	    super();
	}

	public Role(final String name) {
	    super();
	    this.name = name;
	}

}
