package com.helpmeout.depositeMoney;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class depositRestController {
	
	@Autowired
	private depositRepository dr;
	
	
	@GetMapping("/userbyperson")
	public String getUserIdByPerson(String number) {
		
		return dr.getIdNumberByPersonNumber(number);
		
	}

}
