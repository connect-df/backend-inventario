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
import com.sistema.inventario.repository.PessoaRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class PessoaControllerTest {

	@Autowired
	private PessoaController pessoaController;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Test
	void testObterTodos() {

		List<Pessoa> resultado = pessoaController.obterTodos();

		if (resultado.isEmpty()) {
			assertFalse(true);
		} else {
			assertFalse(false);
		}

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
		pessoa.setTelefone("99999");
		
		pessoaController.adicionar(pessoa);
		
		
	}

	@Test
	@After
	public void testDeletar() {

		// id do responsavel a ser testado
		Long id = 13L;

		pessoaController.deletar(id);

		// vai no banco de dados e tenta buscar o id que mandamos deletar
		Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);

		// verifica se a pessoa foi realmente deletada(se o id da pessoa ta presente )
		assertFalse(optionalPessoa.isPresent());

	}

//	@Test
//	public void testAtualizar() {
//		
//		fail("Not yet implemented");
//		
//		
//	}

}
