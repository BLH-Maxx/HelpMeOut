package com.lernia.spring.borrow.api.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "creditApp", url="localhost:8300")
public interface BorrowProjectCreditAppProxy {
	
	@PostMapping("/makecreditform")
	public BorrowProjectBean makeACredit(@RequestBody BorrowProjectBean makeCredit);
	
}
