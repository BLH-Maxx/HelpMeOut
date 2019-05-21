package com.helpmeout.depositeMoney;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class depositeMoneyController {
	
	@Autowired
	private AccountAppProxy proxy;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	Date date = new Date();
	
	@GetMapping("/makeadeposit")
	public String depositeMoney(Model model) {
		
		 model.addAttribute("depositeMoneyBean", new DepositeMoneyBean());
		
		return "depositeMoney";
	}
	
	@GetMapping("/thanksfordeposite")
	public String thanksForDeposite(Model model) {
		return "thanksfordeposite";
	}
	
	@PostMapping("/makeadeposit")
	public String makeADeposite(@ModelAttribute DepositeMoneyBean depositeMoneyBean) {
		
		depositeMoneyBean.setTransaction_user_id(1);
		depositeMoneyBean.setTransaction_type("Deposite");
		depositeMoneyBean.setCredit_id(null);
		depositeMoneyBean.setTransaction_date(date);
		depositeMoneyBean.setEnd_user_money(1);
		depositeMoneyBean.setCurrent_amount(null);
		
		
		
		proxy.makeTransaction(depositeMoneyBean);
	
		

		
		return "redirect:/thanksfordeposite";
	}


}
