import java.sql.*;

import java.io.*;

public class SearchRecordwithPreapredStatement{
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		// Registering the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Getting the Connection from DB Driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		// creating the Statement Object

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Student roll :: ");
			int roll = Integer.parseInt(br.readLine());
			
			
			String query  = "select * from student where roll = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1,roll);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
			int rollnumber = rs.getInt("roll");
			 String name = rs.getString("name");
			 String addr = rs.getString("address");
			 System.out.println("roll :: "+ rollnumber + " == name :: "+ name+ " == address :: "+ addr);
			
			}
			
			
		// Close the Connection
		con.close();

	}
}