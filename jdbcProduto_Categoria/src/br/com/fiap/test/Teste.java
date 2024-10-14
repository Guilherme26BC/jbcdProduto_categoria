package br.com.fiap.test;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.jdbc.controller.AppController;
import br.com.fiap.jdbc.controller.CategoriaController;
import br.com.fiap.jdbc.controller.ProdutoController;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Produto;

public class Teste {

	public static void main(String[] args) throws SQLException {
		//
		AppController appController = AppController.getInstance();
		
		CategoriaController categoriaController = new CategoriaController();
		ProdutoController produtoController = new ProdutoController();

		List<Categoria> listaCategoria;
		listaCategoria = categoriaController.listarTodas();
		for (Categoria categoria : listaCategoria)
			System.out.println(categoria.getNome());

//		Produto produto1 = new Produto();
//		produto1.setNome("God of War");
//		produto1.setDescricao("jogo de aventura. Recomendação +18");
//		produto1.setIdCategoria(2);
//		produtoController.salvarComCategoria(produto1);
//		
//		Produto produto2 = new Produto();
//		produto2.setNome("Smartphone Samsung");
//		produto2.setDescricao("Samsung galaxy S20");
//		produto2.setIdCategoria(1);
//		produtoController.salvarComCategoria(produto2);
//		
//		Produto produto3 = new Produto();
//		produto3.setNome("Iphone");
//		produto3.setDescricao("Iphone 14");
//		produto3.setIdCategoria(1);
//		produtoController.salvarComCategoria(produto3);
//	
		Produto produto4 = new Produto();
//		produto4.setNome("Arroz");
//		produto4.setDescricao("Arroz integral");
//		produto4.setIdCategoria(1);
//		produtoController.salvarComCategoria(produto4);
		
		System.out.println();
		listaCategoria = categoriaController.listarComProdutos();
		List<Produto> listaProdutos = null;
		for(Categoria categoria : listaCategoria) {
			listaProdutos = categoria.getProdutos();
			for(Produto produtoCategoria: listaProdutos) {
				System.out.println("Categoria:" + categoria.getNome());
				System.out.println("Nome do Produto " + produtoCategoria.getNome());
			}
		}
		
//		produto4.setNome("pc");
//		produtoController.alterar(produto4, 8);
		
		
//		System.out.println();
//		listaCategoria = categoriaController.listarComProdutos();
//		listaProdutos = null;
//		for(Categoria categoria : listaCategoria) {
//			listaProdutos = categoria.getProdutos();
//			for(Produto produtoCategoria: listaProdutos) {
//				System.out.println("Categoria:" + categoria.getNome());
//				System.out.println("Nome do Produto " + produtoCategoria.getNome());
//			}
//		}
	//	produtoController.excluir(7);
		Categoria cat= new Categoria();
//		cat.setNome("Cosméticos");
//		categoriaController.salvarCategoria(cat);
		
		listaCategoria = categoriaController.listarTodas();
		for (Categoria categoria : listaCategoria)
			System.out.println(categoria.getNome());
		
		cat.setNome("fitness");
		categoriaController.alterar(cat);
	}

}
