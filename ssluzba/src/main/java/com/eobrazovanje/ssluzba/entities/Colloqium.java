package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;

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

@Entity(name = "colloqium")
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
	
	@Column(name="place")
	@Getter @Setter private String place;
	
	
	@Column(name  = "startDate" )
	@Getter @Setter private Date startDate;
	
	@Column(name  = "point_number" )
	@Getter @Setter private int pointNumber;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="subject_id",referencedColumnName="id",nullable=false,unique=true)
    @Getter @Setter private Subject subject;
	
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
