package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.entities.Subject;

@Component
public class SubjectToDTO implements Converter<Subject, SubjectDTO> {
	
	@Autowired
	CoursesToDTO coursesToDTO;
	
	@Autowired
	LecturerToDTO lecturerToDTO;
	
	@Autowired
	ColloqiumToDTO colloqiumToDTO;
	
	@Autowired
	StudentHasSubjectToDTO studentHasSubjectToDTO;
	
	public SubjectDTO convert(Subject source) {
		
		if(source == null) {
			return null;
		}
		
		SubjectDTO subjectDTO = new SubjectDTO();
		
		subjectDTO.setId(source.getId());
		subjectDTO.setSubjectName(source.getSubjectName());
		subjectDTO.setShortName(source.getShortName());
		subjectDTO.setEctsPoints(source.getEctsPoints());
		subjectDTO.setExamDate(source.getExamDate());
		subjectDTO.setPlaceOfExam(source.getPlaceOfExam());
		
		if(source.getLecturer() != null) {
			subjectDTO.setLecturerDTO(lecturerToDTO.convert(lecturerToDTO.convertSetToList(source.getLecturer())));

		}
//		if(source.getCourse() != null) {
//			subjectDTO.setCoursesDTO(coursesToDTO.convert(coursesToDTO.convertSetToList((source.getCourse()))));
//
//			}
		
		
		if(source.getStudentHasSubject() != null) {
			subjectDTO.setStudentHasSubDTO((studentHasSubjectToDTO.convert(studentHasSubjectToDTO.convertSetToList(source.getStudentHasSubject()))));

		}
		if(source.getColloqium() != null) {
			subjectDTO.setColloqiumsDTO(colloqiumToDTO.convert(colloqiumToDTO.convertSetToList(source.getColloqium())));
			
		}
		
		return subjectDTO;
		
		
	}
	
	public List<Subject> convertSetToList(Set<Subject> set){
        // create an empty list 
        List<Subject> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (Subject a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	
	public List<SubjectDTO> convert(List<Subject> source){
		List<SubjectDTO> accounts = new ArrayList<SubjectDTO>();
		for(Subject acc : source) {
			accounts.add(convert(acc));
		}
		return accounts;
	}

}
