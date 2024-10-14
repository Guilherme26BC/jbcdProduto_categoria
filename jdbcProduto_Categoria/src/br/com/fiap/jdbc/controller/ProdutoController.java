package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.jdbc.dao.ProdutoDAO;
import br.com.fiap.jdbc.factory.ConnectionFactoryPool;
import br.com.fiap.model.Produto;

public class ProdutoController {

	private ProdutoDAO produtoDAO;

	public ProdutoController() throws SQLException {
		Connection connection = ConnectionFactoryPool.getConnection();
		this.produtoDAO = new ProdutoDAO(connection);
	}

	public void salvarComCategoria(Produto produto) {
		this.produtoDAO.salvarEmCategoria(produto);
	}

	public List<Produto> listarTodos() {
		return this.produtoDAO.listarTodos();
	}

	public List<Produto> listarPorCategorias(int idCategoria) {
		return this.produtoDAO.listarPorCategoria(idCategoria);
	}

	public void alterar(Produto produto, int id) {
		this.produtoDAO.alterar(produto, id);
	}

	public void excluir(int idProduto) {
		this.produtoDAO.excluir(idProduto);
	}

}
