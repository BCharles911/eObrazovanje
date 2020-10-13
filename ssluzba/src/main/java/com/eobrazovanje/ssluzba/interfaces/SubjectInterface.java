package com.eobrazovanje.ssluzba.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.entities.Subject;



public interface SubjectInterface {

	Subject getOne(Long subjectId);

	Subject save(Subject subject);
	Subject edit(SubjectDTO subject,Long id);
	void delete(Long id);
	Page<Subject> getAllPaged(Pageable pageRequest);
	List<Subject> getAll();
}
