package com.eobrazovanje.ssluzba.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "transaction")
@Table(name = "transaction")
@EqualsAndHashCode
@Getter
@Setter
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	
	@Column(name = "amount")
	@Getter
	@Setter
	private Double amount;
	
	
	@Column(name = "payment_purpose")
	@Getter
	@Setter
	private String paymentPurpose;
	
	
	@Column(name = "transaction_date")
	@Getter
	@Setter
	private Date transactionDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="financial_card_id",referencedColumnName="id",nullable=false)
	private FinancialCard financial_card;
	
	
	public Transaction() {
		
	}


	public Transaction(Long id, Double amount, String paymentPurpose, Date transactionDate, FinancialCard financial_card) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentPurpose = paymentPurpose;
		this.transactionDate = transactionDate;
		this.financial_card = financial_card;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", paymentPurpose=" + paymentPurpose
				+ ", transactionDate=" + transactionDate + ", financialCard=" + financial_card + "]";
	}
	
	
	
	

}
