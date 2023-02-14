
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class TransactionDemo {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		Connection conn = null;
		try {
			//Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Getting the Connection
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");

			//Create Statement Object
			Statement st = conn.createStatement();
			
			conn.setAutoCommit(false);
			
			ResultSet rs = st.executeQuery("select * from account1");
			rs.next();
			int currentBalance =rs.getInt(1);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Ammount :: ");
			int ammount = Integer.parseInt(br.readLine());
			int actualblalance = currentBalance - ammount;
			st.executeUpdate("update account1 set Balance="+actualblalance);
			
			System.out.println("Ammout after debited");
			ResultSet rs2 = st.executeQuery("select * from account1");
			rs2.next();
			System.out.println(rs2.getInt(1));
			
			ResultSet rs1 = st.executeQuery("select * from account2");
			rs1.next();
			int account2balance = rs1.getInt(1);
			int currentbalance2 = account2balance+ ammount;
			st.executeUpdate("update account2 set Balance="+currentbalance2);

			conn.commit();
			System.out.println("Amount transferred succefully:: ");
		} catch (ClassNotFoundException | SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
		
	}
}
