package com.lernia.spring.borrow.api.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AccountApp", url = "localhost:8200")
public interface BorrowProjectAccountAppProxy {

	@GetMapping("/balance/{id}")
		public String showAccountBalance(@PathVariable String id);

}
