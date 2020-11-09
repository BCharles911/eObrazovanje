package com.eobrazovanje.ssluzba.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Transaction findTransactionById(Long id);
	
	@Query("select t from transaction t where t.financial_card_id = ?1")
	List<Transaction> findByFinancialCardId(Long id);
}
