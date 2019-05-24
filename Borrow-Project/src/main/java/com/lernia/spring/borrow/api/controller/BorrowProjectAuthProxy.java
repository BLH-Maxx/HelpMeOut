package com.lernia.spring.borrow.api.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "Auth-Project", url="localhost:8080")
public interface BorrowProjectAuthProxy {
	
	@GetMapping("/getsaldo")
	public String getSaldo();
	
	@GetMapping("/getAuth")
	public String getAuth();
	
}