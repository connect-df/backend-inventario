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

@RestController
@RequestMapping("/api/local")
public class LocalController {

	@Autowired
	private LocalService localService;

//	@Autowired
//	private LocalRepository LocalRepository;

<<<<<<< HEAD
	@CrossOrigin(origins = "*")
=======
>>>>>>> 327efd27d9b5580642621972c175ca36f459efdf
	@GetMapping
	public List<Ambiente> obterTodos() {
		return localService.obterTodos();
	}
<<<<<<< HEAD

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Optional<Ambiente> obterporId(@PathVariable Long id) {
		return localService.obterPorId(id);
	}

//	    @GetMapping("/por-tipo")
//	    public List<Local> obterporTipo(String tipo) {
//	    	return LocalRepository.findByTipoContaining(tipo);
//	    }

	@CrossOrigin(origins = "*")
	@PostMapping
	public Ambiente adicionar(@RequestBody Ambiente local) {
		return localService.adicionar(local);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		localService.deletar(id);
		return "Local com id: " + id + " Deletado com sucesso!";
	}

	@CrossOrigin(origins = "*")
=======

	@GetMapping("/{id}")
	public Optional<Ambiente> obterporId(@PathVariable Long id) {
		return localService.obterPorId(id);
	}

	@PostMapping
	public Ambiente adicionar(@RequestBody Ambiente local) {
		return localService.adicionar(local);

	}

	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		localService.deletar(id);
		return "Local com id: " + id + " Deletado com sucesso!";
	}

>>>>>>> 327efd27d9b5580642621972c175ca36f459efdf
	@PutMapping("/{id}")
	public Ambiente atualizar(@PathVariable Long id, @RequestBody Ambiente local) {
		return localService.atualizar(id, local);

	}
}
