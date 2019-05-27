package com.helpmeout.creditApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients("com.helpmeout.creditApp")
@EnableDiscoveryClient
@EnableTransactionManagement
public class CreditAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditAppApplication.class, args);
	}

}
