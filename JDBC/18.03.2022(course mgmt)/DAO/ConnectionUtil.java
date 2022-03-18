package com.courseManagement.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

public static Connection getDbConnection()   {
Connection con=null;
try	{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management","root","root@12345");
}	catch(ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
	e.printStackTrace();
}
return con;
}

}