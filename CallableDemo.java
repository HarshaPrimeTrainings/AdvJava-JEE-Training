import java.sql.*;

import java.io.*;

public class CallableDemo{
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		// Registering the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Getting the Connection from DB Driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		// creating the Statement Object
		CallableStatement callbleStatment = con.prepareCall("{call update_grade}");
		
		callbleStatment.execute();

		
		// Close the Connection
		con.close();

	}
}