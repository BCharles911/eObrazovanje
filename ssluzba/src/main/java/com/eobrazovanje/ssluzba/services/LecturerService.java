package com.eobrazovanje.ssluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToLecturer;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.interfaces.LecturerInterface;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;

@Service
public class LecturerService implements LecturerInterface {
	
	@Autowired
	LecturerRepository lecturerRepository;
	
	@Autowired
	DTOToLecturer toLecturer;

	@Override
	public Lecturer getOne(Long lecturerId) {
		return lecturerRepository.getOne(lecturerId);
	}

	@Override
	public Lecturer getByFirstName(String firstname) {
		return lecturerRepository.findByFirstName(firstname);
	}

	@Override
	public Lecturer save(Lecturer lecturer) {
		return lecturerRepository.save(lecturer);
	}

	@Override
	public Lecturer edit(LecturerDTO lecturer, Long id) {
		
		lecturer.setId(id);
		Lecturer editedLecturer = toLecturer.convert(lecturer);
		lecturerRepository.save(editedLecturer);
		return editedLecturer;
	}

	@Override
	public void delete(Long id) {
	
		Lecturer deletedLecturer = getOne(id);
		if(deletedLecturer != null) {
			lecturerRepository.deleteById(id);
		}
		
	}

	@Override
	public Page<Lecturer> getAllPaged(Pageable pageRequest) {
		return lecturerRepository.findAll(pageRequest);
	}

	@Override
	public List<Lecturer> getAll() {
		// TODO Auto-generated method stub
		return lecturerRepository.findAll();
	}

}
