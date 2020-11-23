package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.ExamRecord;

public interface ExamRecordRepository extends JpaRepository<ExamRecord, String> {
	

}
