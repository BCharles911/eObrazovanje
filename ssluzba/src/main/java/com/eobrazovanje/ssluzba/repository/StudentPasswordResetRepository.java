package com.eobrazovanje.ssluzba.repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.StudentPasswordResetToken;

public interface StudentPasswordResetRepository extends JpaRepository<StudentPasswordResetToken, Long> {

	
	StudentPasswordResetToken findByToken(String token);
	
	StudentPasswordResetToken findByStudent(Student student);
	
	Stream<StudentPasswordResetToken> findAllByExpiryDateLessThan(Date now);
	
	void deleteByExpiryDateLessThan(Date now);
	
	 @Modifying
	 @Query("delete StudentPasswordResetToken t where t.expiryDate <= ?1")
	 void deleteAllExpiredSince(Date now);
}
