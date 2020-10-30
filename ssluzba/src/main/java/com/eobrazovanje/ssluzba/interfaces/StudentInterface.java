package com.eobrazovanje.ssluzba.interfaces;



import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.entities.Student;


public interface StudentInterface {

	Student getOne(Long studentId);
	Student getByFirstName(String firstname);
	Student save(Student student);
	Student edit(StudentDTO student, Long id);
	void delete(Long id);
	//Page<Student> getAllPaged(Pageable pageRequest);
	//List<Student> getAll();
	
}
