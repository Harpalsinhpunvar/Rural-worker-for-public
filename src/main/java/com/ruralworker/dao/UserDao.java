package com.ruralworker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ruralworker.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM USERS WHERE USERNAME = :username", nativeQuery = true)
	public User getUserByUsername(@Param("username") String username);
}
