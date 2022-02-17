package com.ruralworker.implService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruralworker.dao.UserDao;
import com.ruralworker.model.User;
import com.ruralworker.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User registerUser(User user) {
		return userDao.save(user);
	}

}
