import java.sql.*;

import java.io.*;

public class SearchRecord{
	
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
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Student roll :: ");
		int rollsearch = Integer.parseInt(br.readLine());
		String sql  = "select * from student where roll = "+ rollsearch;
		

		
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