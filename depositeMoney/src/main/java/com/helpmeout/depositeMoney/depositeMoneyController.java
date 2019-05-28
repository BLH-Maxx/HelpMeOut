package com.helpmeout.depositeMoney;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class depositeMoneyController {


	
	@Autowired
	private AccountAppProxy proxy;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private depositRepository dr;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	Date date = new Date();

	@GetMapping("/makeadeposit")
	public String depositeMoney(Model model) {
		
		System.out.println(environment.getProperty("local.server.port"));

		model.addAttribute("depositeMoneyBean", new DepositeMoneyBean());
		
	

		return "depositeMoney";
	}

	@GetMapping("/thanksfordeposite")
	public String thanksForDeposite(Model model) {
		return "thanksfordeposite";
	}

	@PostMapping("/makeadeposit")
	public String makeADeposite(@RequestParam ("personnumber") String number, @ModelAttribute DepositeMoneyBean depositeMoneyBean) {

		String idNumberByPersonNumber = dr.getIdNumberByPersonNumber(number);
		
		depositeMoneyBean.setTransaction_user_id(Integer.valueOf(idNumberByPersonNumber));
		depositeMoneyBean.setTransaction_type("Deposite");
		depositeMoneyBean.setCredit_id(null);
		depositeMoneyBean.setTransaction_date(date);
		depositeMoneyBean.setEnd_user_money(1);
		depositeMoneyBean.setCurrent_amount(null);

		proxy.makeTransaction(depositeMoneyBean);

		return "redirect:http://localhost:8765/transaction/thanksfordeposite";
	}

}
