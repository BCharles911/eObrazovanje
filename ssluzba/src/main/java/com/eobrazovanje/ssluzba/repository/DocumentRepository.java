package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eobrazovanje.ssluzba.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {

}
