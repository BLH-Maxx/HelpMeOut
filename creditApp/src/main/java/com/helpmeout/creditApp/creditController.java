package com.helpmeout.creditApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class creditController {
	
	@Autowired
	private creditRepository credit;
	
	//this will contain users id for use
	private int theUserId = 1;
	
	@GetMapping("/mycredit")
	public String index(Model model) {
		
		
		List<Credit> findAllByUserId = credit.findAllByUserId(theUserId);
		
		
		model.addAttribute("currentCredits", credit.findAllByUserId(theUserId));
		model.addAttribute("try", findAllByUserId.get(0).getInterest_rate());
		
		return "creditIndex.html";
	}
	

}
