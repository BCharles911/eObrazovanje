package com.eobrazovanje.ssluzba.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.eobrazovanje.ssluzba.entities.Document;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.Person;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.repository.DocumentRepository;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.StudentRepository;

@Service
public class DocumentService  {

	@Autowired
	DocumentRepository documentRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	LecturerRepository lecturerRepository;
	
	  public Document store(MultipartFile file,  Person person) throws IOException {
		  	if(studentRepository.getByUsername(person.getUsername()) != null) {
		  		System.out.println("whtsda");
		  		Student st = studentRepository.getByUsername(person.getUsername());
		  	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			    Document document = new Document(fileName, file.getContentType(), file.getBytes());
			    document.setStudent(st);
			    return documentRepository.save(document);
		  	}else {
		  		System.out.println("DOMACI SIR");

		  		Lecturer lecturer = lecturerRepository.getByUsername(person.getUsername());
			    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			    Document document = new Document(fileName, file.getContentType(), file.getBytes());
			    document.setLecturer(lecturer);
			    return documentRepository.save(document);
		  	}

		  }

		  public Document getFile(String id) {
		    return documentRepository.findById(id).get();
		  }
		  
		  public Stream<Document> getAllFiles() {
		    return documentRepository.findAll().stream();
		  }
		  
		  public Stream<Document> getAllStudentFiles(Long id) {
			  return documentRepository.findDocumentByStudentId(id).stream();
		  }
		  
		  public Stream<Document> getAllLecturerFiles(Long id){
			  return documentRepository.findDocumentByLecturerId(id).stream();
		  }
	
}
