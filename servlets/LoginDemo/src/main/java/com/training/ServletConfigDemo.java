package com.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		 ServletConfig config = getServletConfig();
		 String param = config.getInitParameter("msg");
		 
		  String temp = config.getInitParameter("temp");
		 
		 
		 out.println("<h1>"+param + ":: " + temp +"</h1>");
	
	}
	
}
