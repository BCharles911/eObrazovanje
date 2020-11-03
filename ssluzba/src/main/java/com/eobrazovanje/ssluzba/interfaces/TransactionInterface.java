package com.eobrazovanje.ssluzba.interfaces;

import com.eobrazovanje.ssluzba.dto.TransactionDTO;
import com.eobrazovanje.ssluzba.entities.Transaction;

public interface TransactionInterface {

	Transaction getOne(Long transaction);
	Transaction save(Transaction transaction);
	Transaction edit(TransactionDTO transaction, Long id);
	void delete(Long id);
}
