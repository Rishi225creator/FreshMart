package project.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	static Connection con=null;
	public static Connection getConnection(){
		if(con != null){
			return con;
		}
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
		}catch(ClassNotFoundException e){
			
		}catch(SQLException e){
			
		}
		return con;
	}
	public static void closeConnection(){
		try{
			con.close();
			con = null;
		}catch(SQLException e){
			
		}
	}
}