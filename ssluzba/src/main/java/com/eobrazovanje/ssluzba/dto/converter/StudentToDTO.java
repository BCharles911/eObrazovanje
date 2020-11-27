package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.entities.Student;

@Component
public class StudentToDTO implements Converter<Student, StudentDTO> {

	@Autowired
	StudentHasSubjectToDTO stHasSubjectToDTO;
	
	@Autowired
	CoursesToDTO courseToDTO;
	
	@Autowired
	FinancialCardToDTO financialToDTO;
	
	@Override
	public StudentDTO convert(Student source) {
		
		if(source == null) {
			return null;
		}
		
		StudentDTO studentDTO = new StudentDTO();
		
		
		studentDTO.setId(source.getId());
		studentDTO.setFirstName(source.getFirstName());
		studentDTO.setLastName(source.getLastName());
		studentDTO.setDeleted(source.isDeleted());
		studentDTO.setUsername(source.getUsername());
		studentDTO.setGender(source.getGender());
		studentDTO.setDateOfBirth(source.getDateOfBirth());
		studentDTO.setPlaceOfBirth(source.getPlaceOfBirth());
		studentDTO.setStateOfBirth(source.getStateOfBirth());
		studentDTO.setResidence_address(source.getResidence_address());
		studentDTO.setTownship(source.getTownship());
		studentDTO.setCity(source.getCity());
		studentDTO.setPhoneNumber(source.getPhoneNumber());
		studentDTO.setMobilePhoneNumber(source.getMobilePhoneNumber());
		studentDTO.setCitizenship(source.getCitizenship());
		studentDTO.setEthnicity(source.getEthnicity());
		studentDTO.setIndexNumber(source.getIndexNumber());
		studentDTO.setHighSchool(source.getHighSchool());
		studentDTO.setHsFinishYear(source.getHsFinishYear());
		studentDTO.setParentName(source.getParentName());
		studentDTO.setCurrentYear(source.getCurrentYear());
		studentDTO.setFinancialCard(financialToDTO.convert(source.getFinancialCard()));
		studentDTO.setCourse(courseToDTO.convert(source.getCourse()));
		studentDTO.setStudentStatus(source.getStudentStatus());
		if(source.getStudentHasSubject() != null) {
			studentDTO.setStudentHasSubjectDTO(stHasSubjectToDTO.convert(stHasSubjectToDTO.convertSetToList(source.getStudentHasSubject())));

		}
	
		return studentDTO;
	}

	public List<Student> convertSetToList(Set<Student> set){
        // create an empty list 
        List<Student> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (Student a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	
	
	
	
	public List<StudentDTO> convert(List<Student> source){
		List<StudentDTO> students = new ArrayList<StudentDTO>();
		for(Student acc : source) {
			students.add(convert(acc));
		}
		return students;
	}
	
}
