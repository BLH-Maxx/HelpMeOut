package com.helpmeout.depositeMoney;

import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.stereotype.Repository;



@Repository
public interface depositRepository extends JpaRepository<EntityBean, Integer>{
	
	@Query(value = "SELECT user_id FROM registereduser WHERE personal_number = ?1", nativeQuery = true)
	public String getIdNumberByPersonNumber(String number);

}
