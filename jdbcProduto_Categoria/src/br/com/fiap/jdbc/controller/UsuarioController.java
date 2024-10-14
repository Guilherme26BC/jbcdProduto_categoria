package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.jdbc.dao.UsuarioDAO;
import br.com.fiap.jdbc.factory.ConnectionFactoryPool;
import br.com.fiap.model.Usuario;

public class UsuarioController {

	private UsuarioDAO usuarioDAO;

	public UsuarioController() throws SQLException{
		Connection connection = ConnectionFactoryPool.getConnection();
		this.usuarioDAO = new UsuarioDAO(connection);
	} 
	
	public void validarUsuario(Usuario usuario) {
		this.usuarioDAO.validarUsuario(usuario);
	}
	


}
