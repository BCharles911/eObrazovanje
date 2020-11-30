package com.eobrazovanje.ssluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.dto.converter.LecturerToDTO;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;

@RestController
@RequestMapping("api/lecturer")
public class LecturerController {
	

	@Autowired
	LecturerRepository lecturerRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	LecturerToDTO lecturerToDTO;
	
	
	
	@GetMapping("/get-all")
	public ResponseEntity<List<LecturerDTO>> getAllLecturers(){
		return new ResponseEntity<List<LecturerDTO>>(lecturerToDTO.convert(lecturerRepository.findAll()), HttpStatus.OK);
		
	}
	
	@GetMapping("/get-not-enrolled/{id}")
	public ResponseEntity<List<LecturerDTO>> getNotEnrolled(@PathVariable("id") Long id){
		
		return null;
		//uradi proveru koji profesor ne predaje na tom predmetu
		
	}
	
	


}
