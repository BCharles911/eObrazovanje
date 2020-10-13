package com.eobrazovanje.ssluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.dto.StudentHasSubjectDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.converter.LecturerToDTO;
import com.eobrazovanje.ssluzba.dto.converter.StudentHasSubjectToDTO;
import com.eobrazovanje.ssluzba.dto.converter.SubjectToDTO;
import com.eobrazovanje.ssluzba.entities.Course;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.repository.CourseRepository;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;

import io.swagger.annotations.ApiModel;

@RestController
@RequestMapping("api/test")
@ApiModel(description = "test test test")
public class TestController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	LecturerRepository lecturerRepository;
	
	@Autowired
	StudentHasSubjectRepository studentHasSubjectRepository;
	
	
	@Autowired
	SubjectRepository subjectRepository;
	
	
	@Autowired
	StudentHasSubjectToDTO studentHasSubjectToDTO;
	
	@Autowired
	SubjectToDTO subjectToDTO;
	
	@Autowired
	LecturerToDTO lecturerToDTO;
	
	
	
	@GetMapping("/test")
	public String testRequest(){
		
		return "test successful";
		
	}
	
	
	@GetMapping("/getCourses")
	public List<Course> getCourses(){
		return courseRepository.findAll();
	}
	
	@GetMapping("/getLecturers")
	public ResponseEntity<List<LecturerDTO>> getUsers() {
		
		
		List<Lecturer> allUsers = lecturerRepository.findAll();
		if(allUsers == null) {
			return new ResponseEntity<List<LecturerDTO>>(HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<List<LecturerDTO>>(lecturerToDTO.convert(allUsers), HttpStatus.OK);
	}
	
	
	@GetMapping("/getStudentSubjects")
	public ResponseEntity<List<StudentHasSubjectDTO>> getStudentSubjects() {
		
		
		List<StudentHasSubject> allStudhas = studentHasSubjectRepository.findAll();
		if(allStudhas == null) {
			return new ResponseEntity<List<StudentHasSubjectDTO>>(HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<List<StudentHasSubjectDTO>>(studentHasSubjectToDTO.convert(allStudhas), HttpStatus.OK);
	}
	
	
	@GetMapping("/getSubjects")
	public ResponseEntity<List<SubjectDTO>> getSubjects() {
		
		
		List<Subject> allStudhas = subjectRepository.findAll();
		if(allStudhas == null) {
			return new ResponseEntity<List<SubjectDTO>>(HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<List<SubjectDTO>>(subjectToDTO.convert(allStudhas), HttpStatus.OK);
	}
	
}
