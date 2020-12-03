package com.eobrazovanje.ssluzba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.dto.converter.LecturerToDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToLecturer;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.Subject;
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
	
	@Autowired
	DTOToLecturer dtoToLecturer;
	
	
	
	@GetMapping("/get-all")
	public ResponseEntity<List<LecturerDTO>> getAllLecturers(){
		return new ResponseEntity<List<LecturerDTO>>(lecturerToDTO.convert(lecturerRepository.findAll()), HttpStatus.OK);
		
	}
	
	@GetMapping("/get-not-enrolled/{id}")
	public ResponseEntity<List<LecturerDTO>> getNotEnrolled(@PathVariable("id") Long id){
		
		return null;
		//uradi proveru koji profesor ne predaje na tom predmetu
		
	}
	
	
	
	@DeleteMapping(value="/delete-from-subject")
	public void delete(@RequestParam("lecturerId") Long lecturerId, @RequestParam("subjectId") Long subjectId) {
		
		Subject subject = subjectRepository.getOne(subjectId);
		Lecturer lecturer = lecturerRepository.getOne(lecturerId);
		subject.getLecturer().remove(lecturer);
		subjectRepository.save(subject);
		
	}
	
	//return all not in subject
	@GetMapping(value="/get-not-in-subject")
	public ResponseEntity<List<LecturerDTO>> returnAllNotInSubject(@RequestParam("subjectId")Long id){
		List<Lecturer> lecturers = lecturerRepository.findAll();
		Subject subject = subjectRepository.getOne(id);
		List<Lecturer> toReturnLecturers = new ArrayList<Lecturer>();
		for(Lecturer lecturer : lecturers) {
			if(!lecturer.getSubjects().contains(subject)) {
				toReturnLecturers.add(lecturer);
			}
		}
		
		return new ResponseEntity<List<LecturerDTO>>(lecturerToDTO.convert(toReturnLecturers), HttpStatus.OK);
	}
	
	@PostMapping(value="add-to-subject", consumes="application/json")
	public ResponseEntity<?> addToSubject(@RequestBody List<LecturerDTO> lecturersToAdd, @RequestParam("subjectId") Long id){
		Subject subject = subjectRepository.getOne(id);
		
		List<Lecturer> lecturers = new ArrayList<Lecturer>();
		for(LecturerDTO l : lecturersToAdd) {
			lecturers.add(dtoToLecturer.convert(l));
		}
		for(Lecturer l : lecturers) {
			subject.getLecturer().add(l);
		}
		subjectRepository.save(subject);
		return new ResponseEntity<Subject>(subject, HttpStatus.OK);
	}


}
