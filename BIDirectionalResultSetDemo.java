import java.sql.*;

import java.io.*;

public class BIDirectionalResultSetDemo{
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//BIDirectional
		ResultSet rs = st.executeQuery("select * from student");
		
		    System.out.println("ROW NUMBER:: "+rs.getRow());
		    rs.next();
			int roll = rs.getInt("roll");
			String name = rs.getString("name");
			System.out.println(roll + ":: "+ name);
			
			
			System.out.println("ROW NUMBER:: "+rs.getRow());
		    rs.next();
			int roll1 = rs.getInt("roll");
			String name1 = rs.getString("name");
			System.out.println(roll1 + ":: "+ name1);
		
			System.out.println("ROW NUMBER:: "+rs.getRow());
		    rs.next();
			int roll2 = rs.getInt("roll");
			String name2 = rs.getString("name");
			System.out.println(roll2 + ":: "+ name2);
			
			System.out.println("ROW NUMBER:: "+rs.getRow());
			rs.previous();
			int roll3 = rs.getInt("roll");
			String name3 = rs.getString("name");
			System.out.println(roll3 + ":: "+ name3);

		
		// Close the Connection
		con.close();

	}
}