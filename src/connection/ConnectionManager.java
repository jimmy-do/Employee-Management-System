package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/ems";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection connection = null;
	
	private static void makeConnection() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Could not make connection.");
		}
	}
	
	public static Connection getConnection() {
		
		if (connection == null) {
			makeConnection();
		}
		
		return connection;
	}

}