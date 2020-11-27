package com.eobrazovanje.ssluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.FinancialCardDTO;
import com.eobrazovanje.ssluzba.dto.converter.FinancialCardToDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToFinancialCard;
import com.eobrazovanje.ssluzba.entities.FinancialCard;
import com.eobrazovanje.ssluzba.entityManager.UtilManager;
import com.eobrazovanje.ssluzba.repository.FinancialCardRepository;
import com.eobrazovanje.ssluzba.services.FinancialCardService;

@RestController
@RequestMapping("api/financial-card")
public class FinancialCardController {

	@Autowired
	FinancialCardRepository financialCardRepository;
	
	@Autowired
	FinancialCardToDTO financialCardToDTO;
	
	@Autowired
	DTOToFinancialCard dtoToFinancialCard;
	
	@Autowired
	FinancialCardService financialCardService;
	
	@Autowired
	UtilManager utilManager;
	
	@GetMapping("/get-all")
	public ResponseEntity<List<FinancialCardDTO>> getAllFinancialCard(){
		return new ResponseEntity<>(financialCardToDTO.convert(financialCardRepository.findAll()), HttpStatus.OK);
	}
	
/*	GetMapping("/get-fcard-for-student")
	public ResponseEntity<List<FinancialCardDTO>> getFinancialCardForStudent(@RequestParam("studentId") Long id) {
		FinancialCard financialCard = financialCardRepository.findFinancialCardByStudentId(id);
		
		return new ResponseEntity<>(financialCardToDTO)
	}*/
	
	@PostMapping(value= "/create", consumes= "application/json")
	public ResponseEntity<?> createFinancialCard(@RequestBody FinancialCardDTO financialCardDTO, Errors errors){
		
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		FinancialCard newFinancialCard = financialCardRepository.save(dtoToFinancialCard.convert(financialCardDTO));
		return new ResponseEntity<>(financialCardToDTO.convert(newFinancialCard), HttpStatus.OK);
	}
}
