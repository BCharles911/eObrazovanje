package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.CourseDTO;
import com.eobrazovanje.ssluzba.entities.Course;

@Component
public class CoursesToDTO implements Converter<Course, CourseDTO> {

	@Autowired
	SubjectToDTO subjectToDTO;
	
	@Override
	public CourseDTO convert(Course source) {
		
		
		if(source == null) {
			return null;		
			}
		
		CourseDTO courseDTO = new CourseDTO();
		
		courseDTO.setId(source.getId());
		courseDTO.setCourseName(source.getCourseName());
		courseDTO.setShortName(source.getCourseName());
		courseDTO.setDescription(source.getDescription());
		
		if(source.getSubject() != null) {
			courseDTO.setSubjects(subjectToDTO.convert(subjectToDTO.convertSetToList(source.getSubject())));
			
			
		}
		
		
		return courseDTO;
		
	}
	
	public List<Course> convertSetToList(Set<Course> set){
        // create an empty list 
        List<Course> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (Course a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	
	
	
	
	public List<CourseDTO> convert(List<Course> source){
		List<CourseDTO> courses = new ArrayList<CourseDTO>();
		for(Course acc : source) {
			courses.add(convert(acc));
		}
		return courses;
	}
	
	
	

}
