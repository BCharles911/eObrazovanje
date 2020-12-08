package com.eobrazovanje.ssluzba.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.entities.Lecturer;



public interface LecturerInterface {
	Lecturer getOne(String lecturerId);
	Lecturer getByFirstName(String firstname);
	Lecturer save(Lecturer lecturer);
	Lecturer edit(LecturerDTO lecturer,String id);
	void delete(String id);
	Page<Lecturer> getAllPaged(Pageable pageRequest);
	List<Lecturer> getAll();
}
