package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.FinancialCard;
import com.eobrazovanje.ssluzba.entities.Student;

public interface FinancialCardRepository extends JpaRepository<FinancialCard, Long> {

	FinancialCard findFinancialCardById(Long id);
	
	@Query("select fc from financial_card fc where fc.student.student_id = ?1")
	FinancialCard findFinancialCardByStudentId(Long id);
}
