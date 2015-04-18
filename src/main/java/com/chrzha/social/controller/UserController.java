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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView addUser(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("email") String email) {
		User user= new User();
		ModelAndView mv = null;
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		if (userService.insertUser(user) > 0) {
			mv = new ModelAndView("success");
		}else {
			mv = new ModelAndView("redirect:/");
		}
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@RequestParam("userName") String userName,
			@RequestParam("password") String password,HttpServletRequest request) {
		User dbuser = new User();
		ModelAndView mv = null;
		dbuser = userService.getUserByUserName(userName);
		HttpSession session = request.getSession();
		if (dbuser != null && password.equals(dbuser.getPassword())) {
			// login success
			mv = new ModelAndView("main");
			session.setAttribute("user", dbuser);
		}else {
			mv = new ModelAndView("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView adminLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password,HttpServletRequest request) {
		User dbuser = new User();
		ModelAndView mv = null;
		dbuser = userService.getUserByUserName(userName);
		HttpSession session = request.getSession();
		 if(dbuser != null && password.equals(dbuser.getPassword())&&dbuser.getAdminFlag()==1){
			session.setAttribute("user", dbuser);
			mv = new ModelAndView("admin");
			mv.addObject("userList",userService.getUsers());
		}else {
			mv = new ModelAndView("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	@ResponseBody
	public ModelAndView logout(HttpServletRequest request) {
		User dbuser = new User();
		HttpSession session = request.getSession();
		session.invalidate();
		ModelAndView mv =  new ModelAndView("redirect:/");
		 
		return mv;
	}
	@RequestMapping(value = "/manage")
	@ResponseBody
	public ModelAndView manage(HttpServletRequest request) {
		List<User> userList = userService.getUsers();
		ModelAndView mv =  new ModelAndView("admin-login");
		return mv;
	}

	  @RequestMapping(value = "/delete")
	  @ResponseBody 
	  public ModelAndView deleteUser(@RequestParam("userid")String userId) {
	      userService.deleteUserByUserId(userId);
	      ModelAndView mv = new ModelAndView("admin");
	      mv.addObject("userList", userService.getUsers());
		  return mv;
	  }
	  

}
