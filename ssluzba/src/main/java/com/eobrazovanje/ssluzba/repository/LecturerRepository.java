package com.eobrazovanje.ssluzba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.eobrazovanje.ssluzba.entities.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, String> {

	Lecturer findByEmailAddress(String username);

	Lecturer getByUsername(String username);
	
	Lecturer findByFirstName(String firstName);

	@Query("select l then true else false end from lecturer l where l.username = :username")
	boolean existsByUsername(@Param("username") String username);
	
	
	//vrati sve predavace koji ne predaju odredjeni predmet
	@Query("select distinct l.*\r\n" + 
			"from lecturer l\r\n" + 
			"where l.id not in (SELECT a.lecturer_id from subject_lecturer a where a.subject_id = :id)")
	public Optional<Lecturer> findById(@Param("id") Long id);
	
	


}
