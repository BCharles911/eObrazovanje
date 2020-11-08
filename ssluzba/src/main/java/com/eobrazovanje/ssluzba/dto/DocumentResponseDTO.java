package com.eobrazovanje.ssluzba.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentResponseDTO {
	
	  private String name;
	  private String url;
	  private String type;
	  private long size;
	  
	  
	  public DocumentResponseDTO(String name, String url, String type, long size) {
		    this.name = name;
		    this.url = url;
		    this.type = type;
		    this.size = size;
		  }

}
