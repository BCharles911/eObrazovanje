package com.eobrazovanje.ssluzba.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.eobrazovanje.ssluzba.entities.Document;
import com.eobrazovanje.ssluzba.repository.DocumentRepository;

@Service
public class DocumentService  {

	@Autowired
	DocumentRepository documentRepository;
	
	  public Document store(MultipartFile file) throws IOException {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    Document Document = new Document(fileName, file.getContentType(), file.getBytes());

		    return documentRepository.save(Document);
		  }

		  public Document getFile(String id) {
		    return documentRepository.findById(id).get();
		  }
		  
		  public Stream<Document> getAllFiles() {
		    return documentRepository.findAll().stream();
		  }
	
}
