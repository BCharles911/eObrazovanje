package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.ColloqiumDTO;
import com.eobrazovanje.ssluzba.entities.Colloqium;

@Component
public class ColloqiumToDTO implements Converter<Colloqium, ColloqiumDTO> {

	@Override
	public ColloqiumDTO convert(Colloqium source) {
		
		if(source == null) {
			return null;
		}
		
		ColloqiumDTO colloqiumDTO = new ColloqiumDTO();
		
		colloqiumDTO.setId(source.getId());
		colloqiumDTO.setPlace(source.getPlace());
		colloqiumDTO.setPointNumber(source.getPointNumber());
		colloqiumDTO.setStartDate(source.getStartDate());
		
		if(source.getSubject() != null) {
			colloqiumDTO.setSubjectId(source.getSubject().getId());

		}
		
		
		return colloqiumDTO;
	}
	
	
	public List<Colloqium> convertSetToList(Set<Colloqium> set){
        // create an empty list 
        List<Colloqium> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (Colloqium a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	
	
	
	
	public List<ColloqiumDTO> convert(List<Colloqium> source){
		List<ColloqiumDTO> colloqiums = new ArrayList<ColloqiumDTO>();
		for(Colloqium exam : source) {
			colloqiums.add(convert(exam));
		}
		return colloqiums;
	}
}
