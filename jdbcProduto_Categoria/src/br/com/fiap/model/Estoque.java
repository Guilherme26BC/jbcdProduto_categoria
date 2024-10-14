package br.com.fiap.model;

public class Estoque {

	int cd_estoque;
	Produto produto;
	int quantidade;
	
	public Estoque() {
	}

	public int getCd_estoque() {
		return cd_estoque;
	}

	public void setCd_estoque(int cd_estoque) {
		this.cd_estoque = cd_estoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
