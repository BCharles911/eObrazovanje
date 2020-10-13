package com.eobrazovanje.ssluzba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


//Da odbacimo auto-konfiguraciju i dodamo nasu sopstveno
// moramo da iskljucimo SecurityAutoConfiguration klasu
@EnableAsync
@ComponentScan
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EntityScan(basePackages = "com.eobrazovanje.ssluzba")
public class SsluzbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsluzbaApplication.class, args);
	}

}
