package com.helpmeout.accountApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountAppRestController {
	
	@Autowired
	private MainAccountRepository ma;
	
	@GetMapping("/all")
	public List<Mainaccount> showAllTransactions(){
		return ma.findAll();
		
				
	}

}
