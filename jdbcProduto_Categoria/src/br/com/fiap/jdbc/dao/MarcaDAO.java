package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.model.Marca;

public class MarcaDAO {

	private Connection connection;

	public MarcaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void adicionar(Marca marca) {
		String sql = "INSERT INTO marca (nome, descricao) VALUES (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, marca.getNome());
			stmt.setString(2, marca.getDescrcao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
