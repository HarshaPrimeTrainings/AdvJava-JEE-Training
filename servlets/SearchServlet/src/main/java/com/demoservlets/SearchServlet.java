package com.demoservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		 String studentid = req.getParameter("stid");
		 
	// character Stream
			PrintWriter out = resp.getWriter();
			out.println("<h1>"+req.getParameter("sname")+"</h1>");
			Connection con = null;
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
			Statement st = con.createStatement();
			int id = Integer.parseInt(studentid);
			String sql  = "select * from student where roll = "+id;
			
			ResultSet rs = st.executeQuery(sql);
			
			out.println("<table style="+"border 1px solid"+">");
			out.println("<tr>");
			out.println("<th>RollNumber</th>");
			out.println("<th>Name</th>");
			out.println("<th>Adress</th>");
			out.println("</tr>");
			while(rs.next()){
				 int roll = rs.getInt("roll");
				 String name = rs.getString("name");
				 String addr = rs.getString("address");
				 out.println("<tr>");
				 out.println("<td>"); 
				 out.println(roll);
				 out.println("</td>");
				  out.println("<td>");
				out.println(name);
				  out.println("</td>");
				   out.println("<td>");
					out.println(addr);
				   out.println("</td>"); 
				 out.println("</tr>");
			}	
			out.println("<table>");
		}catch( ClassNotFoundException | SQLException ex){
			ex.printStackTrace();
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
