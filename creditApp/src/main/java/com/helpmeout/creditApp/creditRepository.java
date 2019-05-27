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
	@Query(value = "UPDATE credit \r\n" + 
			"SET \r\n" + 
			"    current_amount = ?1\r\n" + 
			"WHERE\r\n" + 
			"    credit_id = ?2", nativeQuery = true)
	public String putNewBalanceInCredit(double amountToPay, Integer integer);
	

}
