package com.eobrazovanje.ssluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.ExamRecordDTO;
import com.eobrazovanje.ssluzba.dto.StudentHasSubjectDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.converter.ExamRecordToDTO;
import com.eobrazovanje.ssluzba.dto.converter.StudentHasSubjectToDTO;
import com.eobrazovanje.ssluzba.dto.converter.SubjectToDTO;
import com.eobrazovanje.ssluzba.entities.ExamRecord;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.repository.ExamRecordRepository;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;
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
	
	
	@GetMapping("/get-all")
	public ResponseEntity<List<ExamRecordDTO>> getAllExamRecord(){
		return new ResponseEntity<>(examRecordToDTO.convert(examRecordRepository.findAll()), HttpStatus.OK);
	}
	
	@GetMapping("/get-passed-subjects")
	public ResponseEntity<List<SubjectDTO>> getSubjectsPassed(@RequestParam("id") Long id) {
		
		List<Subject> studentPassedSubjects = studentHasSubjectRepository.findPassedSubject(id);
		
		return new ResponseEntity<List<SubjectDTO>>(subjectToDTO.convert(studentPassedSubjects), HttpStatus.OK);
	}
	
	@GetMapping("/get-passed-subjects-history")
	public ResponseEntity<List<ExamRecordDTO>> getSubjectsPassedHistory(@RequestParam("id") Long id) {
		
		List<ExamRecord> studentPassedSubjects = studentHasSubjectRepository.findPassedSubjectHistory(id);
		
		return new ResponseEntity<List<ExamRecordDTO>>(examRecordToDTO.convert(studentPassedSubjects), HttpStatus.OK);
	}
}
