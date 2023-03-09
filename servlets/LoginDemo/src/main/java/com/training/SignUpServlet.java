package com.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userName = request.getParameter("usr");
		 String password =request.getParameter("pwd");
		
		PrintWriter out = response.getWriter();
		ServletContext contxt =  getServletContext();
		  String jdbcUrl = contxt.getInitParameter("dburl");
		   String dbUsername= contxt.getInitParameter("dbuser");
		   String dbpasword= contxt.getInitParameter("dbpasword");
		  
			Connection con = null;
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcUrl,dbUsername,dbpasword);
		String sql  = "insert into users(username,password) values(?,?);";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, userName);
		st.setString(2, password);
		
		st.execute();
		out.println("<h1>User Created SUccesfully</h1>");
	}catch( ClassNotFoundException | SQLException ex){
		ex.printStackTrace();
		out.println("<h1>Unabel to Create </h1>");
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
