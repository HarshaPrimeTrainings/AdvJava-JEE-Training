import java.sql.*;

import java.io.*;

public class CrudDemo{
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		// Registering the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Getting the Connection from DB Driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		// creating the Statement Object
		Statement st = con.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Choose an Option :: ");
		System.out.println("Enter 1 to Insert Record :: ");
		System.out.println("Enter 2 to Update Record :: ");
		System.out.println("Enter 3 to Search Record :: ");
		System.out.println("Enter 4 to Delete Record :: ");
		int option = Integer.parseInt(br.readLine());
		switch(option){
			case 1 : {
			System.out.println("Enter Student roll :: ");
			int roll = Integer.parseInt(br.readLine());
			System.out.println("Enter Student Name :: ");
			String name = br.readLine();
			System.out.println("Enter Student Addr :: ");
			String addr = br.readLine();
			String insertQuery  = "insert into student values("+roll+",'"+name+"','"+addr+"')";
			st.executeUpdate(insertQuery);
			break;
			}
			case 2: {
				System.out.println("Enter Student roll to update :: ");
				int updateroll = Integer.parseInt(br.readLine());
				System.out.println("Enter 1 update to NAME");
				System.out.println("Enter 2 update to Address");
				int updateoption = Integer.parseInt(br.readLine());
				switch(updateoption){
					case 1: {
						System.out.println("Enter New Name");
						String newname = br.readLine();
						String updateQuery  = "update student set name = '"+newname+"' where roll = "+ updateroll;
						System.out.println(updateQuery);
						st.executeUpdate(updateQuery);
						break;
					}
					case 2: {
						System.out.println("Enter New Adress");
						String newaddr = br.readLine();
						String updateQuery  = "update student set address = '"+newaddr+"' where roll = "+ updateroll;
						System.out.println(updateQuery);
						st.executeUpdate(updateQuery);
						break;
					}
				}
				break;
			}
			case 3: {
				System.out.println("Enter Student roll :: ");
				int rollsearch = Integer.parseInt(br.readLine());
				String sql  = "select * from student where roll = "+ rollsearch;
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					int roll = rs.getInt("roll");
					String name = rs.getString("name");
					String addr = rs.getString("address");
					System.out.println("roll :: "+ roll + " || name :: "+ name+ " || address :: "+ addr);
				}
				break;
			}
			case 4 :{
				System.out.println("Enter Student roll to Delete :: ");
				int deleteroll = Integer.parseInt(br.readLine());
				String deleteQuery = "delete from student where roll = "+ deleteroll;
				st.executeUpdate(deleteQuery);
				break;
			}
			
		}
		// Close the Connection
		con.close();

	}
}