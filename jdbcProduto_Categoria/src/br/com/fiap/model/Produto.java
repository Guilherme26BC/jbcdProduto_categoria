package br.com.fiap.model;

import java.sql.Date;

public class Produto {

	private int IdProduto; //PK
	private int IdCategoria; //FK
	private String nome, descricao;
	private double preco;

	public Produto() {
		super();
	}

	public Produto(int idCategoria, String nome, String descricao, double preco) {
		IdCategoria = idCategoria;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(int idProduto) {
		IdProduto = idProduto;
	}

	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	
	
}
