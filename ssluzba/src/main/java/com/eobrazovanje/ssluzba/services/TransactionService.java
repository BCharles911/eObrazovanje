package com.eobrazovanje.ssluzba.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eobrazovanje.ssluzba.dto.TransactionDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToTransaction;
import com.eobrazovanje.ssluzba.entities.Transaction;
import com.eobrazovanje.ssluzba.interfaces.TransactionInterface;
import com.eobrazovanje.ssluzba.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService implements TransactionInterface {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	DTOToTransaction toTransaction;
	
	@Override
	public Transaction getOne(Long transactionId) {
		return transactionRepository.getOne(transactionId);
	}
	
	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}
	
	//NIJE POTREBNA UOPSTE
	@Override
	public Transaction edit(TransactionDTO transaction, Long id) {
		
		Transaction transactionEdit = transactionRepository.findTransactionById(transaction.getId());
		
		
		return transactionEdit;
	}
}
