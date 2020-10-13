package com.eobrazovanje.ssluzba.utility;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	

	private String profOrStudent;
	
	
    @NotBlank
    private String username;

    @NotBlank
    private String password;
    
    

    public String getProfOrStudent() {
		return profOrStudent;
	}

	public void setProfOrStudent(String profOrStudent) {
		this.profOrStudent = profOrStudent;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
