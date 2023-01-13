import java.sql.*;

public class MainApp{
	
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		
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
		
		// Creating table
		String createtablequery = "create table student(roll Integer,name varchar(100),address varchar(100))";
		st.execute(createtablequery);
		System.out.println("Table Created");
		
		
		
		System.out.println("Record 1 Table Insert");
		String insertQuery  = "insert into student values(1,'ROSS','NY')";
		System.out.println("Record 2 Table Insert");
		String insertQuery1 = "insert into student values(2,'REACHAL','NY')";
		System.out.println("Record 3 Table Insert");
		String insertQuery2 = "insert into student values(3,'JOE','NY')";
		System.out.println("Record 4 Table Insert");
		String insertQuery3 = "insert into student values(4,'CHANDLER','NY')";
		System.out.println("Record 5 Table Insert");
		String insertQuery4 = "insert into student values(5,'MONIKA','NY')";
		System.out.println("Record 6 Table Insert");
		String insertQuery5 = "insert into student values(6,'PHEEBE','NY')";
		
		st.executeUpdate(insertQuery);
		st.executeUpdate(insertQuery1);		
		st.executeUpdate(insertQuery2);
		st.executeUpdate(insertQuery3);
		st.executeUpdate(insertQuery4);
		st.executeUpdate(insertQuery5);
		

		// Close the Connection
		con.close();

	}
	
	
	
}