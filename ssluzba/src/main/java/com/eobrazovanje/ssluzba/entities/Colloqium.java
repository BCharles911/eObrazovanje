package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "colloqium")
@EqualsAndHashCode
@Getter
@Setter
public class Colloqium {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@Column(name  = "place" )
	@Getter @Setter private String place;
	
	
	@Column(name  = "startDate" )
	@Getter @Setter private Date startDate;
	
	@Column(name  = "place" )
	@Getter @Setter private int pointNumber;
	
	
	
	public Colloqium() {
		
	}

	public Colloqium(Long id, String place, Date startDate, int pointNumber) {
		super();
		this.id = id;
		this.place = place;
		this.startDate = startDate;
		this.pointNumber = pointNumber;
	}





	@Override
	public String toString() {
		return "Colloqium [id=" + id + ", place=" + place + ", startDate=" + startDate + ", pointNumber=" + pointNumber
				+ "]";
	}
	
	

}
