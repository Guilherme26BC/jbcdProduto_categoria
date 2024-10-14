package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Categoria;
import br.com.fiap.model.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listarTodas() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			String sql = "SELECT * FROM CATEGORIA";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setIdCategoria(rs.getInt(1));
				categoria.setNome(rs.getString(2));
				categorias.add(categoria);

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}
	
	public List<Categoria> listarComProduto(){
		Categoria categoriaAtual= null;
		List<Categoria> categorias = new ArrayList<Categoria>();
		String sql = "SELECT C.idCategoria, C.nome, P.idProduto, P.nome, P.descricao, P.preco, P.idCategoria "
				+ "FROM CATEGORIA C INNER JOIN PRODUTO P ON C.idCategoria = P.idCategoria order by C.idCategoria";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while(rs.next()) {
				if(categoriaAtual == null || !categoriaAtual.getNome().equals(rs.getString(2))) {
					//PERCORRE TODAS AS CATEGORIAS, SE A CATEGORIA FOR NULA, OU NÃO FOR IGUAL A CATEGORIA ATUAL
					Categoria categoria = new Categoria();
					categoria.setIdCategoria(rs.getInt(1));
					categoria.setNome(rs.getString(2));
					categorias.add(categoria);
					categoriaAtual= categoria;
				}
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt(3));
				produto.setNome(rs.getString(4));
				produto.setDescricao(rs.getString(5));
				produto.setPreco(rs.getDouble(6));
				produto.setIdCategoria(rs.getInt(7));
				categoriaAtual.adicionaProduto(produto);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}
	
	public void salvarCategoria(Categoria categoria) {
		try {
			String sql = "INSERT INTO CATEGORIA(idCategoria, NOME) VALUES (?, ?)";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, categoria.getIdCategoria());
			stmt.setString(2, categoria.getNome());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void alterar(Categoria categoria) {
		try {
			String sql = "UPDATE CATEGORIA C SET C.nome = ? WHERE idCategoria = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, categoria.getNome());
			stmt.setInt(2, categoria.getIdCategoria());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void excluir(int id) {
		try {
		String sql = "DELETE FROM CATEGORIA WHERE idCategoria = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
