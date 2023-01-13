package com.autentication.autentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AutenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutenticationApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("teste"));
	}

}
