package com.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String userName = req.getParameter("usr");
	  String password = req.getParameter("pwd");
	  PrintWriter out = resp.getWriter();
	
	 ServletContext contxt =  getServletContext();
	
	  String jdbcUrl = contxt.getInitParameter("dburl");
	   String dbUsername= contxt.getInitParameter("dbuser");
	   String dbpasword= contxt.getInitParameter("dbpasword");
	  
		Connection con = null;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(jdbcUrl,dbUsername,dbpasword);
		String sql  = "select * from users where username = ?;";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, userName);
		 ResultSet rs= st.executeQuery();
		  rs.next();
		  String dbUser = rs.getString("username");
		  String dbpassword = rs.getString("password");
		 if(dbUser.equals(userName) && dbpassword.equals(password)) {
			 out.println("<h1>Login Success Welcome "+ userName + "</h1>");
		 }else {
			 out.println("<h1>Login Failure check the username and password</h1>");
		 }
		
	}catch( ClassNotFoundException | SQLException ex){
		ex.printStackTrace();
		out.println("<h1>Unabel to retrieve user </h1>");
	}finally{
		try{
			if(con!=null){
				con.close();
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		out.close();
	}
		
	}
	
	
	

}
