package jdbcsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {
public static void main(String[] args) {
	
//	try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root@12345");
//		
//		Statement stmt= con.createStatement();
//		
//		int res=stmt.executeUpdate("insert into user(id,name) values(1,'lavanya')");
//		System.out.println(res>0?"values inserted":"values not inserted");
//		
//		
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","root@12345");
		
		Statement stmt= con.createStatement();
		
		ResultSet rs= stmt.executeQuery("select emailid,password from user");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}
