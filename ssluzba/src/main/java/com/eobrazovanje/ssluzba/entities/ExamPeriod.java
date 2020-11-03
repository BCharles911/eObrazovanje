package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "exam_period")
@Table(name = "exam_period")
@EqualsAndHashCode
@Getter
@Setter
public class ExamPeriod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	
	@Column(name = "start_date", nullable = false)
	@Getter
	@Setter
	private Date startDate;
	
	
	@Column(name = "end_date", nullable = false)
	@Getter
	@Setter
	private Date endDate;
	
	@Column(name = "exam_period_name", nullable = false)
	@Getter
	@Setter
	private String examPeriodName;
	
	@Column(name = "is_active", nullable = false, columnDefinition = "TINYINT(1)")
	@Getter
	@Setter
	@Value("${exam_period.is_active:false}")
	private boolean isActive;
	
	
	
	public ExamPeriod() {
		
	}

	public ExamPeriod(Long id, Date startDate, Date endDate, String examPeriodName, boolean isActive) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.examPeriodName = examPeriodName;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ExamPeriod [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", examPeriodName="
				+ examPeriodName + ", isActive=" + isActive + "]";
	}
	
	
	
	
	
	

}
