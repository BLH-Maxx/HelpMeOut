package com.helpmeout.creditApp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

<<<<<<< HEAD
@FeignClient(name = "accountApp", url = "localhost:8200")
=======

@FeignClient(name = "accountApp")
>>>>>>> refs/remotes/origin/master
public interface CreditAppAccountAppProxy {

	@PostMapping("/makingTransaction")
	public CreditPaymentBean makeTransaction(@RequestBody CreditPaymentBean mainaccount);
}
