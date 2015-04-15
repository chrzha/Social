/*
 * Copyright (C), Acxiom Corporation  
 * FileName: UserController.java
 * Author:   chrzha
 * Date:     Apr 15, 2015 6:01:28 PM
 * Description: 
 * History: 
 * <author>      <time>      <version>    <desc>
 *
 */
package com.chrzha.social.controller;

import com.chrzha.social.entity.User;
import com.chrzha.social.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <Simple Functional Description><br> 
 * <Functional Description>
 *
 * @author chrzha
 * @see 
 * @since 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody User user) {
        return userService.insertUser(user)>0?"success":"error";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(@RequestBody User user) {
        User dbuser = new User();
        String result = "error";
        dbuser = userService.getUserByUserName(user.getUserName());
        if (dbuser!=null&&user.getPassword().equals(dbuser.getPassword())) {
            //login success
            result = "success";
        }
        return result;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@RequestParam()) {
        
    }
    
    
}
