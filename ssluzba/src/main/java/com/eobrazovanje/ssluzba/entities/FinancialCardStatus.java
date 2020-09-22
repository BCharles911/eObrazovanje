package com.eobrazovanje.ssluzba.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.eobrazovanje.ssluzba.entities.enumerations.FINANCING_STATUS;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "financial_card_status")
public class FinancialCardStatus {
	
	@Id
	@Column(name = "status_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	
	
    @Enumerated(EnumType.STRING)
    @NaturalId
	@Column(name = "status_name")
	private FINANCING_STATUS name;


	public FINANCING_STATUS getName() {
		return name;
	}



	public void setName(FINANCING_STATUS name) {
		this.name = name;
	}
	
    
    
	

}
