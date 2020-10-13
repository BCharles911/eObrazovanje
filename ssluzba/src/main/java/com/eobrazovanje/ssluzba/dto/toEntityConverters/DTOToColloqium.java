package com.eobrazovanje.ssluzba.dto.toEntityConverters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import com.eobrazovanje.ssluzba.dto.ColloqiumDTO;
import com.eobrazovanje.ssluzba.entities.Colloqium;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;

@Component
public class DTOToColloqium implements Converter<ColloqiumDTO, Colloqium> {

	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public Colloqium convert(ColloqiumDTO source) {
		

		
		if(source == null) {
			return null;
		}
		Colloqium colloqium = new Colloqium();
		
		colloqium.setId(source.getId());
		colloqium.setPlace(source.getPlace());
		colloqium.setPointNumber(source.getPointNumber());
		colloqium.setStartDate(source.getStartDate());
		if(source.getSubjectId() != null) {
			Subject subject = subjectRepository.getOne(source.getSubjectId());
			colloqium.setSubject(subject);
		}
		return colloqium;
		
		
	}

	
	public Set<Colloqium> convertListToSet(List<Colloqium> list){
        // create an empty list 
        Set<Colloqium> set = new HashSet<>(); 
  
        // push each element in the set into the list 
        for (Colloqium a : list) 
            set.add(a); 
  
        // return the list 
        return set; 
	}
	
	
	public List<Colloqium> convert(List<ColloqiumDTO> source){
		ArrayList<Colloqium> colloqiums = new ArrayList<Colloqium>();
		for(ColloqiumDTO colloqium : source) {
			colloqiums.add(convert(colloqium));
		}
		return colloqiums;
	}
}
