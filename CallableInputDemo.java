import java.sql.*;

import java.io.*;

public class CallableInputDemo{
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		// Registering the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Getting the Connection from DB Driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		// creating the Statement Object
		CallableStatement callbleStatment = con.prepareCall("{call insert_student(?,?,?,?,?)}");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Student roll :: ");
			int roll = Integer.parseInt(br.readLine());
			System.out.println("Enter Student Name :: ");
			String name = br.readLine();
			System.out.println("Enter Student Addr :: ");
			String addr = br.readLine();
			System.out.println("Enter Student Marks :: ");
			int marks = Integer.parseInt(br.readLine());
			System.out.println("Enter Student GRADE :: ");
			String grade = br.readLine();
			
		callbleStatment.setInt(1,roll);
		callbleStatment.setString(2,name);
		callbleStatment.setString(3,addr);
		callbleStatment.setInt(4,marks);
		callbleStatment.setString(5,grade);
		
		callbleStatment.executeUpdate();

		
		// Close the Connection
		con.close();

	}
}