package com.helpmeout.depositeMoney;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "accountApp", url="localhost:8200")
public interface AccountAppProxy {
	
	@PostMapping("/makingTransaction")
	public DepositeMoneyBean makeTransaction(@RequestBody DepositeMoneyBean mainaccount);
		

}
