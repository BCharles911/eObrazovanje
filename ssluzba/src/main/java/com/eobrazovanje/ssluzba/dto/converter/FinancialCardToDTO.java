package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.FinancialCardDTO;
import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.entities.FinancialCard;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;


@Component
public class FinancialCardToDTO implements Converter<FinancialCard, FinancialCardDTO> {

	@Autowired
	TransactionToDTO transactionToDTO;
	
	@Autowired
	StudentToDTO studentToDTO;
	
	public FinancialCardDTO convert(FinancialCard source) {
		
		
		if(source == null) {
			return null;
		}
		
		FinancialCardDTO financialCardDTO = new FinancialCardDTO();
		
		financialCardDTO.setId(source.getId());
		financialCardDTO.setCardNumber(source.getCardNumber());
		financialCardDTO.setCardType(source.getCardType());
		financialCardDTO.setBalance(source.getBalance());
		financialCardDTO.setBlocked(source.isBlocked());
		
		if (source.getTransaction() != null) {
			financialCardDTO.setTransactionDTO(transactionToDTO.convert(transactionToDTO.convertSetToList(source.getTransaction())));
		}
		
		//financialCardDTO.setStudentDTO(studentToDTO.convert(source.getStudent()));
		
		
		return financialCardDTO;
	}

	public List<FinancialCard> convertSetToList(Set<FinancialCard> set) {
		List<FinancialCard> list = new ArrayList<>();
		
		for (FinancialCard f : set)
			list.add(f);
		
		return list;
	}
	
	public List<FinancialCardDTO> convert(List<FinancialCard> source) {
		List<FinancialCardDTO> financialCards = new ArrayList<FinancialCardDTO>();
		for (FinancialCard f : source) {
			financialCards.add(convert(f));
		}		
		return financialCards;
	}
 
	
}
