package com.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.usermanagement.model.User;

public class UserDao {
	Connection con = null;
	String jdbcUrl;
	String dbUsername;
	String dbpasword;
	
	public UserDao(String jdbcUrl, String dbUsername, String dbpasword) {
		this.jdbcUrl = jdbcUrl;
		this.dbUsername = dbUsername;
		this.dbpasword = dbpasword;
	}



	private Connection dbConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcUrl, dbUsername, dbpasword);
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}
	
	
	
	public boolean createUser(User u) throws SQLException {
		  con = dbConnection();
		if(con!=null) {
			 PreparedStatement preparestmt = con.prepareStatement("insert into users values(?,?,?)");
			 preparestmt.setInt(1, u.getUserId());
			 preparestmt.setString(2, u.getUsername());
			 preparestmt.setString(3, u.getPassword());
			 return preparestmt.execute();
		}
		return false;
	}
	
	
	public User getUser(String username) throws SQLException {
		  con = dbConnection();
		User u = new User();
		if(con!=null) {
			PreparedStatement preparestmt = con.prepareStatement("select * from users where username = ?");
			 preparestmt.setString(1, username);
			 
			  ResultSet rs = preparestmt.executeQuery();
			  if(rs.next()) {
				  u.setUserId(rs.getInt("userId"));
				  u.setUsername(rs.getString("username"));
				  u.setPassword(rs.getString("password"));
			  }
		}
		return u;
	}

}
