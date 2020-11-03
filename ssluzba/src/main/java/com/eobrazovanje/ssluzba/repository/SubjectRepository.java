package com.eobrazovanje.ssluzba.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	Set<Subject> findAllById(Long id);

	Subject findSubjectById(Long id);

}
