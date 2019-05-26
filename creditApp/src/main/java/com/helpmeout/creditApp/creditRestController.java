package com.helpmeout.creditApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class creditRestController {

	@Autowired
	private creditRepository credit;

	@GetMapping("/all")
	public List<Credit> showAllCredits() {

		return credit.findAll();

	}

	@PostMapping("/makecreditform")
	public Credit makeACredit(@RequestBody Credit makeCredit) {

		credit.save(makeCredit);

		return makeCredit;

	}

}
