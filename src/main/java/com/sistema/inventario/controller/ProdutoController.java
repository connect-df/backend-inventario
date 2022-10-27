package com.sistema.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.inventario.model.Produto;
//import com.sistema.inventario.repository.ProdutoRepository;
import com.sistema.inventario.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

//	@Autowired
//	private ProdutoRepository produtoRepository;
//	
	@CrossOrigin(origins = "*")
	@GetMapping
	public List<Produto> obterTodos() {
		return produtoService.obterTodos();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Optional<Produto> obterporId(@PathVariable Long id) {
		return produtoService.obterPorId(id);
	}

//	    @GetMapping(value= "/obterPorPessoa")
//	    public List<Produto> obterPorPessoa(String nome) {
//	    	return produtoRepository.findByTipoContaining(tipo);
//	    }

	@CrossOrigin(origins = "*")
	@PostMapping
	public Produto adicionar(@RequestBody Produto produto) {
		return produtoService.adicionar(produto);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		produtoService.deletar(id);
		return "Produto com id: " + id + " Deletado com sucesso!";
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		return produtoService.atualizar(id, produto);

	}
}
