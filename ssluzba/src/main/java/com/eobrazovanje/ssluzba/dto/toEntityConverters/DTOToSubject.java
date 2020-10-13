package com.eobrazovanje.ssluzba.dto.toEntityConverters;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;

@Component
public class DTOToSubject implements Converter<SubjectDTO, Subject> {

	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	DTOToColloqium toColloqium;
	
	@Override
	public Subject convert(SubjectDTO source) {
		
		if(source == null) {
			return null;
		}
		
		Subject subject = new Subject();
		
		subject.setId(source.getId());
		subject.setSubjectName(source.getSubjectName());
		subject.setShortName(source.getShortName());
		subject.setEctsPoints(source.getEctsPoints());
		
		if(source.getColloqiumsDTO() != null) {
			
			subject.setColloqium(toColloqium.convertListToSet(toColloqium.convert(source.getColloqiumsDTO())));
		}
		
		return subject;
	}

}
