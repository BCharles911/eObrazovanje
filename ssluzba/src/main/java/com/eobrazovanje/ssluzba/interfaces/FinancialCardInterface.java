package com.eobrazovanje.ssluzba.interfaces;

import com.eobrazovanje.ssluzba.dto.FinancialCardDTO;
import com.eobrazovanje.ssluzba.entities.FinancialCard;

public interface FinancialCardInterface {

	FinancialCard getOne(Long financialCardId);
	FinancialCard save(FinancialCard financialCard);
	FinancialCard edit(FinancialCardDTO financialCard, Long id);
	void delete(Long id);
	
}
