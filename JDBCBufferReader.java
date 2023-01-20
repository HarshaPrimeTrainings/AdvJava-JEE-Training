import java.sql.*;

import java.io.*;

public class JDBCBufferReader{
	
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
		
		// Sending the SQL Query
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Student roll :: ");
		int roll = Integer.parseInt(br.readLine());
		System.out.println("Enter Student Name :: ");
		String name = br.readLine();
		System.out.println("Enter Student Addr :: ");
		String addr = br.readLine();
		
		
		String insertQuery  = "insert into student values("+roll+",'"+name+"','"+addr+"')";

		
		st.executeUpdate(insertQuery);

		

		// Close the Connection
		con.close();

	}
	
	
	
}