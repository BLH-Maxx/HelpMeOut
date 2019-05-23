package com.lernia.spring.borrow.api.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lernia.spring.borrow.api.model.Borrow;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BorrowRepositoryTest {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BorrowRepository borrowRepository;

	@Test
	@Transactional
	public void testSaveBorrow() {

		Borrow savedInDb = entityManager.merge(getBorrow());
		Borrow getFromDb = borrowRepository.findById((int) savedInDb.getBorrowId())
				.orElseThrow(() -> new EntityNotFoundException("id"));

		assertThat(getFromDb).isEqualTo(getFromDb);

	}

	private Borrow getBorrow() {
		Borrow borrow = new Borrow();
		borrow.setBorrowId(1);
		borrow.setUserId(0);
		borrow.setUserName("ghaiath");
		borrow.setRequestedAmount(1000);
		borrow.setPeriod(21);
		borrow.setRequestedDate(LocalDate.of(2019, 5, 9));
		borrow.setRequestedTime(Instant.parse("2019-05-09T21:34:00Z"));
		borrow.setEligible(true);
		borrow.setReason("Samer Alward");
		borrow.setStatus("APPROVED");
		return borrow;
	}
	@Test
	public void testGetAllBorrows() {

		Borrow borrow1 = new Borrow();
		borrow1.setBorrowId(1);
		borrow1.setUserId(0);
		borrow1.setUserName("ghaiath");
		borrow1.setRequestedAmount(1000);
		borrow1.setPeriod(21);
		borrow1.setRequestedDate(LocalDate.of(2019, 5, 9));
		borrow1.setRequestedTime(Instant.parse("2019-05-09T21:34:00Z"));
		borrow1.setEligible(true);
		borrow1.setReason("Samer Alward");
		borrow1.setStatus("APPROVED");

		Borrow borrow2 = new Borrow();
		borrow2.setBorrowId(2);
		borrow2.setUserId(5);
		borrow2.setUserName("ghaiath55");
		borrow2.setRequestedAmount(1000);
		borrow2.setPeriod(21);
		borrow2.setRequestedDate(LocalDate.of(2019, 5, 9));
		borrow2.setRequestedTime(Instant.parse("2019-05-09T21:34:00Z"));
		borrow2.setEligible(true);
		borrow2.setReason("Samer Alward");
		borrow2.setStatus("APPROVED");

		entityManager.merge(borrow1);
		entityManager.merge(borrow2);

		Iterable<Borrow> allBorrowFromDb = borrowRepository.findAll();
		List<Borrow> borrowList = new ArrayList<>();

		for (Borrow borrow : allBorrowFromDb) {
			borrowList.add(borrow);
		}
		assertThat(borrowList.size()).isEqualTo(2);
	}

}