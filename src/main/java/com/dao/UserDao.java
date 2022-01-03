package com.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

//we need user dao object in controller -> so we mark this class as Repository so we get this automatically
	// autowired

	@Autowired
	JdbcTemplate stmt;

	public long addUser(UserBean user) {

		long userId=-1;
		KeyHolder holder=new GeneratedKeyHolder();
		   stmt.update(connection -> {
		        PreparedStatement ps = connection
		          .prepareStatement("insert into users (firstname,email,password,role) values (?,?,?,?)");
		          ps.setString(1, user.getFirstName());
		          ps.setString(2, user.getEmail());
		          ps.setString(3, user.getPassword());
		          ps.setInt(4, user.getRole());
		          return ps;
		        }, holder);

		        userId= (long) holder.getKey();
		    	return userId;
		    }
//		stmt.update("insert into users (firstname,email,password,role) values (?,?,?,?)", user.getFirstName(),
//				user.getEmail(), user.getPassword(), user.getRole());
	



	public List<UserBean> getAllUsers() {
		return stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));

		// UserBean -> userId --> db -> userId

	}

	public void deleteUser(int userId) {
		stmt.update("delete from users where userid = ?", userId);
	}

	
}
