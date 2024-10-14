package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.jdbc.dao.CategoriaDAO;
import br.com.fiap.jdbc.dao.MarcaDAO;
import br.com.fiap.jdbc.dao.ProdutoDAO;
import br.com.fiap.jdbc.dao.UsuarioDAO;
import br.com.fiap.jdbc.factory.ConnectionFactoryPool;

public class AppController {

	private static AppController instance;
	private Connection connection;
	private UsuarioDAO usuarioDAO;
	private ProdutoDAO produtoDAO;
	private MarcaDAO marcaDAO;
	private CategoriaDAO categoriaDAO;
	
	//Construtor privado para singleton só; é usado na própria classe
	public AppController() throws SQLException{
		this.connection = ConnectionFactoryPool.getConnection();
		this.usuarioDAO = new UsuarioDAO(connection);
		this.produtoDAO = new ProdutoDAO(connection);
		this.marcaDAO = new MarcaDAO(connection);
		this.categoriaDAO = new CategoriaDAO(connection);
	}
	
	//Método para obter a instância única do AppController, mantém uma única instância
	public static AppController getInstance() throws SQLException{
		if(instance == null) {
			instance = new AppController();
		}
		return instance;
	}
	
	//método para fechar a conexão quando o AppController não for mais necessário
	public void closeConnection() throws SQLException{
		if(connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
}
