package com.lernia.spring.registration.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.helpmeout.auth")
@EnableDiscoveryClient
public class RegistrationLoginProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginProject2Application.class, args);
	}
}
