package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.StudentHasSubjectDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;

@Component
public class StudentHasSubjectToDTO implements Converter<StudentHasSubject, StudentHasSubjectDTO> {

	@Autowired
	ExamToDTO examToDTO;
	
	@Override
	public StudentHasSubjectDTO convert(StudentHasSubject source) {
		
		if(source == null) {
			return null;
		}
		
		StudentHasSubjectDTO studentHasSubjectDTO = new StudentHasSubjectDTO();
		
		studentHasSubjectDTO.setStudentId(source.getStudent().getId());
		studentHasSubjectDTO.setSubjectId(source.getSubject().getId());
		studentHasSubjectDTO.setOcena(source.getOcena());
		studentHasSubjectDTO.setBrPokusaja(source.getBrPokusaja());
		studentHasSubjectDTO.setPassed(source.isPassed());
		studentHasSubjectDTO.setExams(examToDTO.convert(examToDTO.convertSetToList(source.getExam())));		
		return studentHasSubjectDTO;
		
	}
	
	
	public List<StudentHasSubject> convertSetToList(Set<StudentHasSubject> set){
        // create an empty list 
        List<StudentHasSubject> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (StudentHasSubject a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	
	public List<StudentHasSubjectDTO> convert(List<StudentHasSubject> source){
		List<StudentHasSubjectDTO> studentHasSubjects = new ArrayList<StudentHasSubjectDTO>();
		for(StudentHasSubject acc : source) {
			studentHasSubjects.add(convert(acc));
		}
		return studentHasSubjects;
	}
	
	
	
	

}