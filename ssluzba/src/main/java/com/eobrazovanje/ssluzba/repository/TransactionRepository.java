package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
