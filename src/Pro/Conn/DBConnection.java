package Pro.Conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection CreateConnection() {
		
	    Connection conn = null; 
	    String url = "jdbc:mysql://localhost:3306/application_login_page";
		String username = "root";
		String password = "Admin";
		System.out.println("In DBConnection.java class ");
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
		    }
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection name " + conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
