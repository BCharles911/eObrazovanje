package com.eobrazovanje.ssluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.FinancialCardDTO;
import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.converter.FinancialCardToDTO;
import com.eobrazovanje.ssluzba.dto.converter.StudentToDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToStudent;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToSubject;
import com.eobrazovanje.ssluzba.entities.FinancialCard;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;
import com.eobrazovanje.ssluzba.interfaces.CustomMapper;
import com.eobrazovanje.ssluzba.repository.FinancialCardRepository;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;
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
	DTOToSubject dtoToSubject;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	DTOToStudent toStudent;
	
	@Autowired
	FinancialCardToDTO financialToDTO;
	
	@Autowired
	StudentHasSubjectRepository studentHasSubjectRepository;
	
	@Autowired
	FinancialCardRepository financialRepository;

	
	//brat moooj
	
	@GetMapping("/get-all")
	public ResponseEntity<List<StudentDTO>> getAllStudents(){
		return new ResponseEntity<>(studentToDTO.convert(studentRepository.findAll()), HttpStatus.OK);
	}
	
	
	
	@GetMapping(value ="/get-student-status", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<StudentDTO> getLoggedStudentStatus(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loggedStudentUsername = authentication.getName();
		Student loggedStudent = studentRepository.getByUsername(loggedStudentUsername);
		
		return new ResponseEntity<StudentDTO>(studentToDTO.convert(loggedStudent), HttpStatus.OK);
		
	}
	
	
	@GetMapping(value="/get-financial-card")
		public ResponseEntity<FinancialCardDTO> getFinancialCard(@RequestParam("studentId") Long id){
			
			FinancialCard financialCard = financialRepository.findFinancialCardByStudentId(id);
		
		
			return new ResponseEntity<FinancialCardDTO>(financialToDTO.convert(financialCard), HttpStatus.OK);
		}
	
	
	

	
	
	@GetMapping(value ="/get-logged-student")
	public ResponseEntity<StudentDTO> getLoggedStudent(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loggedStudentUsername = authentication.getName();
		Student loggedStudent = studentRepository.getByUsername(loggedStudentUsername);
		System.out.println(loggedStudent.getUsername());
		return new ResponseEntity<StudentDTO>(studentToDTO.convert(loggedStudent), HttpStatus.OK);
		
	}
	
	
	
	
	@PutMapping(value="/update/{id}", consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id){
		Student student = studentRepository.getOne(id);
		if(student == null){
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}
		System.out.println(studentDTO.getCurrentYear());
		Student updatedStudent = toStudent.convert(studentDTO);
		studentService.edit(studentToDTO.convert(updatedStudent), id);
		return new ResponseEntity<StudentDTO>(studentToDTO.convert(updatedStudent),HttpStatus.OK);

	}
	
	
	@PutMapping(value="/update-partial/{id}", consumes="application/json")
	public ResponseEntity<StudentDTO> updatePartial(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id){
		Student student = studentRepository.getOne(id);
		if(student == null){
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}
		System.out.println(studentDTO.getCurrentYear());
		if(studentDTO.getUsername() != "") {
			student.setUsername(studentDTO.getUsername());
		}
		
		if(studentDTO.getPhoneNumber() != "") {
			student.setPhoneNumber(studentDTO.getPhoneNumber());

		}
		if(studentDTO.getMobilePhoneNumber() != "") {
			student.setMobilePhoneNumber(studentDTO.getMobilePhoneNumber());

		}
		
		if(studentDTO.getResidence_address() != "") {
			student.setResidence_address(studentDTO.getResidence_address());

		}
		studentRepository.save(student);
		return new ResponseEntity<StudentDTO>(studentToDTO.convert(student),HttpStatus.OK);

	}
	
	
	@PutMapping(value="/exam-check-test")
	public void testIspit() {
		Long id = (long) 2;
		Long id2 = (long) 8;
		StudentHasSubject shs = studentHasSubjectRepository.findStudentHasSubjectByStudentIdAndSubjectId(id,id2);
		shs.setPrijavio(true);
		studentHasSubjectRepository.save(shs);
	}
	
	
	@PostMapping(value= "/exam-check", consumes="application/json", produces="application/json")	
	public ResponseEntity<?> prijaviIspit(@RequestBody List<SubjectDTO> checkedSubjects, @RequestParam("totalPrice") Double totalPrice) {
		//List<Subject> convertedSubjects = dtoToSubject.convert(checkedSubjects);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loggedStudentUsername = authentication.getName();
		Student loggedStudent = studentRepository.getByUsername(loggedStudentUsername);
		
		for(SubjectDTO subject : checkedSubjects) {
			
			StudentHasSubject shs = studentHasSubjectRepository.findStudentHasSubjectByStudentIdAndSubjectId(loggedStudent.getId(), subject.getId());
			shs.setPrijavio(true);
			studentHasSubjectRepository.save(shs);
			
		}
		FinancialCard financialCard = financialRepository.findFinancialCardByStudentId(loggedStudent.getId());
		financialCard.setBalance(financialCard.getBalance() - totalPrice);
		financialRepository.save(financialCard);
	
		return new ResponseEntity<String>("ispiti prijavljeni", HttpStatus.OK);
		
		
	}
	
	
	@PostMapping(value="/exam-check-out", consumes="application/json")
	public ResponseEntity<?> odjaviIspit(@RequestBody List<SubjectDTO> checkedSubjects, @RequestParam("returnAmount") Double returnAmount){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loggedStudentUsername = authentication.getName();
		Student loggedStudent = studentRepository.getByUsername(loggedStudentUsername);
		
		for(SubjectDTO subject : checkedSubjects) {
			
			StudentHasSubject shs = studentHasSubjectRepository.findStudentHasSubjectByStudentIdAndSubjectId(loggedStudent.getId(), subject.getId());
			shs.setPrijavio(false);
			studentHasSubjectRepository.save(shs);
			
		}
		FinancialCard financialCard = financialRepository.findFinancialCardByStudentId(loggedStudent.getId());
		financialCard.setBalance(financialCard.getBalance() + returnAmount);
		financialRepository.save(financialCard);
	
		return new ResponseEntity<String>("ispiti prijavljeni", HttpStatus.OK);
	}
	
	
	
	
	@PutMapping(value="/update/custom/{id}", consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudentCustom(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id){
		Student updatedStudent = studentRepository.findStudentById(studentDTO.getId());
		//mapper.updateStudentFromDTO(studentDTO, updatedStudent);
		studentRepository.save(updatedStudent);
		return new ResponseEntity<StudentDTO>(studentToDTO.convert(updatedStudent),HttpStatus.OK);

	}
}
