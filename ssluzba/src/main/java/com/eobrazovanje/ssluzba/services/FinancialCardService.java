package com.eobrazovanje.ssluzba.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eobrazovanje.ssluzba.dto.FinancialCardDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToFinancialCard;
import com.eobrazovanje.ssluzba.entities.FinancialCard;
import com.eobrazovanje.ssluzba.interfaces.FinancialCardInterface;
import com.eobrazovanje.ssluzba.repository.FinancialCardRepository;

@Service
@Transactional
public class FinancialCardService implements FinancialCardInterface {

	@Autowired
	FinancialCardRepository financialCardRepository;
	
	@Autowired
	DTOToFinancialCard toFinancialCard;
	
	@Override
	public FinancialCard getOne(Long financialCardId) {
		return financialCardRepository.getOne(financialCardId);
	}
	
	@Override
	public FinancialCard save(FinancialCard financialCard) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public FinancialCard edit(FinancialCardDTO financialCard, Long id) {
		
		FinancialCard financialCardEdit = financialCardRepository.findFinancialCardById(financialCard.getId());
		financialCardEdit.setBalance(financialCard.getBalance());
		financialCardEdit.setCardNumber(financialCard.getCardNumber());
		financialCardEdit.setCardType(financialCard.getCardType());
		financialCardEdit.setBlocked(financialCard.isBlocked());		
		
		financialCardRepository.save(financialCardEdit);
		return financialCardEdit;
	}
	
}
