package connection;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {
			
		EmsMenu menu = new EmsMenu();
		
		menu.mainMenu();
		
		try {
			ConnectionManager.getConnection().close();
		} catch (SQLException e) {
			System.out.println("Could not close connection");
			e.printStackTrace();
		}
	}

}
