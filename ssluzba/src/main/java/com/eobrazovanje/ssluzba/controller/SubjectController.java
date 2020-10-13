package com.eobrazovanje.ssluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.converter.SubjectToDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToSubject;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;
import com.eobrazovanje.ssluzba.services.LecturerService;
import com.eobrazovanje.ssluzba.services.SubjectService;

@RestController
@RequestMapping("api/subject")
public class SubjectController {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	SubjectToDTO subjectToDTO;
	
	@Autowired
	LecturerRepository lecturerRepository;
	
	@Autowired
	LecturerService lecturerService;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	DTOToSubject dtoToSubject;
	

	@GetMapping("/get-all")
	public ResponseEntity<List<SubjectDTO>> getAllSubjects(){
		return new ResponseEntity<>(subjectToDTO.convert(subjectRepository.findAll()), HttpStatus.OK);
	}
	
	
	@PostMapping(value="/admin/create-subject", consumes= "application/json")
	public ResponseEntity<?> createSubject(@RequestBody SubjectDTO subjectDTO, Errors errors){
		System.out.println(subjectDTO.getLecturerDTO().get(0).getId());
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		
		Subject newSubject = subjectRepository.save(dtoToSubject.convert(subjectDTO));
		return new ResponseEntity<>(subjectToDTO.convert(newSubject), HttpStatus.OK);
		
	}
	
	
	@PostMapping(value="/admin/add-lecturer")
	public ResponseEntity<?> addLecturerToSubject(@RequestParam Long subjectId, @RequestParam Long id){
		Lecturer lecturer = lecturerService.getOne(id);
		Subject subject = subjectService.getOne(subjectId);
		subject.getLecturer().add(lecturer);
		subjectService.save(subject);
		return new ResponseEntity<>("all good!", HttpStatus.OK);
	}
	
	
		
	

}