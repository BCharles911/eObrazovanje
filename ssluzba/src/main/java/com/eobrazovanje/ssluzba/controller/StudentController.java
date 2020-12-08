
package com.eobrazovanje.ssluzba.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.eobrazovanje.ssluzba.dto.StudentHasSubjectDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.converter.FinancialCardToDTO;
import com.eobrazovanje.ssluzba.dto.converter.StudentHasSubjectToDTO;
import com.eobrazovanje.ssluzba.dto.converter.StudentToDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToStudent;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToSubject;
import com.eobrazovanje.ssluzba.entities.ExamPeriod;
import com.eobrazovanje.ssluzba.entities.FinancialCard;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.entities.Transaction;
import com.eobrazovanje.ssluzba.entities.compositeKeys.StudentSubjectKey;
import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;
import com.eobrazovanje.ssluzba.interfaces.CustomMapper;
import com.eobrazovanje.ssluzba.repository.ExamPeriodRepository;
import com.eobrazovanje.ssluzba.repository.FinancialCardRepository;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;
import com.eobrazovanje.ssluzba.repository.StudentRepository;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;
import com.eobrazovanje.ssluzba.repository.TransactionRepository;
import com.eobrazovanje.ssluzba.services.StudentService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	StudentHasSubjectToDTO sthsToDTO;
	
	@Autowired
	FinancialCardToDTO financialToDTO;
	
	@Autowired
	StudentHasSubjectRepository studentHasSubjectRepository;
	
	@Autowired
	FinancialCardRepository financialRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	ExamPeriodRepository examPeriodRepository;
	
	@Autowired
	DTOToStudent dtoToStudent;

	
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
		public ResponseEntity<FinancialCardDTO> getFinancialCard(@RequestParam("studentId") String id){
			
			FinancialCard financialCard = financialRepository.findFinancialCardByStudentId(id);
		
		
			return new ResponseEntity<FinancialCardDTO>(financialToDTO.convert(financialCard), HttpStatus.OK);
		}
	
	
	@GetMapping(value="get-for-active")
	public ResponseEntity<List<StudentDTO>> getActiveStudents(@RequestParam("subjectId") Long id){
		
		List<Student> students = studentHasSubjectRepository.findStudentsBySubjectId(id);
	
	
		return new ResponseEntity<List<StudentDTO>>(studentToDTO.convert(students), HttpStatus.OK);
	
	

	}
	
	@GetMapping(value="get-all-for-subject")
	public ResponseEntity<List<StudentHasSubjectDTO>> getAllForSubject(@RequestParam("subjectId") Long id){
		List<StudentHasSubject> students = studentHasSubjectRepository.findAllBySubjectId(id);
		
		return new ResponseEntity<List<StudentHasSubjectDTO>>(sthsToDTO.convert(students), HttpStatus.OK);
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
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable("id") String id){
		Student student = studentRepository.getOne(id);
		if(student == null){
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}
		System.out.println(studentDTO.getCurrentYear());
		Student updatedStudent = toStudent.convert(studentDTO);
		studentService.edit(studentToDTO.convert(updatedStudent), id);
		return new ResponseEntity<StudentDTO>(studentToDTO.convert(updatedStudent),HttpStatus.OK);

	}
	
	
	@DeleteMapping(value="delete-from-subject")
	public void deleteFromSubject(@RequestParam("studentId") String studentId, @RequestParam("subjectId") Long subjectId){
		StudentHasSubject sths = studentHasSubjectRepository.findStudentHasSubjectByStudentIdAndSubjectId(studentId, subjectId);
		studentHasSubjectRepository.delete(sths);
	
	}
	
	@PutMapping(value="/update-partial/{id}", consumes="application/json")
	public ResponseEntity<StudentDTO> updatePartial(@RequestBody StudentDTO studentDTO, @PathVariable("id") String id){
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
		String id = "2";
		Long id2 = (long) 8;
		StudentHasSubject shs = studentHasSubjectRepository.findStudentHasSubjectByStudentIdAndSubjectId(id,id2);
		shs.setPrijavio(true);
		studentHasSubjectRepository.save(shs);
	}
	
	
	@PostMapping(value= "/exam-check", consumes="application/json", produces="application/json")	
	public ResponseEntity<?> prijaviIspit(
			@RequestBody 	
			List<SubjectDTO> checkedSubjects, 
			@RequestParam("totalPrice") 
			Double totalPrice,
			@RequestParam("examPeriodName")
			String examPeriodName
			) {
		//List<Subject> convertedSubjects = dtoToSubject.convert(checkedSubjects);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loggedStudentUsername = authentication.getName();
		Student loggedStudent = studentRepository.getByUsername(loggedStudentUsername);
		
		ExamPeriod examPeriod = examPeriodRepository.findByExamPeriodName(examPeriodName);
		
		for(SubjectDTO subject : checkedSubjects) {
			
			StudentHasSubject shs = studentHasSubjectRepository.findStudentHasSubjectByStudentIdAndSubjectId(loggedStudent.getId(), subject.getId());
			shs.setPrijavio(true);
			shs.setExamPeriodName(examPeriod.getExamPeriodName());
			studentHasSubjectRepository.save(shs);
			
		}
		FinancialCard financialCard = financialRepository.findFinancialCardByStudentId(loggedStudent.getId());
		financialCard.setBalance(financialCard.getBalance() - totalPrice);
		financialRepository.save(financialCard);
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Transaction transaction = new Transaction();
		transaction.setAmount(0 - totalPrice);
		transaction.setFinancialCard(financialCard);
		String subjects = " ";
		for(SubjectDTO subject : checkedSubjects) {
			subjects  = subjects + "/ " + subject.getSubjectName();
		}
		transaction.setPaymentPurpose("Student prijavio ispit: " + subjects );

		transaction.setTransactionDate(date);
		transactionRepository.save(transaction);
	
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
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Transaction transaction = new Transaction();
		transaction.setAmount(returnAmount);
		transaction.setFinancialCard(financialCard);
		String subjects = " ";
		for(SubjectDTO subject : checkedSubjects) {
			subjects  = subjects + "/ " + subject.getSubjectName();
		}
		transaction.setPaymentPurpose("Student odjavio ispit-e: " + subjects );

		transaction.setTransactionDate(date);
		transactionRepository.save(transaction);
	

		
		return new ResponseEntity<String>("ispiti odjavljeni", HttpStatus.OK);
	}
	
	@GetMapping(value="/get-not-in-subject")
	public ResponseEntity<List<StudentDTO>> returnAllNotInSubject(@RequestParam("subjectId") Long id){
		List<Student> students = studentRepository.findAll();
		List<StudentHasSubject> sths = studentHasSubjectRepository.findAllBySubjectId(id);
		List<Student> studentsToReturn = new ArrayList<Student>();
		if(sths == null || sths.isEmpty()) {
			studentsToReturn = students;
		}else {
			
		
		for(Student s : students) {
			for(StudentHasSubject st : sths) {
				if(!st.getStudent().equals(s)) {
					studentsToReturn.add(s);
				}
			}
		}
		}
		
		return new ResponseEntity<List<StudentDTO>>(studentToDTO.convert(studentsToReturn), HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/delete")
	public void deleteStudent(@RequestParam("studentId") String studentId) {
		Student student = studentRepository.getOne(studentId);
		/*if(student == null) {
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}*/
		studentService.delete(studentId);
		//return new ResponseEntity<String>("Student obrisan", HttpStatus.OK);
	}
	
	
	@PostMapping(value="/add-to-subject", consumes="application/json")
	public ResponseEntity<?> addToSubject(@RequestBody List<StudentDTO> studentsToAdd, @RequestParam("subjectId") Long subjectId){
		Subject subject = subjectRepository.getOne(subjectId);
		for(StudentDTO s : studentsToAdd) {
			StudentHasSubject sths = new StudentHasSubject();
			sths.setStudent(dtoToStudent.convert(s));
			sths.setSubject(subject);
			StudentSubjectKey ssId = new StudentSubjectKey();
			ssId.setStudentId(s.getId());
			ssId.setSubjectId(subject.getId());
			sths.setId(ssId);
			studentHasSubjectRepository.save(sths);
		}
		
		return new ResponseEntity<Subject>(subject,HttpStatus.OK);
	}
	
	
	
	
	@PutMapping(value="/update/custom/{id}", consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudentCustom(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id){
		Student updatedStudent = studentRepository.findStudentById(studentDTO.getId());
		//mapper.updateStudentFromDTO(studentDTO, updatedStudent);
		studentRepository.save(updatedStudent);
		return new ResponseEntity<StudentDTO>(studentToDTO.convert(updatedStudent),HttpStatus.OK);

	}
}
