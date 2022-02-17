package com.ruralworker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruralworker.model.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

} 
