package com.sistema.inventario.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.sistema.inventario.model.Pessoa;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class PessoaControllerTest {

	@Autowired
	private PessoaController pessoaController;

	@Test
	public void testObterTodos() {

		List<Pessoa> resultado = pessoaController.obterTodos();

		
		assertFalse(resultado.isEmpty());
		
//		if (resultado.isEmpty()) {
//			assertFalse(true);
//		} else {
//			assertFalse(false);
//		}

	}

	@Test
	@Before
	public void testObterporId() {

		// inserir o id a ser testado
		Long id = 1L;

		pessoaController.obterporId(id);

		Optional<Pessoa> resultado = pessoaController.obterporId(id);

		// o teste será bem sucedido se o ID existir
		assertTrue(resultado.isPresent());

	}

	@Test
	public void testAdicionar() {

		Pessoa pessoa = new Pessoa();

		// body para setar os valores
		pessoa.setNome("Teste Classe Pessoa");
		pessoa.setCargo("Dev Jr. Davi");
		pessoa.setEmail("davi@dev.com");
		pessoa.setTelefone("9999");

		pessoaController.adicionar(pessoa);

		assertEquals(true, pessoa.getId() == 22L);

	}

	@Test
	@After
	public void testDeletar() {

		// id do responsavel a ser testado
		Long id = 15L;

		pessoaController.deletar(id);

		// vai no banco de dados e tenta buscar o id que mandamos deletar
		Optional<Pessoa> optionalPessoa = pessoaController.obterporId(id);

		// verifica se a pessoa foi realmente deletada(se o id da pessoa ta presente )
		assertFalse(optionalPessoa.isPresent());

	}

	@Test
	public void testAtualizar() {

		Long id = 14L;

		Pessoa pessoa = new Pessoa();

		pessoa.setNome("");
		pessoa.setCargo("");
		pessoa.setEmail("");
		pessoa.setTelefone("");

		pessoaController.atualizar(id, pessoa);

		assertEquals(true, pessoa.getNome() == "");
	}

}
