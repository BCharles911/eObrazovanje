package com.eobrazovanje.ssluzba.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eobrazovanje.ssluzba.entities.ExamRecord;

@Repository
public interface ExamRecordRepository extends JpaRepository<ExamRecord, String> {
/*	
	@Query("SELECT ep FROM exam_record ep WHERE ep.studentHasSubject = ?1")
	List<ExamRecord> findExamRecordByStudentId(Long id);

	*/
	Set<ExamRecord> findAllById(Long id);
	
	ExamRecord findExamRecordById(String string);
	
	//List<ExamRecord> findAllByStudentId(Long id);
}
