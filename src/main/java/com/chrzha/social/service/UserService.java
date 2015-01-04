package com.chrzha.social.service;

import java.util.List;

import com.chrzha.social.entity.User;

public interface UserService {

	public List<User> getUsers();
	public Integer saveUser(User user);
}
