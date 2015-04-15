/*
 * Copyright (C), Acxiom Corporation  
 * FileName: UserMapper.java
 * Author:   chrzha
 * Date:     Apr 15, 2015 5:53:39 PM
 * Description: 
 * History: 
 * <author>      <time>      <version>    <desc>
 *
 */
package com.chrzha.social.mapper;

import com.chrzha.social.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * <Simple Functional Description><br> 
 * <Functional Description>
 *
 * @author chrzha
 * @see 
 * @since 
 */
public interface UserMapper {

    public User getUserByUserName(@Param("userName")String userName); 
    public List<User> getUsers(); 
    public Integer insertUser(User user); 
    public void deleteUserByUserId(@Param("userId")String userId);
}
