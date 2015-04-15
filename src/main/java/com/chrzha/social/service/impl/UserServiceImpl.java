/*
 * Copyright (C), Acxiom Corporation  
 * FileName: UserServiceImpl.java
 * Author:   chrzha
 * Date:     Apr 15, 2015 5:57:27 PM
 * Description: 
 * History: 
 * <author>      <time>      <version>    <desc>
 *
 */
package com.chrzha.social.service.impl;

import com.chrzha.social.entity.User;
import com.chrzha.social.mapper.UserMapper;
import com.chrzha.social.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <Simple Functional Description><br> 
 * <Functional Description>
 *
 * @author chrzha
 * @see 
 * @since 
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    /* (non-Javadoc)
     * @see com.chrzha.social.service.UserService#getUserByUserName(java.lang.String)
     */
    @Override
    public User getUserByUserName(String userName) {
        // TODO Auto-generated method stub
        return userMapper.getUserByUserName(userName);
    }

    /* (non-Javadoc)
     * @see com.chrzha.social.service.UserService#getUsers()
     */
    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return userMapper.getUsers();
    }

    /* (non-Javadoc)
     * @see com.chrzha.social.service.UserService#insertUser(com.chrzha.social.entity.User)
     */
    @Override
    public Integer insertUser(User user) {
        // TODO Auto-generated method stub
        return  userMapper.insertUser(user);
    }

    /* (non-Javadoc)
     * @see com.chrzha.social.service.UserService#deleteUserByUserId(java.lang.String)
     */
    @Override
    public void deleteUserByUserId(String userId) {
        // TODO Auto-generated method stub
        userMapper.deleteUserByUserId(userId);
    }

}
