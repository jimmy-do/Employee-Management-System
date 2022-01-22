package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/ems";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			System.out.println("Successfully connected to database!");
			
		} catch (SQLException e) {
			
			System.out.println("Could not connect to database");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		
		Connection conn = TestConnection.getConnection();
		
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("There was an exception trying to close the database.");
		}
	}

}
