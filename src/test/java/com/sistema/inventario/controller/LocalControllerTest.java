package com.sistema.inventario.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sistema.inventario.model.Ambiente;

@SpringBootTest
@WebAppConfiguration
class LocalControllerTest {
	
	@Autowired
	private LocalController localController;

	//@Test
	//void test() {
		//fail("Not yet implemented");
	//}

@Test

public void testObterporId() {

	Long id =  (long) 8;
				
	localController.obterporId(id);
		
  Optional<Ambiente> resultado = localController.obterporId(id);
		
	assertTrue(resultado.isEmpty());
			}
	
	
@Test	
	public void testObterTodos() {
		
		List<Ambiente> resultado = localController.obterTodos();
		
	if (resultado.isEmpty()) {
		assertFalse(true);
		
	} else {
		assertFalse(false);
		}
		}
@Test

    public void testDeletar() {
	
	Long id = (long) 17;
	
	localController.deletar(id);
	
	String resultado = localController.deletar(id);
	
	assertTrue(resultado.isEmpty());
	
}

@Test
    public void testAdicionar() {

	Ambiente ambiente = new Ambiente();
	
	ambiente.setAmbiente("Empresa");
	
	ambiente = localController.adicionar(ambiente);

	assertEquals(true, ambiente.getId() == 18);
}

//@Test
   
    public void testAtualizar() {
	
    Ambiente ambiente = new Ambiente();
    
    Long id = (long) 3;
    
    ambiente.setAmbiente("Empresa");
    
    localController.atualizar(id, ambiente);
    
    assertEquals(true, ambiente.getAmbiente() == "Ambiente");
}
    
}

