package com.eobrazovanje.ssluzba.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToStudent;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.interfaces.CustomMapper;
import com.eobrazovanje.ssluzba.interfaces.StudentInterface;
import com.eobrazovanje.ssluzba.repository.StudentRepository;

@Service
@Transactional
public class StudentService implements StudentInterface {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	DTOToStudent toStudent;
	


	
	@Override
	public Student getOne(Long studentId) {
		return studentRepository.getOne(studentId);
	}

	@Override
	public Student getByFirstName(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Student edit(StudentDTO student, Long id) {
		
		Student studentEdit = studentRepository.findStudentById(student.getId());
		studentEdit.setAvgGrade(student.getAvgGrade());
		studentEdit.setCitizenship(student.getCitizenship());
		studentEdit.setFirstName(student.getFirstName());
		studentEdit.setCurrentYear(student.getCurrentYear());
		studentEdit.setGender(student.getGender());
		studentEdit.setCity(student.getCity());
		studentEdit.setEthnicity(student.getEthnicity());
		studentEdit.setDeleted(student.isDeleted());
		studentEdit.setHighSchool(student.getHighSchool());
		studentEdit.setHsFinishYear(student.getHsFinishYear());
		studentEdit.setParentName(student.getParentName());
		studentRepository.save(studentEdit);
		return studentEdit;
	}
	

	

}
