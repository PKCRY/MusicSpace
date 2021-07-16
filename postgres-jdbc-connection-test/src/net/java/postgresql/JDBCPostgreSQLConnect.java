package net.java.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPostgreSQLConnect {
// jdbc url
// jdbc username
// jdbc password
	private final String url = "jdbc:postgresql://localhost/postgres";
	private final String user = "postgres";
	private final String password = "pizza1234";
	
	private void connect() {
		try(Connection connection = DriverManager.getConnection(url,user,password);){
			
			if(connection!=null) {
				System.out.println("Connection succesfull");
			}else {
				System.out.println("No connection");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JDBCPostgreSQLConnect sqlConnect = new JDBCPostgreSQLConnect();
		sqlConnect.connect();
	}
}
