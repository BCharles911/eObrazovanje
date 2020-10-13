package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eobrazovanje.ssluzba.entities.StudentHasSubject;

public interface StudentHasSubjectRepository extends JpaRepository<StudentHasSubject, Long> {
	
	
	@Query("SELECT s FROM student_has_subject s WHERE s.student = 2")
	StudentHasSubject findStudentHasSubjectByStudentId();

}
