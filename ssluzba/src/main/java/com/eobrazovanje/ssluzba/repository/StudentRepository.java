package com.eobrazovanje.ssluzba.repository;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.eobrazovanje.ssluzba.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findStudentById(Long id);

	Student getByUsername(String username);
	
	
	@Query("select s then true else false end from student s where s.username = :username")
	boolean existsByUsername(@Param("username") String username);
	
	

	

}
