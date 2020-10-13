package com.eobrazovanje.ssluzba.dto.toEntityConverters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.StudentHasSubjectDTO;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;

@Component
public class DTOToStudentHasSubject implements Converter<StudentHasSubjectDTO, StudentHasSubject> {

	@Override
	public StudentHasSubject convert(StudentHasSubjectDTO source) {
		// TODO Auto-generated method stub
		return null;
	}

}
