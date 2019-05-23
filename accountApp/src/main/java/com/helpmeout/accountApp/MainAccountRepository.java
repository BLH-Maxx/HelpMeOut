package com.helpmeout.accountApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface MainAccountRepository extends JpaRepository<Mainaccount, Integer> {
	
	
	@Query(value = "SELECT SUM(amount) FROM mainaccount WHERE end_user_money = ?1", nativeQuery = true)
	public String findBalanceFromEndUserMoney(String id);
	

}
