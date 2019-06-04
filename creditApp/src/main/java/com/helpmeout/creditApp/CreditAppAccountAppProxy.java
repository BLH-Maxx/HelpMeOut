package com.helpmeout.creditApp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "accountApp", url = "localhost:8200")
public interface CreditAppAccountAppProxy {

	@PostMapping("/makingTransaction")
	public CreditPaymentBean makeTransaction(@RequestBody CreditPaymentBean mainaccount);
}
