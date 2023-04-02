package com.usermanagement.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagement.dao.UserDao;
import com.usermanagement.model.User;

@WebServlet("/signin")
public class SigInServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		 
		ServletContext contxt =  getServletContext();
		  String jdbcUrl = contxt.getInitParameter("dburl");
		   String dbUsername= contxt.getInitParameter("dbuser");
		   String dbpasword= contxt.getInitParameter("dbpwd");
		
		  UserDao dao =  new UserDao(jdbcUrl,dbUsername,dbpasword);
		 
		  Integer uid =  Integer.parseInt(request.getParameter("uid"));
		  String uname = request.getParameter("uname");
		  String pwd = request.getParameter("pwd");
		  
		  User u = new User();
		  
		  u.setUserId(uid);
		  u.setUsername(uname);
		  u.setPassword(pwd);
	try {
		dao.createUser(u);
		response.sendRedirect("home.jsp");
	} catch (SQLException e) {
		out.print("<h1 style=\"color:red\">Some Error Check Console</h1>");
		e.printStackTrace();
	}	  
		
	}

}
