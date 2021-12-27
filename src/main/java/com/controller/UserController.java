package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class UserController {

	@Autowired // same as spring web
	UserDao userDao;

	@PostMapping("/signup")
	public UserBean addUser(UserBean user) {
		
		
		user.setRole(1);// 1 -> user ,2->admin
		userDao.addUser(user);
		return user;
	}

}
