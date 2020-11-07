package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.eobrazovanje.ssluzba.entities.Role;
import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9067616250604800401L;
	private Long id;
	private Double amount;
	private String paymentPurpose;
	private Date transactionDate;
	@JsonIgnore
	private FinancialCardDTO financialCard;
	
	public TransactionDTO() {
		
	}

	public TransactionDTO(Long id, Double amount, String paymentPurpose, Date transactionDate, FinancialCardDTO financialCard) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentPurpose = paymentPurpose;
		this.transactionDate = transactionDate;
		this.financialCard = financialCard;
	}
	
	
}
