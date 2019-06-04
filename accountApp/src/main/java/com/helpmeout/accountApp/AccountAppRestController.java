package com.helpmeout.accountApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountAppRestController {

	@Autowired
	private MainAccountRepository ma;

	@GetMapping("/all")
	public List<Mainaccount> showAllTransactions() {
		return ma.findAll();
	}

	@PostMapping("/makingTransaction")
	public Mainaccount makeTransaction(@RequestBody Mainaccount mainaccount) {

		ma.save(mainaccount);
		return mainaccount;
	}

	@GetMapping("/balance/{id}")
	public String showAccountBalance(@PathVariable String id) {
		return ma.findBalanceFromEndUserMoney(id);
	}
}
