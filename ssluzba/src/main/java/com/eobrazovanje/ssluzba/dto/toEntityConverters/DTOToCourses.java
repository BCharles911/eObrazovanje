package com.eobrazovanje.ssluzba.dto.toEntityConverters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.CourseDTO;
import com.eobrazovanje.ssluzba.entities.Course;

@Component
public class DTOToCourses  implements Converter<CourseDTO, Course>{

	@Override
	public Course convert(CourseDTO source) {
		// TODO Auto-generated method stub
		return null;
	}

}
