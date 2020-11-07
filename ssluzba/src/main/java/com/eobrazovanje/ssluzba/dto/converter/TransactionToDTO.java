package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.TransactionDTO;
import com.eobrazovanje.ssluzba.entities.Transaction;

@Component
public class TransactionToDTO implements Converter<Transaction, TransactionDTO> {

	@Autowired
	FinancialCardToDTO financialCardToDTO;
	
	@Override
	public TransactionDTO convert(Transaction source) {
		
		if (source == null) {
			return null;
		}
		
		TransactionDTO transactionDTO = new TransactionDTO();
			
		transactionDTO.setId(source.getId());
		transactionDTO.setAmount(source.getAmount());
		transactionDTO.setPaymentPurpose(source.getPaymentPurpose());
		transactionDTO.setTransactionDate(source.getTransactionDate());
		//transactionDTO.setFinancialCard(financialCardToDTO.convert(source.getFinancial_card()));
		
		return transactionDTO;
	}
	
	public List<Transaction> convertSetToList(Set<Transaction> set) {
		
		List<Transaction> list = new ArrayList<>();
		
		for (Transaction t : set)
			list.add(t);
		
		return list;
	}
	
	public List<TransactionDTO> convert(List<Transaction> source) {
		List<TransactionDTO> transactions = new ArrayList<TransactionDTO>();
		
		for (Transaction t : source) {
			transactions.add(convert(t));
		}
		return transactions;
	}
}
