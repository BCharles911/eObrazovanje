package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.eobrazovanje.ssluzba.dto.ExamDTO;
import com.eobrazovanje.ssluzba.entities.Exam;

@Component
public class ExamToDTO implements Converter<Exam, ExamDTO> {

	@Autowired
	StudentHasSubjectToDTO studHasToDTO;
	
	@Override
	public ExamDTO convert(Exam source) {
		// TODO Auto-generated method stub
		if(source == null) {
			return null;
		}
		
		ExamDTO examDTO = new ExamDTO();
		
		examDTO.setId(source.getId());
		examDTO.setDeleted(source.isDeleted());
		examDTO.setHasPassed(source.isHasPassed());
		examDTO.setPointsNumber(source.getPointsNumber());
		examDTO.setExamDate(source.getExamDate());
		examDTO.setExamPlace(source.getExamPlace());
		examDTO.setExamName(source.getExamName());
		examDTO.setStudentId(source.getStudent_has_subject().getStudent().getId());
		examDTO.setSubjectId(source.getStudent_has_subject().getSubject().getId());
		
		return examDTO;
	}

	
	public List<Exam> convertSetToList(Set<Exam> set){
        // create an empty list 
        List<Exam> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (Exam a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	
	
	
	
	public List<ExamDTO> convert(List<Exam> source){
		List<ExamDTO> exams = new ArrayList<ExamDTO>();
		for(Exam acc : source) {
			exams.add(convert(acc));
		}
		return exams;
	}
	
}
