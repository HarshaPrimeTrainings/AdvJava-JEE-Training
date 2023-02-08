import java.sql.*;

import java.io.*;

public class MetaDataDemo{
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_training","root","admin");
		
		// DatabaseMetaData
		 System.out.println(":: DatabaseMetaData :: ");
		 DatabaseMetaData dbm = con.getMetaData();
		 System.out.println("DataBaseMajorVersion :: "+dbm.getDatabaseMajorVersion());
		 System.out.println("ProductName :: "+dbm.getDatabaseProductName());
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery("select * from student");
		
		// ResultSetMetaData
		ResultSetMetaData metadata = rs.getMetaData();
		System.out.println(":: ResultSetMetaData :: ");
		System.out.println("ColumnCount :: "+metadata.getColumnCount());
		System.out.println("ColumnName  :: "+metadata.getColumnName(1));
		System.out.println("ColumnName  :: "+metadata.getColumnName(5));
		System.out.println("isNullable 2 column :: "+metadata.isNullable(2));
		System.out.println("isNullable 5 column :: "+metadata.isNullable(5));
		
		// ParameterMedatada
		System.out.println(":: ParameterMedatada :: ");
		PreparedStatement ps = con.prepareStatement(" insert into student values (?,?,?,?,?)");
		ParameterMetaData pmd = ps.getParameterMetaData();
		System.out.println("ParameterCount :: "+pmd.getParameterCount());
		
		// Close the Connection
		con.close();

	}
}