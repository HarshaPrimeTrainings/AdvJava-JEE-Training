package com.usermanagement.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagement.dao.UserDao;
import com.usermanagement.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		ServletContext contxt = getServletContext();
		String jdbcUrl = contxt.getInitParameter("dburl");
		String dbUsername = contxt.getInitParameter("dbuser");
		String dbpasword = contxt.getInitParameter("dbpwd");

		UserDao dao = new UserDao(jdbcUrl, dbUsername, dbpasword);

		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");

		try {
			User user = dao.getUser(uname);
			if (user.getUsername().equalsIgnoreCase(uname) && user.getPassword().equalsIgnoreCase(pwd)) {
				
				out.println("<h1 style=\"color:green\">Login Success</h1>");
				
				}else{
					out.print("<h1 style=\"color:red\">Login Failed</h1>");
				}
		} catch (SQLException e) {
			out.print("<h1 style=\"color:red\">Some Error Check Console</h1>");
			e.printStackTrace();
		}

	}
}
