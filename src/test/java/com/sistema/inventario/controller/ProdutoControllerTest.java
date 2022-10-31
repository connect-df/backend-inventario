package com.sistema.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sistema.inventario.model.Produto;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class ProdutoControllerTest {

	@Autowired
	private ProdutoController controller;

	@Test
	public void buscarTodosProdutos() {
		List<Produto> resultado = controller.obterTodos();

		Assertions.assertFalse(resultado.isEmpty());
	}
	
	@Test
	public void buscarProdutosPorId() {
		Long id = 1L;
		Optional<Produto> resultado = controller.obterporId(id);

		Assertions.assertTrue(resultado.isEmpty());
	}
	
	@Test
	public void AdicionarProduto() {
		Produto produto = new Produto();
		
		produto.setPatrimonio("NOTEBOOK");
		produto.setDescricao("I7");
		produto.setSituacao("novo");
		produto.setCodigo("71256");
		produto.setDtCadastro(null);
		produto.setValor(3500.00);
		
		controller.adicionar(produto);

		Assertions.assertEquals(true, produto.getId() == 15);
	}
	
	@Test
	public void deletarProduto() {
		Long id = 8L;
		
		controller.deletar(id);
		
		Optional<Produto> resultado = controller.obterporId(id);
		
		Assertions.assertTrue(resultado.isEmpty());
	}
	
	@Test
	public void atualizarProdutoPorId() {
		Long id = 9L;
		Produto produto = new Produto();
		
		produto.setPatrimonio("NOTEBOOK");
		produto.setDescricao("I7 SSD 512");
		produto.setSituacao("novo");
		produto.setCodigo("71256");
		produto.setDtCadastro(null);
		produto.setValor(3500.00);
		
		controller.atualizar(id, produto);
		
		Assertions.assertEquals(true, produto.getSituacao() == "novo" );
	}
			

}
