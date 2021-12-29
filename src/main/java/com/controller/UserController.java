package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class UserController {

	// REST
	// user->product
	// create new --> POST -> /product /user
	// modify --> PUT -> /product /user
	// remove --> DELETE /product/productId /user/userId
	// read -> single - >GET /product/productId
	// read ->multi -> GET /products /product

	@Autowired // same as spring web
	UserDao userDao;

//	@PostMapping("/signup")
//	public ResponseEntity<UserBean> addUser(UserBean user) {
//
//		user.setRole(1);// 1 -> user ,2->admin
//		userDao.addUser(user);
//		return new ResponseEntity<UserBean>(user,HttpStatus.OK);
//	}

	@PostMapping("/signup")
	public ResponseBean<UserBean> addUser(UserBean user) {

		user.setRole(1);// 1 -> user ,2->admin
		userDao.addUser(user);

		ResponseBean<UserBean> rb = new ResponseBean<>();
		rb.setData(user);
		rb.setMsg("signup done");
		rb.setStatus(1);

		return rb;
	}

	// list all users
	@GetMapping("/users")
	public List<UserBean> getAllUsers() {
		return userDao.getAllUsers();
	}

	@DeleteMapping("/users/{userId}") // users/1
	public List<UserBean> deleteUser(@PathVariable("userId") int userId) {
		userDao.deleteUser(userId);
		return userDao.getAllUsers();
	}

	@DeleteMapping("/users2") // users/1
	public List<UserBean> deleteUser2(@RequestParam("userId") int userId) {
		userDao.deleteUser(userId);
		return userDao.getAllUsers();
	}
}
