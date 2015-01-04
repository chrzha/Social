package com.chrzha.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chrzha.social.entity.Role;
import com.chrzha.social.entity.User;
import com.chrzha.social.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/getAll")
	public String getUsers() {

		List<User> list = userService.getUsers();

		for(User user :list){
			System.out.println(user.toString());
		}
		return list.toString();
	}
	@RequestMapping("/save")
	public String saveUser() {
		 User user = new User();
		 user.setName("www");
		 user.setPassword("222");
		 user.setRole(new Role(1, null, null));
		 userService.saveUser(user);
		return user.toString();
	}
}
