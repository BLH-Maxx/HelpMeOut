package com.helpmeout.accountApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients("com.helpmeout.accountApp")
@EnableDiscoveryClient
public class AccountAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountAppApplication.class, args);
	}
}
