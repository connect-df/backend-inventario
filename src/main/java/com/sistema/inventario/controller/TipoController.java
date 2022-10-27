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

import com.sistema.inventario.model.Tipo;

import com.sistema.inventario.service.TipoService;

@RestController
@RequestMapping("/api/tipo")
public class TipoController {

	@Autowired
	private TipoService tipoService;

	@CrossOrigin(origins = "*")
	@GetMapping
	public List<Tipo> obterTodos() {
		return tipoService.obterTodos();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Optional<Tipo> obterporId(@PathVariable Long id) {
		return tipoService.obterPorId(id);
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public Tipo adicionar(@RequestBody Tipo tipo) {
		return tipoService.adicionar(tipo);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		tipoService.deletar(id);
		return "Tipo com id: " + id + " Deletado com sucesso!";
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public Tipo atualizar(@PathVariable Long id, @RequestBody Tipo tipo) {
		return tipoService.atualizar(id, tipo);

	}

}