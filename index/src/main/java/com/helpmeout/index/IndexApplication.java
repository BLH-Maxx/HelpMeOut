package com.helpmeout.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.helpmeout.index")
@EnableDiscoveryClient
public class IndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndexApplication.class, args);
	}

}
