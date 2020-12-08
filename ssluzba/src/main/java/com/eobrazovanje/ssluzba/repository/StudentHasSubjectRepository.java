package com.eobrazovanje.ssluzba.repository;



import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eobrazovanje.ssluzba.entities.ExamRecord;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;

public interface StudentHasSubjectRepository extends JpaRepository<StudentHasSubject, Long> {
	
	
	@Query("SELECT s FROM student_has_subject s WHERE s.student = ?1")
	StudentHasSubject findStudentHasSubjectByStudentId(String id);
	
	
	@Query("SELECT s FROM student_has_subject s where s.subject.id = ?1")
	List<StudentHasSubject> findAllBySubjectId(Long id);
	

	@Query("SELECT s FROM student_has_subject s WHERE s.student.id = ?1 and s.passed = 0")
	List<StudentHasSubject> findByStudentId(String id);
	
	
	@Query("SELECT s FROM student_has_subject s WHERE s.student.id = ?1 and s.subject.id = ?2")
	StudentHasSubject findStudentHasSubjectByStudentIdAndSubjectId(String id, Long id2);

	
	
	
	
	@Query("SELECT s.subject FROM student_has_subject s WHERE s.student.id = ?1 and s.passed = 0 and s.prijavio = 0")
	List<Subject> findSubjects(String id);
	
	@Query("SELECT s.subject FROM student_has_subject s WHERE s.student.id = ?1 and s.passed = 0 and s.prijavio = 1")
	List<Subject> findSubjectsPrijavioTrue(String id);
	
	
	@Query("SELECT s FROM student_has_subject s WHERE s.student.id = ?1 and s.passed = 1 and s.prijavio = 0")
	List<StudentHasSubject> findPassedSubject(Long id);
	
	@Query("SELECT s FROM exam_record s WHERE s.student.id = ?1")
	List<ExamRecord> findPassedSubjectHistory(String id);
	
	@Query("SELECT s FROM student_has_subject s WHERE s.student.id = ?1 and s.passed = 0")
	List<StudentHasSubject> findNonPassedSubjects(String id);
	
		
	
/*	@Query("SELECT s from subject s\r\n" + 
			"inner JOIN student_has_subject ON s.id=student_has_subject.subject_id\r\n" + 
			"INNER JOIN student ON student.id = student_has_subject.student_id\r\n" + 
			"WHERE student.id = 2 ")
	StudentHasSubject findSubjectsByStudentId();*/
	
	
	
	@Query("UPDATE student_has_subject s set s.prijavio = 1 where s.student.id = :studentId and s.subject.id = :subjectId")
	void updatePrijavio(@Param("studentId") String studentId, @Param("subjectId") Long subjectId);


	@Query("SELECT s.student from student_has_subject s where prijavio = 1 and s.subject.id= ?1")
	List<Student> findStudentsBySubjectId(Long id);
	
	
}
