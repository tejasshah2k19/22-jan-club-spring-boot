package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

//we need user dao object in controller -> so we mark this class as Repository so we get this automatically
	// autowired

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean user) {

		stmt.update("insert into users (firstname,email,password,role) values (?,?,?,?)", user.getFirstName(),
				user.getEmail(), user.getPassword(), user.getRole());
	}

}
