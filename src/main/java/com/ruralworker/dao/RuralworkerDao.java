package com.ruralworker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ruralworker.model.RuralworkerDetails;

@Repository
public interface RuralworkerDao extends JpaRepository<RuralworkerDetails, Integer> {

	@Query(value = "SELECT * FROM ruralworker_details WHERE status='unvarified'", nativeQuery = true)
	List<RuralworkerDetails> findUnVarifiedList();
	
	@Query(value = "SELECT * FROM ruralworker_details WHERE status='varified'", nativeQuery = true)
	List<RuralworkerDetails> findVarifiedList();

}
