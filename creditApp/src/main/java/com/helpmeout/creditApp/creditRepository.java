package com.helpmeout.creditApp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface creditRepository extends JpaRepository<Credit, Integer> {

	public List<Credit> findAllByUserId(Integer userId);
	public List<Credit> findLenderOneByCreditId(Integer creditId);
	public List<Credit> findAllByCreditId(Integer creditId);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE credit SET current_amount = ?1, number_of_payments_left = ?2 WHERE credit_id = ?3", nativeQuery = true)
	void putNewBalanceInCredit(double amountToPay,Integer paymentsLeft, Integer integer);
	
	

}
