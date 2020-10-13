package com.eobrazovanje.ssluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.interfaces.StudentInterface;
import com.eobrazovanje.ssluzba.repository.StudentRepository;

@Service
public class StudentService implements StudentInterface {

	@Autowired
	StudentRepository studentRepository;
	
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
	
	

}
