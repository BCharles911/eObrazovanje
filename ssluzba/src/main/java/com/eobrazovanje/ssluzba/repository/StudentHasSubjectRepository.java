package com.eobrazovanje.ssluzba.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;

public interface StudentHasSubjectRepository extends JpaRepository<StudentHasSubject, Long> {
	
	
	@Query("SELECT s FROM student_has_subject s WHERE s.student = 2")
	StudentHasSubject findStudentHasSubjectByStudentId();
	
	@Query("SELECT s FROM student_has_subject s WHERE s.student.id = ?1 and s.passed = 0")
	List<StudentHasSubject> findByStudentId(Long id);
	
	
	@Query("SELECT s.subject FROM student_has_subject s WHERE s.student.id = ?1 and s.passed = 0")
	List<Subject> findSubjects(Long id);
	
	
	
/*	@Query("SELECT s from subject s\r\n" + 
			"inner JOIN student_has_subject ON s.id=student_has_subject.subject_id\r\n" + 
			"INNER JOIN student ON student.id = student_has_subject.student_id\r\n" + 
			"WHERE student.id = 2 ")
	StudentHasSubject findSubjectsByStudentId();*/
	
	
	




}
