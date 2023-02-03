import java.sql.*;

import java.io.*;

public class JDBCBatchDemo{
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		
		Statement st = con.createStatement();
		
		st.addBatch("insert into student values(1,'Monika','NY',55,'B')");
		st.addBatch("insert into student values(2,'Chandler','NY',45,'B')");
		st.addBatch("insert into student values(3,'JoeTribiany','NY',65,'A')");
		st.addBatch("insert into student values(4,'Ross','NY',75,'A')");
		st.addBatch("insert into student values(5,'Pheebe','NY',85,'A')");
		st.addBatch("insert into student values(6,'Rachel','NY',95,'A')");
		
		int[] res = st.executeBatch();
		
		System.out.println("Data Inserted :: "+ res);
		// Close the Connection
		con.close();

	}
}