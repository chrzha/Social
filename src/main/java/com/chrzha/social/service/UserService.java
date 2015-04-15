/*
 * Copyright (C), Acxiom Corporation  
 * FileName: UserService.java
 * Author:   chrzha
 * Date:     Apr 15, 2015 5:56:53 PM
 * Description: 
 * History: 
 * <author>      <time>      <version>    <desc>
 *
 */
package com.chrzha.social.service;

import com.chrzha.social.entity.User;

import java.util.List;

/**
 * <Simple Functional Description><br> 
 * <Functional Description>
 *
 * @author chrzha
 * @see 
 * @since 
 */
public interface UserService {

    public User getUserByUserName(String userName); 
    public List<User> getUsers(); 
    public Integer insertUser(User user); 
    public void deleteUserByUserId(String userId);
}
