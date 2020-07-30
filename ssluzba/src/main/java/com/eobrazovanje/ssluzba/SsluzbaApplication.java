package com.eobrazovanje.ssluzba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//Da odbacimo auto-konfiguraciju i dodamo nasu sopstveno
// moramo da iskljucimo SecurityAutoConfiguration klasu
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SsluzbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsluzbaApplication.class, args);
	}

}
