/*
 * Copyright (C), Acxiom Corporation  
 * FileName: User.java
 * Author:   chrzha
 * Date:     Apr 15, 2015 5:52:05 PM
 * Description: 
 * History: 
 * <author>      <time>      <version>    <desc>
 *
 */
package com.chrzha.social.entity;

/**
 * <Simple Functional Description><br> 
 * <Functional Description>
 *
 * @author chrzha
 * @see 
 * @since 
 */
public class User {

    private String userId;
    private String userName;
    private String password;
    private String email;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
