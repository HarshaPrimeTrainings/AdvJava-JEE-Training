import java.sql.*;

public class JDBCDemowithClassForName{
	
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		
		// Registering the Driver
		//Driver d = new com.mysql.cj.jdbc.Driver();
		//DriverManager.registerDriver(d);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Register Successfull");
		
		//Getting the Connection from DB Driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		System.out.println("Connection Successfull");
	
		// creating the Statement Object
		Statement st = con.createStatement();
		
		System.out.println("Statement Object Created");
		
		// Sending the SQL Query
		st.execute("create table employee(eid Integer,name varchar(100),address varchar(100))");
		System.out.println("Table Created");
		
		// Close the Connection
		con.close();

	}
	
	
	
}