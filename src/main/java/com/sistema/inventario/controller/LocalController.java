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

import com.sistema.inventario.model.Ambiente;
//import com.sistema.inventario.repository.LocalRepository;
import com.sistema.inventario.service.LocalService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/local")
public class LocalController {

	@Autowired
	private LocalService localService;




	@ApiOperation("Endpoint responsável por buscar todos os locais")
	@CrossOrigin(origins = "*")

	@GetMapping
	public List<Ambiente> obterTodos() {
		return localService.obterTodos();
	}


	@ApiOperation("Endpoint responsável por buscar um unico local")
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
public Optional<Ambiente> obterporId(@PathVariable Long id) {
		return localService.obterPorId(id);
	}

	@ApiOperation("Endpoint responsável por adicionar um local")
	@ApiResponses(value= {
		@ApiResponse(code=200, message = "Criou um local"),
		@ApiResponse(code=500, message = "Foi gerado um erro ao criar o local")
		
	})
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public Ambiente adicionar(@RequestBody Ambiente local) {
		return localService.adicionar(local);

	}

	@ApiOperation("Endpoint responsável por deletar um local")
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		localService.deletar(id);
		return "Local com id: " + id + " Deletado com sucesso!";
	}

	@ApiOperation("Endpoint responsável para atualizar um produto")
	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public Ambiente atualizar(@PathVariable Long id, @RequestBody Ambiente local) {
		return localService.atualizar(id, local);

	}
}
