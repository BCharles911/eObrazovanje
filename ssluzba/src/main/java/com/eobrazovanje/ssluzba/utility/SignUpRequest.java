package com.eobrazovanje.ssluzba.utility;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.*;


public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String firstname;
    
    @NotBlank
    @Size(min = 4, max = 40)
    private String lastname;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    
    private Set<String> role;

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public Set<String>  getAuthority() {
    	return role;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
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
