package com.eobrazovanje.ssluzba.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eobrazovanje.ssluzba.dto.DocumentResponseDTO;
import com.eobrazovanje.ssluzba.dto.ResponseMessage;
import com.eobrazovanje.ssluzba.entities.Document;
import com.eobrazovanje.ssluzba.repository.DocumentRepository;
import com.eobrazovanje.ssluzba.services.DocumentService;

@RestController
@RequestMapping("api/document")
public class DocumentController {
	
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@PostMapping(value="/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	    	documentService.store(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
	
	
	 @GetMapping("/files")
	  public ResponseEntity<List<DocumentResponseDTO>> getListFiles() {
	    List<DocumentResponseDTO> files = documentService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/api/document/files/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new DocumentResponseDTO(
	          dbFile.getDocumentName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	 
	 
	 @GetMapping("/files-for-student")
	  public ResponseEntity<List<DocumentResponseDTO>> getStudentFiles(@RequestParam("id") Long id) {
	    List<DocumentResponseDTO> files = documentService.getAllStudentFiles(id).map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/api/document/files/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new DocumentResponseDTO(
	          dbFile.getDocumentName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    Document fileDB = documentService.getFile(id);
	    System.out.println(fileDB.toString());
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getDocumentName() + "\"")
	        .body(fileDB.getData());
	  }
	


}
