package com.eobrazovanje.ssluzba.dto.toEntityConverters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.entities.Lecturer;

@Component
public class DTOToLecturer implements Converter<LecturerDTO, Lecturer> {

	@Override
	public Lecturer convert(LecturerDTO source) {
		// TODO Auto-generated method stub
		if(source == null) {
			return null;
		}
		
		Lecturer lecturer = new Lecturer();
		
		
		return lecturer;
	}

}
