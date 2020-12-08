package com.eobrazovanje.ssluzba.interfaces;



import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.entities.Student;


public interface StudentInterface {

	Student getOne(String studentId);
	Student getByFirstName(String firstname);
	Student save(Student student);
	Student edit(StudentDTO student, String id);
	void delete(String id);
	//Page<Student> getAllPaged(Pageable pageRequest);
	//List<Student> getAll();
	
}
