package com.helpmeout.accountApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======



>>>>>>> refs/remotes/origin/master
@Repository
public interface MainAccountRepository extends JpaRepository<Mainaccount, Integer> {

	@Query(value = "SELECT SUM(amount) FROM mainaccount WHERE end_user_money = ?1", nativeQuery = true)
	public String findBalanceFromEndUserMoney(String id);
<<<<<<< HEAD
=======
	
	@Query(value = "SELECT * FROM mainaccount WHERE end_user_money = ?1", nativeQuery = true)
	public List<Mainaccount> findAllByEndUserMoney(Integer endUserMoney);
	
>>>>>>> refs/remotes/origin/master

}
