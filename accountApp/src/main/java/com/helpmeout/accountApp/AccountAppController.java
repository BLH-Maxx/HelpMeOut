package com.helpmeout.accountApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AccountAppController {
	
	@Autowired
	private MainAccountRepository mainAccount;
	
	
	@GetMapping("/mystatement")
	public String index(Model model) {

		String findBalanceFromEndUserMoney = mainAccount.findBalanceFromEndUserMoney("1");
		model.addAttribute("balance", findBalanceFromEndUserMoney);



		return "balanceandstatement";
	}

}
