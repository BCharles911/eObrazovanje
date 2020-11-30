package com.eobrazovanje.ssluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.ExamObject;
import com.eobrazovanje.ssluzba.dto.ExamRecordDTO;
import com.eobrazovanje.ssluzba.dto.StudentHasSubjectDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.converter.ExamRecordToDTO;
import com.eobrazovanje.ssluzba.dto.converter.StudentHasSubjectToDTO;
import com.eobrazovanje.ssluzba.dto.converter.SubjectToDTO;
import com.eobrazovanje.ssluzba.entities.ExamRecord;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.repository.ExamRecordRepository;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;
import com.eobrazovanje.ssluzba.repository.StudentRepository;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;
import com.eobrazovanje.ssluzba.services.ExamRecordService;

@RestController
@RequestMapping("api/exam-record")
public class ExamRecordController {

	@Autowired
	ExamRecordRepository examRecordRepository;
	
	@Autowired
	ExamRecordToDTO examRecordToDTO;
	
	@Autowired
	ExamRecordService examRecordService;
	
	@Autowired
	private StudentHasSubjectRepository studentHasSubjectRepository;
		
	@Autowired
	private StudentHasSubjectToDTO subToDTO;
	
	@Autowired
	private SubjectToDTO subjectToDTO;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/get-all")
	public ResponseEntity<List<ExamRecordDTO>> getAllExamRecord(){
		return new ResponseEntity<>(examRecordToDTO.convert(examRecordRepository.findAll()), HttpStatus.OK);
	}
	
	@GetMapping("/get-passed-subjects")
	public ResponseEntity<List<StudentHasSubjectDTO>> getSubjectsPassed(@RequestParam("id") Long id) {
		
		List<StudentHasSubject> studentPassedSubjects = studentHasSubjectRepository.findPassedSubject(id);
		
		return new ResponseEntity<List<StudentHasSubjectDTO>>(subToDTO.convert(studentPassedSubjects), HttpStatus.OK);
	}
	
	@GetMapping("/get-passed-subjects-history")
	public ResponseEntity<List<ExamRecordDTO>> getSubjectsPassedHistory(@RequestParam("id") Long id) {
		
		List<ExamRecord> studentPassedSubjects = studentHasSubjectRepository.findPassedSubjectHistory(id);
		
		return new ResponseEntity<List<ExamRecordDTO>>(examRecordToDTO.convert(studentPassedSubjects), HttpStatus.OK);
	}
	
	@PostMapping("/send-students")
	public ResponseEntity<?> sendStudents(@RequestBody List<ExamObject> examObjectList, @RequestParam("subjectId") Long subjectId){
		
		Subject subject = subjectRepository.getOne(subjectId);
		for(ExamObject examObject : examObjectList) {
			Student student = studentRepository.getOne(examObject.getStudent().getId());
			ExamRecord examRecord = new ExamRecord();
			examRecord.setStudent(student);
			examRecord.setOcena(examObject.getGrade());
			examRecord.setSubject(subject);
			StudentHasSubject sths = studentHasSubjectRepository.findStudentHasSubjectByStudentIdAndSubjectId(examObject.getStudent().getId(), subjectId);
			sths.setBrPokusaja(sths.getBrPokusaja() + 1);
			sths.setOcena(examObject.getGrade());
			sths.setPrijavio(false);
			sths.setPassed(examObject.isPassed());
			studentHasSubjectRepository.save(sths);
			examRecordRepository.save(examRecord);
			
		}
		
		return null;
	}
}
