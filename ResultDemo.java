import java.sql.*;

import java.io.*;

public class ResultDemo{
	
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		
		// Registering the Driver

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Register Successfull");
		
		//Getting the Connection from DB Driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		System.out.println("Connection Successfull");
	
		// creating the Statement Object
		Statement st = con.createStatement();
		
		System.out.println("Statement Object Created");
		
		String sql  = "select * from student";

		
		ResultSet rs = st.executeQuery(sql);

		while(rs.next()){
			 int roll = rs.getInt("roll");
			 String name = rs.getString("name");
			 String addr = rs.getString("address");
			 System.out.println("roll :: "+ roll + " == name :: "+ name+ " == address :: "+ addr);
		}
		

		// Close the Connection
		con.close();

	}
	
	
	
}