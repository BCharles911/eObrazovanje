package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

	Lecturer findByEmailAddress(String username);

	Lecturer getByUsername(String username);
	
	Lecturer findByFirstName(String firstName);

	
	

}
