package com.helpmeout.creditApp;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class creditController {

	@Autowired
	private creditRepository credit;

	@Autowired
	private CreditAppAccountAppProxy proxy;
	
	

	Date date = new Date();

	// this will contain users id for use
	private int theUserId = 1;

	@GetMapping("/mycredit")
	public String index(Model model) {

		
		List<Credit> findAllByUserId = credit.findAllByUserId(theUserId);


		/*
		// See here if it's better??
		for (Credit credit : findAllByUserId) {
			BigDecimal current_amount = credit.getCurrent_amount();
			Double doubleAmountToPay;

			if (current_amount != BigDecimal.ZERO) {
				doubleAmountToPay = current_amount.doubleValue();
				double amountToPay = amountToPay(doubleAmountToPay, credit.getInterest_rate(),
						credit.getNumber_of_payments_left());

				credit.setNext_payment(amountToPay);
			} else {
				doubleAmountToPay = 0.00;
				credit.setNext_payment(doubleAmountToPay);
			}

			
		}*/



		for (int i = 0; i < findAllByUserId.size(); i++) {

			String current_amount = String.valueOf(findAllByUserId.get(i).getCurrent_amount());
			Double doubleAmountToPay;

			if (current_amount != "null") {
				doubleAmountToPay = Double.parseDouble(current_amount);
			} else {
				doubleAmountToPay = 0.00;
			}

			double amountToPay = amountToPay(doubleAmountToPay, findAllByUserId.get(i).getInterest_rate(),
					findAllByUserId.get(i).getNumber_of_payments_left());

			findAllByUserId.get(i).setNext_payment(amountToPay);

			
		}

		
		model.addAttribute("currentCredits", findAllByUserId);
		model.addAttribute("try", findAllByUserId.get(0).getInterest_rate());


		return "creditIndex";
	}

	@PostMapping("/mycredit/{id}")
	public String makeAPayment(@PathVariable String id, @ModelAttribute CreditPaymentBean cpb) {

		Optional<Credit> loan = credit.findById(Integer.parseInt(id));

		String current_amount = String.valueOf(loan.get().getCurrent_amount());
		Double doubleAmountToPay;

		if (current_amount != "null") {
			doubleAmountToPay = Double.parseDouble(current_amount);
		} else {
			doubleAmountToPay = 0.00;
		}

		double amountToPay = amountToPay(doubleAmountToPay, loan.get().getInterest_rate(),
				loan.get().getNumber_of_payments_left());

		cpb.setAmount(String.valueOf(amountToPay / 5));
		cpb.setCredit_id(loan.get().getCreditId());
		cpb.setEnd_user_money(loan.get().getLenderOne());
		cpb.setTransaction_date(date);
		cpb.setTransaction_user_id(loan.get().getUserId());
		cpb.setTransaction_type("Deposite");

		proxy.makeTransaction(cpb);

		cpb.setEnd_user_money(loan.get().getLenderTwo());

		proxy.makeTransaction(cpb);

		cpb.setEnd_user_money(loan.get().getLenderThree());

		proxy.makeTransaction(cpb);

		cpb.setEnd_user_money(loan.get().getLenderFour());

		proxy.makeTransaction(cpb);

		cpb.setEnd_user_money(loan.get().getLenderFive());

		proxy.makeTransaction(cpb);

		cpb.setEnd_user_money(loan.get().getUserId());
		cpb.setTransaction_type("Withdraw");
		cpb.setAmount(String.valueOf(amountToPay * -1));
		proxy.makeTransaction(cpb);
		
		
		credit.putNewBalanceInCredit(amountToPay, cpb.getCredit_id());
		

		return "redirect:/thanksforpayment";
	}

	public double amountToPay(Double amountLeft, Double interestRate, Integer paymentsLeft) {

		Double exponent = Math.pow((1 + ((interestRate / 12) / 100)), paymentsLeft) - 1;

		Double result = ((amountLeft * ((interestRate / 12) / 100)) / exponent)
				+ (amountLeft * ((interestRate / 12) / 100));

		return result;

	}
	
	@GetMapping("/thanksforpayment")
	public String thanksForPayment(Model model) {
		return "thanksfordeposite";
	}

}
