package com.eobrazovanje.ssluzba.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "financial_card")
@Table(name = "financial_card")
@EqualsAndHashCode
@Getter
@Setter
public class FinancialCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	
	
	@Column(name = "balance", nullable = false)
	@Getter
	@Setter
	private Double balance;
	
	@Column(name = "card_type", nullable = false)
	@Getter
	@Setter
	private int cardNumber;
	
	
	@Column(name = "is_blocked", nullable = false)
	@Getter
	@Setter
	private boolean isBlocked;
	

	
	@OneToMany(mappedBy = "financial_card")
	@Getter
	@Setter
	private Set<Transaction> transaction;
	
	
	@ManyToMany(cascade= {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name = "financial_status",
				joinColumns=@JoinColumn(name = "id",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "status_id"))
	@JsonIgnore
	private Set<FinancialCardStatus> financialStatus = new HashSet<>();
	
	
	
	public FinancialCard() {
		
	}



	public FinancialCard(Long id, Double balance, int cardNumber, boolean isBlocked, Set<Transaction> transaction,
			Set<FinancialCardStatus> financialStatus) {
		super();
		this.id = id;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.isBlocked = isBlocked;
		this.transaction = transaction;
		this.financialStatus = financialStatus;
	}



	@Override
	public String toString() {
		return "FinancialCard [id=" + id + ", balance=" + balance + ", cardNumber=" + cardNumber + ", isBlocked="
				+ isBlocked + ", transaction=" + transaction + ", financialStatus=" + financialStatus + "]";
	}




}
