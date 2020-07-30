package com.eobrazovanje.ssluzba.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws
		Exception{
		PasswordEncoder encoder =
				PasswordEncoderFactories.createDelegatingPasswordEncoder();
			auth
			.inMemoryAuthentication()
	          .withUser("student")
	          .password(encoder.encode("password"))
	          .roles("STUDENT")
	          .and()
	          .withUser("profesor")
	          .password(encoder.encode("password"))
	          .roles("PROFESOR")
	          .and()
	          .withUser("admin")
	          .password(encoder.encode("admin"))
	          .roles("STUDENT","PROFESOR", "ADMIN");
			
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/home").access("hasRole('STUDENT')")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and().formLogin()
		.loginPage("/login").permitAll()
		.and()
		.httpBasic();
	}
}
