package com.eobrazovanje.ssluzba.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.ArticleDTO;
import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.dto.converter.ArticleToDTO;
import com.eobrazovanje.ssluzba.dto.converter.LecturerToDTO;
import com.eobrazovanje.ssluzba.entities.Article;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.repository.ArticleRepository;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;

@RestController
@RequestMapping("api/article")
public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	LecturerRepository lecturerRepo;

	@Autowired
	ArticleToDTO articleToDTO;
	
	@Autowired
	LecturerToDTO lectToDTO;

	
	@GetMapping("/get-all")
	public ResponseEntity<List<ArticleDTO>> getAllStudents(){
		return new ResponseEntity<List<ArticleDTO>>(articleToDTO.convert(articleRepository.findAll()), HttpStatus.OK);
	}
	
	
	@PostMapping(value="/create-article",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createNewArticle(@RequestBody ArticleDTO article){
		
		java.util.Date utilDate = new java.util.Date();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loggedStudentUsername = authentication.getName();
		Lecturer logged = lecturerRepo.getByUsername(loggedStudentUsername);
		
		Date date = new Date(utilDate.getTime());
		Article newArt = new Article();
		newArt.setArticleName(article.getArticleName());
		newArt.setArticeText(article.getArticleText());
		newArt.setDateCreated(date);
		newArt.setLecturer(logged);
		
		
		articleRepository.save(newArt);
		
		return new ResponseEntity<>("Article created", HttpStatus.OK);
		
	}	
}
