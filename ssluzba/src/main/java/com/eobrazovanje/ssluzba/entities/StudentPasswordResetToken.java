package com.eobrazovanje.ssluzba.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentPasswordResetToken {
	
	private static final int EXPIRATION = 60 * 24;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String token;
 
    @OneToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "student_id")
    private Student student;
 
    private Date expiryDate;

    public StudentPasswordResetToken() {
    	super();
    }
    
	public StudentPasswordResetToken(Long id, String token, Student student, Date expiryDate) {
		super();
		this.id = id;
		this.token = token;
		this.student = student;
		this.expiryDate = expiryDate;
	}

	public StudentPasswordResetToken(Student student, String token) {
		this.student = student;
		this.token = token;
		// TODO Auto-generated constructor stub
	}
    
	public StudentPasswordResetToken(final String token, final Student student) {
		super();
		
		this.token = token;
		this.student = student;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}
    
	
	   private Date calculateExpiryDate(final int expiryTimeInMinutes) {
	        final Calendar cal = Calendar.getInstance();
	        cal.setTimeInMillis(new Date().getTime());
	        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
	        return new Date(cal.getTime().getTime());
	    }
	   
	   
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((getExpiryDate() == null) ? 0 : getExpiryDate().hashCode());
	        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
	        result = prime * result + ((getStudent() == null) ? 0 : getStudent().hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(final Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final StudentPasswordResetToken other = (StudentPasswordResetToken) obj;
	        if (getExpiryDate() == null) {
	            if (other.getExpiryDate() != null) {
	                return false;
	            }
	        } else if (!getExpiryDate().equals(other.getExpiryDate())) {
	            return false;
	        }
	        if (getToken() == null) {
	            if (other.getToken() != null) {
	                return false;
	            }
	        } else if (!getToken().equals(other.getToken())) {
	            return false;
	        }
	        if (getStudent() == null) {
	            if (other.getStudent() != null) {
	                return false;
	            }
	        } else if (!getStudent().equals(other.getStudent())) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        final StringBuilder builder = new StringBuilder();
	        builder.append("Token [String=").append(token).append("]").append("[Expires").append(expiryDate).append("]");
	        return builder.toString();
	    }
	
}
