package com.sistema.inventario.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import com.sistema.inventario.model.Tipo;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class TipoControllerTest {

	@Autowired
	private TipoController controller;

	@Test
	void testObterTodos() {
		// Obetendo Array de tipo da TipoController
		List<Tipo> resultado = controller.obterTodos();

		// Se não houver um tipo (vazio) defina o assert como falso.
		// se não defina verdadeiro.
		assertFalse(resultado.isEmpty());
	}

	@Test
	@Before
	void testObterporId() {
		// Inserindo id que queira checar
		Long id = 23L;
		// Aciona a controller para obter Teste por id.
		controller.obterporId(id);
		
		// Define resultado com a resposta d
		Optional<Tipo> resultado = controller.obterporId(id);

		// Se resultado !== null retorne true.
		assertTrue(resultado.isPresent());
	}

	@Test
	void testAdicionar() {
		// Define tipo como um Construtor.
		Tipo tipo = new Tipo();

		// Body aqui vai todos os atributos da tabela.
		tipo.setCategoria("Teste1");

		// Aciona a controller para adicionar o tipo.
		tipo = controller.adicionar(tipo);
		
		// Informando o id que será adicionado para a verificação de adição.
		assertEquals(true, tipo.getId() == 25);
	}

	@Test
	@After
	void testDeletar() {
		// Defini o id que quer deletar
		Long id = 24L;

		// Manda a ação de deletar para a controller usando id como Parâmetro.
		controller.deletar(id);
		
		// Verifica se o id foi deletado
		Optional<Tipo> resultado = controller.obterporId(1l);

		// Se deletado, retorna um resultado como null.
		assertFalse(resultado.isPresent());
	}

	@Test
	void testAtualizar() {
		// Defini tipo como um construtor.
		Tipo tipo = new Tipo();
		
		// Informar o id que queira atualizar.
		Long id = 20L;

		//Body: aqui vai todos os atributos que queira atualizar da tabela.
		tipo.setCategoria("Testado 1234");

		// Manda o comando de atualizar para a controller com o id, e atributos já atualizado.
		controller.atualizar(id, tipo);
		
		// Informar o atributo alterado para a verificação.
		assertEquals(true, tipo.getCategoria() == "Testado 1234");
	}

}
