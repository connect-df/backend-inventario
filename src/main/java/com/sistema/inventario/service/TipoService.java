package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Tipo;
import com.sistema.inventario.repository.TipoRepository;

@Service
public class TipoService {

	@Autowired
	private TipoRepository tipoRepository;

	public List<Tipo> obterTodos() {

		return tipoRepository.findAll();
	}

	public Optional<Tipo> obterPorId(Long id) {

		return tipoRepository.findById(id);

	}

	public Tipo adicionar(Tipo tipo) {

		tipo.setId(null);
		return tipoRepository.save(tipo);

	}

	public void deletar(Long id) {
		tipoRepository.deleteById(id);
	}

	public Tipo atualizar(Long id, Tipo tipo) {

		tipo.setId(id);
		return tipoRepository.save(tipo);

	}

}
