package com.chrzha.social.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrzha.social.mapper.UserVersionMapper;
import com.chrzha.social.service.UserVersionService;

@Service
public class UserVersionServiceImpl implements UserVersionService {

	@Autowired
	private UserVersionMapper userVersionMapper;

	@Override
	public void insertLink(String userId, String version) {
		// TODO Auto-generated method stub
		userVersionMapper.insertLink(userId, version);
	}

}
