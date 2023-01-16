package com.sistema.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.inventario.model.Tipo;
import com.sistema.inventario.service.TipoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/tipo")
public class TipoController {

	@Autowired
	private TipoService tipoService;

	@ApiOperation("Endpoint responsável por buscar todos os tipos")
	@GetMapping
	public List<Tipo> obterTodos() {
		return tipoService.obterTodos();
	}

	@ApiOperation("Endpoint responsável por buscar um unico tipo")
	@GetMapping("/{id}")
	public Optional<Tipo> obterporId(@PathVariable Long id) {
		return tipoService.obterPorId(id);
	}
	@ApiOperation("Endpoint responsável por adicionar um tipo")
	@ApiResponses(value= {
				@ApiResponse(code=200, message = "Criou um tipo"),
				@ApiResponse(code=500, message = "Foi gerado um erro ao criar o tipo")
				
	})
	@PostMapping
	public Tipo adicionar(@RequestBody Tipo tipo) {
		return tipoService.adicionar(tipo);

	}

	@ApiOperation("Endpoint responsável por deletar um tipo")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		tipoService.deletar(id);
	}


	@ApiOperation("Endpoint responsável por atualizar um tipo")
	@PutMapping("/{id}")
	public Tipo atualizar(@PathVariable Long id, @RequestBody Tipo tipo) {
		return tipoService.atualizar(id, tipo);

	}

}