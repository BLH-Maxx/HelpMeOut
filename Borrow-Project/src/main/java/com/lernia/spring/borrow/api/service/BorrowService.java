package com.lernia.spring.borrow.api.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lernia.spring.borrow.api.controller.BorrowProjectBean;
import com.lernia.spring.borrow.api.controller.BorrowProjectCreditAppProxy;
import com.lernia.spring.borrow.api.model.Borrow;
import com.lernia.spring.borrow.api.repository.BorrowRepository;
import com.lernia.spring.borrow.api.model.Borrow.Status;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BorrowService {

	public BorrowService() {
		super();
	}

	@Autowired
	private BorrowRepository borrowRepository;
	
	@Autowired
	BorrowProjectCreditAppProxy bpcap;

	public List<Borrow> showAllborrows() {
		List<Borrow> borrows = new ArrayList<Borrow>();
		borrows = borrowRepository.findAll();
		return borrows;
	}

	public List<Borrow> showAllApproved() {
		List<Borrow> borrows = new ArrayList<Borrow>();
		borrows = borrowRepository.findAllByStatus("APPROVED");
		return borrows;
	}

	public List<Borrow> showAllRejected() {
		List<Borrow> borrows = new ArrayList<Borrow>();
		borrows = borrowRepository.findAllByStatus("REJECTED");
		return borrows;
	}

	public List<Borrow> showAllPendings() {
		List<Borrow> borrows = new ArrayList<Borrow>();
		borrows = borrowRepository.findAllByStatus("PENDING");
		return borrows;
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();

	}

	public Borrow saveMyborrowRequest(Borrow borrow) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		borrow.setUserName(getUserIdFromPrinciple());
		borrow.setEligible(true);
		borrow.setRequestedDate(LocalDate.now());
		borrow.setRequestedTime(Instant.now());
		borrow.setStatus(Status.PENDING.toString());
		borrow.setRemainingAmount(borrow.getRequestedAmount());
		borrow.setLenderOneId(0);
		borrow.setLenderTwoId(0);
		borrow.setLenderThreeId(0);
		borrow.setLenderFourId(0);
		borrow.setLenderFiveId(0);
		borrow.setNumberOfLenders(0);
		System.out.println(borrow.toString());
		System.out.println("DTF === " + dtf);
		System.out.println("NOW === " + now);
		borrowRepository.save(borrow);
		return borrow;
	}

	public String getUserIdFromPrinciple() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		String name = auth.getName();
		return name;
	}

	public Borrow getBorrowByID(long id) {
		return borrowRepository.findById((int) id).orElseThrow(() -> new EntityNotFoundException("id"));

	}

	public String doLend(int id) {

		Borrow borrow = borrowRepository.findAllByborrow_id(id);
		if (borrow.getNumberOfLenders() == 5) {
			return "redirect:my-dashboard";
		}

		int section = borrow.getRequestedAmount() / 5;
		borrow.setRemainingAmount(borrow.getRemainingAmount() - section);
		int lender1 = borrow.getLenderOneId();
		int lender2 = borrow.getLenderTwoId();
		int lender3 = borrow.getLenderThreeId();
		int lender4 = borrow.getLenderFourId();
		int lender5 = borrow.getLenderFiveId();

		if (lender1 == 0) {
			borrow.setLenderOneId(borrow.getUserId());
			borrow.setNumberOfLenders(borrow.getNumberOfLenders() + 1);
		} else if (lender2 == 0) {
			borrow.setLenderTwoId(borrow.getUserId());
			borrow.setNumberOfLenders(borrow.getNumberOfLenders() + 1);
		} else if (lender3 == 0) {
			borrow.setLenderThreeId(borrow.getUserId());
			borrow.setNumberOfLenders(borrow.getNumberOfLenders() + 1);
		} else if (lender4 == 0) {
			borrow.setLenderFourId(borrow.getUserId());
			borrow.setNumberOfLenders(borrow.getNumberOfLenders() + 1);
		} else if (lender5 == 0) {
			borrow.setLenderFiveId(borrow.getUserId());
			borrow.setNumberOfLenders(borrow.getNumberOfLenders() + 1);
		}

		// Check with MAX

		BorrowProjectBean bpb = new BorrowProjectBean();

		bpb.setInicial_amount(Double.parseDouble(String.valueOf(borrow.getRequestedAmount())));
		bpb.setCurrent_amount(Double.parseDouble(String.valueOf(borrow.getRequestedAmount()))); // Ghaiath
		bpb.setInterest_rate(30.00);
		bpb.setNumber_of_payments_left(borrow.getPeriod());
		bpb.setRequest_id(borrow.getBorrowId());
		bpb.setUserId(borrow.getUserId());
		System.out.println("USERID =====" + borrow.getUserId());
		bpb.setNumberOfLenders(0);
		bpb.setLenderOne(borrow.getLenderOneId());
		bpb.setLenderTwo(borrow.getLenderTwoId());
		bpb.setLenderThree(borrow.getLenderThreeId());
		bpb.setLenderFour(borrow.getLenderFourId());
		bpb.setLenderFive(borrow.getLenderFiveId());
		bpb.setNext_payment(borrow.getRequestedAmount() / 5.00);
		bpb.setNumberOfLenders(borrow.getNumberOfLenders());
		System.out.println(bpb);

		bpcap.makeACredit(bpb);

		return "redirect:my-dashboard";
	}
}
