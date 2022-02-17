package com.ruralworker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ruralworker.dao.UserDao;
import com.ruralworker.model.User;

public class IUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		User user = userDao.getUserByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Could not find user!");
		}
		return new IUserDetails(user);
	}

}
