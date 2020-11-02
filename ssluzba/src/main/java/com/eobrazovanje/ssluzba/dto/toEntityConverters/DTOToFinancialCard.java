package com.eobrazovanje.ssluzba.dto.toEntityConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.FinancialCardDTO;
import com.eobrazovanje.ssluzba.entities.FinancialCard;
import com.eobrazovanje.ssluzba.entities.Transaction;
import com.eobrazovanje.ssluzba.repository.TransactionRepository;

@Component
public class DTOToFinancialCard implements Converter<FinancialCardDTO, FinancialCard> {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	DTOToTransaction toTransaction;
	
	@Override
	public FinancialCard convert(FinancialCardDTO source) {
		
		if (source == null) {
			return null;
		}
		
		FinancialCard financialCard = new FinancialCard();
		financialCard.setId(source.getId());
		financialCard.setBalance(source.getBalance());
		financialCard.setCardNumber(source.getCardNumber());
		financialCard.setCardType(source.getCardType());
		if (source.getTransactionDTO() != null) {
			financialCard.setTransaction(toTransaction.convertListToSet(toTransaction.convert(source.getTransactionDTO())));
		}
		
		return null;
	}
}
