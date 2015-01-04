package com.chrzha.social.dao;

import java.util.List;

import com.chrzha.social.entity.User;

public interface UserDao {

	public List<User> getUsers();
	
	public Integer saveUser(User user);
}
