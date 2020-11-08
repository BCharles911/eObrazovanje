package com.eobrazovanje.ssluzba.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "document")
@Table(name = "document")
@Getter
@Setter
public class Document {
	
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	
	@NotNull
	@NotBlank
	@Column(name = "document_name")
	private String documentName;
	
	
	@Column(name = "type")
	private  String type;
	
	
	@Lob
	private byte[] data;
	
	
    @ManyToOne
    @JoinColumn(name="lecturer_id", nullable=true)
    private Lecturer lecturer;
    
    @ManyToOne
    @JoinColumn(name="student_id", nullable=true)
    private Student student;

    public Document() {
    	super();
    }
    
    
    
	public Document(String id, @NotNull @NotBlank String documentName, String type, byte[] data) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.type = type;
		this.data = data;
	}

	public Document(String id, @NotNull @NotBlank String documentName, String type, byte[] data, Lecturer lecturer) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.type = type;
		this.data = data;
		this.lecturer = lecturer;
	}

	public Document(String id, @NotNull @NotBlank String documentName, String type, byte[] data, Student student) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.type = type;
		this.data = data;
		this.student = student;
	}



	public Document(@NotNull @NotBlank String documentName, String type, byte[] data) {
		super();
		this.documentName = documentName;
		this.type = type;
		this.data = data;
	}
	
	
	
	
	
	

}
