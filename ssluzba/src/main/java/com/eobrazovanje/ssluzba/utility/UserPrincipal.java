package com.eobrazovanje.ssluzba.utility;


import com.eobrazovanje.ssluzba.entities.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
    private Long id;


    private String username;
    
    private String firstname;
    
    private String lastname;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String firstname, String lastname, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
       
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Person person) {
        List<GrantedAuthority> authorities = person.getRoles().stream().map(authority ->
                new SimpleGrantedAuthority(authority.getName())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getUsername(),                     
                person.getPassword(),
                authorities
        );
    }


    public Long getId() {
        return id;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
    
    

    public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
