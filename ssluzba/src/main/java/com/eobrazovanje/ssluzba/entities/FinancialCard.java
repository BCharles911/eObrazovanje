package com.eobrazovanje.ssluzba.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eobrazovanje.ssluzba.entities.enumerations.CARD_TYPE;
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
	
	
	@Column(name = "card_number", nullable = false)
	@Getter
	@Setter
	private int cardNumber;
	
	
/*	@Column(name = "card_type", nullable = false)
	@Getter
	@Setter
	*/
	@Enumerated(EnumType.STRING)
	private CARD_TYPE cardType;
	
	
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
	
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
	private Student student;
	
	
	
	public FinancialCard() {
		
	}



	public FinancialCard(Long id, Double balance, int cardNumber, CARD_TYPE cardType, boolean isBlocked, Set<Transaction> transaction,
			Set<FinancialCardStatus> financialStatus) {
		super();
		this.id = id;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.isBlocked = isBlocked;
		this.transaction = transaction;
		this.financialStatus = financialStatus;
	}



	@Override
	public String toString() {
		return "FinancialCard [id=" + id + ", balance=" + balance + ", cardNumber=" + cardNumber + ", "
				+ "cardType=" + cardType + ", isBlocked=" + isBlocked + ", transaction=" + transaction + ", "
						+ "financialStatus=" + financialStatus + "]";
	}




}
