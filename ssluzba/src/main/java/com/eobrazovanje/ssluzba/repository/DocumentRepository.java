package com.eobrazovanje.ssluzba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eobrazovanje.ssluzba.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
	
	
	List<Document> findDocumentByStudentId(Long id);
	
	List<Document> findDocumentByLecturerId(Long id);

}
