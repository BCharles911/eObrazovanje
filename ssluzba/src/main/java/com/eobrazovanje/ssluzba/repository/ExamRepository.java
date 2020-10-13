package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
