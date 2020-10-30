package com.eobrazovanje.ssluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.dto.converter.StudentToDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToStudent;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;
import com.eobrazovanje.ssluzba.interfaces.CustomMapper;
import com.eobrazovanje.ssluzba.repository.StudentRepository;
import com.eobrazovanje.ssluzba.services.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {

	
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentToDTO studentToDTO;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	DTOToStudent toStudent;

	
	@GetMapping("/get-all")
	public ResponseEntity<List<StudentDTO>> getAllStudents(){
		return new ResponseEntity<>(studentToDTO.convert(studentRepository.findAll()), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/get-student-status")
	public ResponseEntity<STUDENT_STATUS> getLoggedStudentStatus(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loggedStudentUsername = authentication.getName();
		Student loggedStudent = studentRepository.getByUsername(loggedStudentUsername);
		
		return new ResponseEntity<STUDENT_STATUS>(loggedStudent.getStudentStatus(), HttpStatus.OK);
		
	}
	
	
	@PutMapping(value="/update/{id}", consumes="application/json")
	public ResponseEntity<StudentDTO> updateAccount(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id){
		Student student = studentRepository.getOne(id);
		if(student == null){
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}
		
		Student updatedStudent = toStudent.convert(studentDTO);
		studentService.edit(studentToDTO.convert(updatedStudent), id);
		return new ResponseEntity<StudentDTO>(studentToDTO.convert(updatedStudent),HttpStatus.OK);

	}
	
	
	@PutMapping(value="/update/custom/{id}", consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudentCustom(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id){
		Student updatedStudent = studentRepository.findStudentById(studentDTO.getId());
		//mapper.updateStudentFromDTO(studentDTO, updatedStudent);
		studentRepository.save(updatedStudent);
		return new ResponseEntity<StudentDTO>(studentToDTO.convert(updatedStudent),HttpStatus.OK);

	}
}
