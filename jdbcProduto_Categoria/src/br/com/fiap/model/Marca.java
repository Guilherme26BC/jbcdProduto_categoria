package br.com.fiap.model;

import java.util.List;

public class Marca {

	private int id;
	private String nome, descrcao;
	private List<Produto> produtos;
	
	
	public Marca() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrcao() {
		return descrcao;
	}
	public void setDescrcao(String descrcao) {
		this.descrcao = descrcao;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void adicionaProduto(Produto produto) {
	this.produtos.add(produto);
	}
	
	
}
