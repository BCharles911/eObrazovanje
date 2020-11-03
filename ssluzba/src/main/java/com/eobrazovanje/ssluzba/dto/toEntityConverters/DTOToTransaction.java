package com.eobrazovanje.ssluzba.dto.toEntityConverters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.TransactionDTO;
import com.eobrazovanje.ssluzba.entities.Transaction;

@Component
public class DTOToTransaction implements Converter<TransactionDTO, Transaction> {

	@Autowired
	DTOToFinancialCard toFinancialCard;
	
	@Override
	public Transaction convert(TransactionDTO source) {
		
		if (source == null) {
			return null;
		}
		
		Transaction transaction = new Transaction();
		transaction.setId(source.getId());
		transaction.setAmount(source.getAmount());
		transaction.setPaymentPurpose(source.getPaymentPurpose());
		transaction.setTransactionDate(source.getTransactionDate());
		transaction.setFinancial_card(toFinancialCard.convert(source.getFinancialCard()));
		
		return transaction;
	}
	
	public Set<Transaction> convertListToSet(List<Transaction> list) {
		Set<Transaction> set = new HashSet<>();
		
		for (Transaction t : list)
			set.add(t);
		
		return set;
	}
	
	public List<Transaction> convert(List<TransactionDTO> source) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		for (TransactionDTO t : source) {
			transactions.add(convert(t));
		}
		return transactions;
	}
}
