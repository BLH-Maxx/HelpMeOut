package com.lernia.spring.registration.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RegistrationLoginProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginProject2Application.class, args);
	}

}
