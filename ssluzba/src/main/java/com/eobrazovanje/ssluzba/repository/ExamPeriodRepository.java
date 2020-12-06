package com.eobrazovanje.ssluzba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.ExamPeriod;

public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long> {
	
	
	@Query("SELECT e FROM exam_period e WHERE e.name = ?1")
	ExamPeriod findByExamPeriodName(String name);

	
	
	
	Optional<List<ExamPeriod>> findByIsActiveTrue();
}
