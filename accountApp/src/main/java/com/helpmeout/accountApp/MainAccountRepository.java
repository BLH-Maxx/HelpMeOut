package com.helpmeout.accountApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainAccountRepository extends JpaRepository<Mainaccount, Integer> {
	

}
