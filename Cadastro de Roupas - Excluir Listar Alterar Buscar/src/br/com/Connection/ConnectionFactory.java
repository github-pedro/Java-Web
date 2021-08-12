package br.com.Connection;

import java.sql.Connection;
import java.sql.DriverManager; 

public class ConnectionFactory {
	public Connection getConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/dbroupas";
		String user = "root";
		String password = "10315";	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		}catch(Exception error){
			throw new RuntimeException("Erro na conexão" + error);
		}
		
	}
}
