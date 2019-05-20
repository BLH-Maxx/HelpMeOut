package com.lernia.spring.borrow.api.service;



import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lernia.spring.borrow.api.model.Borrow;
import com.lernia.spring.borrow.api.repository.BorrowRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BorrowServiceTest {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private BorrowService borrowService;
	
	@MockBean
	private BorrowRepository borrowRepository;

	@Test
	public void testSaveMyborrowRequest() {

		Borrow borrow = new Borrow();
		borrow.setBorrowId(25);
		borrow.setUserId(125);
		borrow.setUserName("ghaiath");
		borrow.setRequestedAmount(1000);
		borrow.setPeriod(21);
		borrow.setRequestedDate(LocalDate.of(2019, 5, 9));
		borrow.setRequestedTime(Instant.parse("2019-05-09T21:34:00Z"));
		borrow.setEligible(true);
		borrow.setReason("Samer Alward");
		borrow.setStatus("APPROVED");

		Mockito.when(borrowRepository.save(borrow)).thenReturn(borrow);
		assertThat(borrowService.saveMyborrowRequest(borrow)).isEqualTo(borrow);
	}

}