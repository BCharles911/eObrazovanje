package com.eobrazovanje.ssluzba.dto.toEntityConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.entities.Student;

@Component
public class DTOToStudent  implements Converter<StudentDTO, Student>{
	
	@Autowired
	DTOToCourses toCourse;
	
	@Autowired
	DTOToStudentHasSubject toStudentHasSubject;

	@Override
	public Student convert(StudentDTO source) {
		
		if(source == null) {
			return null;
		}
		
		Student student = new Student();
		
		student.setId(source.getId());
		student.setFirstName(source.getFirstName());
		student.setLastName(source.getLastName());
		student.setDeleted(source.isDeleted());
		student.setUsername(source.getUsername());
		student.setGender(source.getGender());
		student.setDateOfBirth(source.getDateOfBirth());
		student.setPlaceOfBirth(source.getPlaceOfBirth());
		student.setStateOfBirth(source.getStateOfBirth());
		student.setResidence_address(source.getResidence_address());
		student.setTownship(source.getTownship());
		student.setCity(source.getCity());
		student.setPhoneNumber(source.getPhoneNumber());
		student.setMobilePhoneNumber(source.getMobilePhoneNumber());
		student.setCitizenship(source.getCitizenship());
		student.setEthnicity(source.getEthnicity());
		student.setIndexNumber(source.getIndexNumber());
		student.setHighSchool(source.getHighSchool());
		student.setHsFinishYear(source.getHsFinishYear());
		student.setParentName(source.getParentName());
		student.setRoles(source.getRoles());
		student.setCourse(toCourse.convert(source.getCourse()));
		student.setStudentStatus(source.getStudentStatus());
		
		return student;
	}
	
	

}
