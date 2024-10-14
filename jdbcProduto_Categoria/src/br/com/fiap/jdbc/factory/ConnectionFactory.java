package br.com.fiap.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private  Connection connection;
	private final String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private final String USER = "RM550282";
	private final String PASSWRD = "260105";
	
	public  Connection getConnection() {
			try {
				this.connection = DriverManager.getConnection(ORACLE,USER, PASSWRD);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Erro ao Conectar ao banco de dados");
			}
		
		return connection;
	}
}
