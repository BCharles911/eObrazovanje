package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.eobrazovanje.ssluzba.entities.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

	Lecturer findByEmailAddress(String username);

	Lecturer getByUsername(String username);
	
	Lecturer findByFirstName(String firstName);

	@Query("select l then true else false end from lecturer l where l.username = :username")
	boolean existsByUsername(@Param("username") String username);
	
	

}
