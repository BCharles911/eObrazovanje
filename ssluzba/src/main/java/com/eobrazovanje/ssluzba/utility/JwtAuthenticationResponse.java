package com.eobrazovanje.ssluzba.utility;

import java.util.List;


public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private List<String> authorities;
    

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    
    

	public JwtAuthenticationResponse(String accessToken, String id, String username, String firstname,
			String lastname, List<String> authorities) {
		super();
		this.accessToken = accessToken;
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.authorities = authorities;
	}
	
	
	public JwtAuthenticationResponse() {
		super();
	}




	public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }




	public List<String> getAuthorities() {
		return authorities;
	}




	public String getId() {
		return id;
	}




	public String getUsername() {
		return username;
	}




	public String getFirstname() {
		return firstname;
	}




	public String getLastname() {
		return lastname;
	}
    
    
}
