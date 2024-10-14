package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.jdbc.dao.MarcaDAO;
import br.com.fiap.jdbc.factory.ConnectionFactoryPool;
import br.com.fiap.model.Marca;

public class MarcaController {

	private MarcaDAO marcaDAO;

	public MarcaController()throws SQLException {
		Connection connection = ConnectionFactoryPool.getConnection();
		this.marcaDAO = new MarcaDAO(connection);
	}
	
	public void adicionar(Marca marca) {
		this.marcaDAO.adicionar(marca);
	}
	
	
}
