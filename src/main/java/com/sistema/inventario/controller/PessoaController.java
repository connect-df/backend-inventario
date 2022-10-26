package com.sistema.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.inventario.model.Pessoa;
import com.sistema.inventario.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	 @GetMapping
	    public List<Pessoa> obterTodos() {
	        return pessoaService.obterTodos();
	    }

	    
	    @GetMapping("/{id}")
	    public Optional<Pessoa> obterporId(@PathVariable Long id) {
	        return pessoaService.obterPorId(id);
	    }

	    
	    @PostMapping
	    public Pessoa adicionar(@RequestBody Pessoa pessoa) {
	        return pessoaService.adicionar(pessoa);
	        
	    }

	   
	    @DeleteMapping("/{id}")
	    public String deletar(@PathVariable Long id) {
	    	pessoaService.deletar(id);
	        return "Produto com id: " + id + " Deletado com sucesso!";
	    }

	    
	    @PutMapping("/{id}")
	    public Pessoa atualizar(@PathVariable Long id,@RequestBody Pessoa pessoa) {
	        return pessoaService.atualizar(id, pessoa);

	    }
}
