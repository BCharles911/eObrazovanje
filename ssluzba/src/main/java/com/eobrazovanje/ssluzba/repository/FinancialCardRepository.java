package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.FinancialCard;

public interface FinancialCardRepository extends JpaRepository<FinancialCard, Long> {

	FinancialCard findFinancialCardById(Long id);
}
