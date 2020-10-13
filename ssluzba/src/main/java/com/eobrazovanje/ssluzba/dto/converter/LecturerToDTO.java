package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.entities.Lecturer;

@Component
public class LecturerToDTO implements Converter<Lecturer, LecturerDTO> {

	@Autowired
	ExamToDTO examToDTO;
	
	@Override
	public LecturerDTO convert(Lecturer source) {
		if(source == null) {
			return null;
		}
		
		LecturerDTO lecturerDTO = new LecturerDTO();
		
		lecturerDTO.setId(source.getId());
		lecturerDTO.setFirstName(source.getFirstName());
		lecturerDTO.setLastName(source.getLastName());
		//lecturerDTO.setDeleted(source.get);
		lecturerDTO.setUsername(source.getUsername());
		lecturerDTO.setGender(source.getGender());
		lecturerDTO.setDateOfBirth(source.getDateOfBirth());
		lecturerDTO.setPlaceOfBirth(source.getPlaceOfBirth());
		lecturerDTO.setStateOfBirth(source.getStateOfBirth());
		lecturerDTO.setResidence_address(source.getResidence_address());
		lecturerDTO.setTownship(source.getTownship());
		lecturerDTO.setCity(source.getCity());
		lecturerDTO.setPhoneNumber(source.getPhoneNumber());
		lecturerDTO.setMobilePhoneNumber(source.getMobilePhoneNumber());
		lecturerDTO.setEmailAddress(source.getEmailAddress());
		lecturerDTO.setCitizenship(source.getCitizenship());
		lecturerDTO.setEthnicity(source.getEthnicity());
		lecturerDTO.setRoles(source.getRoles());
		//lecturerDTO.setExams(examToDTO.convert(examToDTO.convertSetToList(source.getExam())));
		
		
		return lecturerDTO;
		
	}

	public List<Lecturer> convertSetToList(Set<Lecturer> set){
        // create an empty list 
        List<Lecturer> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (Lecturer a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	
	
	
	
	public List<LecturerDTO> convert(List<Lecturer> source){
		List<LecturerDTO> lecturers = new ArrayList<LecturerDTO>();
		for(Lecturer acc : source) {
			lecturers.add(convert(acc));
		}
		return lecturers;
	}
	
}
