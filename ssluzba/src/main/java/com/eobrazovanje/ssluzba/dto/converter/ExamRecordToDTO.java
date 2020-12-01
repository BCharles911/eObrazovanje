package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.ExamRecordDTO;
import com.eobrazovanje.ssluzba.entities.ExamRecord;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;



@Component
public class ExamRecordToDTO  implements Converter<ExamRecord, ExamRecordDTO>  {
	
	@Autowired
	StudentHasSubjectToDTO stHasSubToDTO;
	
	@Autowired
	LecturerToDTO lecturerToDTO;
	
	@Autowired
	StudentHasSubjectRepository sthsRepository;
	
	

	@Override
	public ExamRecordDTO convert(ExamRecord source) {
		// TODO Auto-generated method stub
		if(source == null) {
			return null;
			
		}
		
		ExamRecordDTO exRecordDTO = new ExamRecordDTO();
		
		exRecordDTO.setExamPeriod(source.getExamPeriod());
		//exRecordDTO.setStudentHasSubject(stHasSubToDTO.convert(source.getStudentHasSubject()));
		exRecordDTO.setStudentId(source.getStudent().getId());
		exRecordDTO.setSubjectId(source.getSubject().getId());
		exRecordDTO.setSubjectShortName(source.getSubject().getShortName());
		exRecordDTO.setSubjectName(source.getSubject().getSubjectName());
		exRecordDTO.setPassed(source.isPassed());
		
		exRecordDTO.setLecturerName(source.getLecturer().getFirstName() + " " + source.getLecturer().getLastName());
		//exRecordDTO.setLecturers(lecturerToDTO.convert(lecturerToDTO.convertSetToList(source.getSubject().getLecturer())));
		
		
		//exRecordDTO.setLecturerName(source.getSubject().getLecturer());
		//exRecordDTO.setStudentId(source.getStudent().getId());
		//exRecordDTO.setSubjectId(source.getSubject().getId());
		exRecordDTO.setNote(source.getNote());
		exRecordDTO.setExamDate(source.getExamDate());
		exRecordDTO.setOcena(source.getOcena());
		
		return exRecordDTO;
	}
	
	
	
	public List<ExamRecord> convertSetToList(Set<ExamRecord> set){
        // create an empty list 
        List<ExamRecord> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (ExamRecord a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	
	
	
	
	public List<ExamRecordDTO> convert(List<ExamRecord> source){
		List<ExamRecordDTO> lecturers = new ArrayList<ExamRecordDTO>();
		for(ExamRecord ex : source) {
			lecturers.add(convert(ex));
		}
		return lecturers;
	}
	
	

}
