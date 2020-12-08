package com.eobrazovanje.ssluzba.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.converter.StudentToDTO;
import com.eobrazovanje.ssluzba.dto.converter.SubjectToDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToSubject;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.entityManager.UtilManager;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;
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
	
	@Autowired
	StudentToDTO studentToDTO;
	
	@Autowired
	StudentHasSubjectRepository studentHasSubjectRepository;
	
	@Autowired
	UtilManager utilManager;
	

	@GetMapping("/get-all")
	public ResponseEntity<List<SubjectDTO>> getAllSubjects(){
		return new ResponseEntity<>(subjectToDTO.convert(subjectRepository.findAll()), HttpStatus.OK);
	}
	

	
	
	@GetMapping(value="/get-subjects-for-lecturer")
	public ResponseEntity<List<SubjectDTO>> getAllForLecturer(@RequestParam("lecturerId") Long id){
		List<Subject> subjects = subjectRepository.findAllByLecturerId(id);
		
		return new ResponseEntity<List<SubjectDTO>>(subjectToDTO.convert(subjects), HttpStatus.OK);
	}
	
	@GetMapping(value="/test-for-student")
	public ResponseEntity<List<SubjectDTO>> getAllSubjectsForStudent(){
		return new ResponseEntity<List<SubjectDTO>>(subjectToDTO.convert(utilManager.queryForSubjectsForSpecificStudent()),HttpStatus.OK);
	}
	
	@GetMapping(value="/get-students-prijavio")
	public ResponseEntity<List<StudentDTO>> getAllSutdentsPrijavio(@RequestParam("subjectId") Long subjectId){
		List<Student> students = studentHasSubjectRepository.findStudentsBySubjectId(subjectId);
		
		return new ResponseEntity<List<StudentDTO>>(studentToDTO.convert(students), HttpStatus.OK);
		
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
	
	@PutMapping(value="/update/{id}", consumes="application/json")
	public ResponseEntity<SubjectDTO> updateSubject(@RequestBody SubjectDTO subjectDTO, @PathVariable("id") Long id){
		Subject subject = subjectRepository.getOne(id);
		if(subject == null) {
			return new ResponseEntity<SubjectDTO>(HttpStatus.NOT_FOUND);
		}
		Subject updatedSubject = dtoToSubject.convert(subjectDTO);
		subjectService.edit(subjectToDTO.convert(updatedSubject), id);		
		return new ResponseEntity<SubjectDTO>(subjectToDTO.convert(updatedSubject), HttpStatus.OK);
	}
	
	@PutMapping(value="/update-place-date")
	public ResponseEntity<?> updatePlaceDate(@RequestBody SubjectDTO subjectDTO, @RequestParam("hour") String hour, @RequestParam("minute") String minute){
		String t = hour + ":" + minute + ":00";
		Time sqlTime = Time.valueOf(t);
		Subject subject = subjectRepository.getOne(subjectDTO.getId());
		subject.setPlaceOfExam(subjectDTO.getPlaceOfExam());
		subject.setExamDate(subjectDTO.getExamDate());
		subject.setExamTime(sqlTime);
		subjectRepository.save(subject);
		
		
		return new ResponseEntity<>("all good!", HttpStatus.OK);
	}
	
	
	
	@PostMapping(value="/admin/add-lecturer")
	public ResponseEntity<?> addLecturerToSubject(@RequestParam Long subjectId, @RequestParam String id){
		Lecturer lecturer = lecturerService.getOne(id);
		Subject subject = subjectService.getOne(subjectId);
		subject.getLecturer().add(lecturer);
		subjectService.save(subject);
		return new ResponseEntity<>("all good!", HttpStatus.OK);
	}
	
	
	
	

	
	
	//vrati sve studente koji pohadjaju predmet
	
	
		
	

}
