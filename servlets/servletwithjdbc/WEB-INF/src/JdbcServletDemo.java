import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet("/jdbcdemo")
public class JdbcServletDemo extends  HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		// character Stream
		PrintWriter out = resp.getWriter();
		Connection con = null;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		Statement st = con.createStatement();
		
		String sql  = "select * from student";
		
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