package com.helpmeout.depositeMoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class depositeMoneyController {
	
	@GetMapping("/")
	public String depositeMoney(Model model) {
		
		
		return "depositeMoney.html";
	}


}
