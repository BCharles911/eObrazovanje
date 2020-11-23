package com.eobrazovanje.ssluzba.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Long id;
	
	
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	
	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	@Column(name = "exam_period_name", nullable = false)
	private String examPeriodName;
	
	@Column(name = "is_active", nullable = false, columnDefinition = "TINYINT(1)")
	@Value("${exam_period.is_active:false}")
	private boolean isActive;
	
	
	@OneToMany(mappedBy="examPeriod")
	@JsonIgnore
	private Set<ExamRecord> examRecords;
	
	
	
	
	
	
	
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
