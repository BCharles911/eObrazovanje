package com.eobrazovanje.ssluzba.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import com.eobrazovanje.ssluzba.entities.Role;
import com.eobrazovanje.ssluzba.entities.enumerations.CARD_TYPE;
import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FinancialCardDTO implements Serializable {

	private Long id;
	private Double balance;
	private int cardNumber;
	private CARD_TYPE cardType;
	private boolean isBlocked;
	private StudentDTO studentDTO;
	private List<TransactionDTO> transactionDTO;
	
	public FinancialCardDTO() {
		
	}
	
	
	public FinancialCardDTO(Long id, Double balance, int cardNumber, CARD_TYPE cardType, boolean isBlocked,
			StudentDTO studentDTO, List<TransactionDTO> transactionDTO) {
		super();
		this.id = id;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.isBlocked = isBlocked;
		this.studentDTO = studentDTO;
		this.transactionDTO = transactionDTO;
	}
	
}
