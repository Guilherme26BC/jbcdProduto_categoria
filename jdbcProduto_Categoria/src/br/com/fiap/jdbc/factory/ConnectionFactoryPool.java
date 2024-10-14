package br.com.fiap.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactoryPool {

	private static HikariDataSource dataSource;
	
	static {
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL");
		config.setUsername("RM550282");
		config.setPassword("260105");
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(5);
		config.setIdleTimeout(60000);
		config.setConnectionTimeout(3000);
		dataSource = new HikariDataSource(config);
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public static void close() {
		if(dataSource!= null) {
			dataSource.close();
		}
	}
}
