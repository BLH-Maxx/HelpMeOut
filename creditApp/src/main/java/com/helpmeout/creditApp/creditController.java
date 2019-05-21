package com.helpmeout.creditApp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class creditController {
	
	@Autowired
	private creditRepository credit;
	
	@Autowired
	private CreditAppAccountAppProxy proxy;
	
	Date date = new Date();
	
	//this will contain users id for use
	private int theUserId = 1;
	
	@GetMapping("/mycredit")
	public String index(Model model) {
		
		
		List<Credit> findAllByUserId = credit.findAllByUserId(theUserId);
		
		
		
		model.addAttribute("currentCredits", credit.findAllByUserId(theUserId));
		model.addAttribute("try", findAllByUserId.get(0).getInterest_rate());
		
		System.out.println(findAllByUserId);
		
		return "creditIndex.html";
	}
	
	@PostMapping("/mycredit/{id}")
	public String makeAPayment(@PathVariable String id, @ModelAttribute CreditPaymentBean cpb) {
		
		Optional<Credit> loan = credit.findById(Integer.parseInt(id));
		
		cpb.setAmount("123");
		cpb.setCredit_id(loan.get().getCredit_id());
		cpb.setEnd_user_money(loan.get().getLender_one());
		cpb.setTransaction_date(date);
		cpb.setTransaction_user_id(loan.get().getUser_id());
		cpb.setTransaction_type("Deposite");
		
		proxy.makeTransaction(cpb);
		return "redirect:/thanksfordeposite";
	}

}
