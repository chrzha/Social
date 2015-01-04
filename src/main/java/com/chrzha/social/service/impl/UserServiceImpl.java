package com.chrzha.social.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chrzha.social.dao.UserDao;
import com.chrzha.social.entity.User;
import com.chrzha.social.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		
		return userDao.getUsers();
	}

	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.saveUser(user);
	}

}
