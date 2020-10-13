package com.eobrazovanje.ssluzba.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findStudentById(Long id);

	Student getByUsername(String username);
	
	

}
