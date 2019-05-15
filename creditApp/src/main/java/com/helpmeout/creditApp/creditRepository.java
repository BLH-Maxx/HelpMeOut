package com.helpmeout.creditApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface creditRepository extends JpaRepository<Credit, Integer> {

	public List<Credit> findAllByUserId(Integer userId);
	public List<Credit> findLenderOneByCreditId(Integer creditId);

}
