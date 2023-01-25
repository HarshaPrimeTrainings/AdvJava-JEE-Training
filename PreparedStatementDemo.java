import java.sql.*;

import java.io.*;

public class PreparedStatementDemo{
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		// Registering the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Getting the Connection from DB Driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		// creating the Statement Object

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Student roll :: ");
			int roll = Integer.parseInt(br.readLine());
			System.out.println("Enter Student Name :: ");
			String name = br.readLine();
			System.out.println("Enter Student Addr :: ");
			String addr = br.readLine();
			
			String insertQuery  = "insert into student values(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			ps.setInt(1,roll);
			
			ps.setString(2,name);
			
			ps.setString(3,addr);
			
			ps.execute();
			
			
		// Close the Connection
		con.close();

	}
}