package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Pessoa;
import com.sistema.inventario.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> obterTodos() {
        
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> obterPorId(Long id) {

        return pessoaRepository.findById(id);

    }
  

    public Pessoa adicionar(Pessoa pessoa) {

    	pessoa.setId(null);
        return pessoaRepository.save(pessoa);

    }

    public void deletar(Long id) {
    	pessoaRepository.deleteById(id);
    }

    public Pessoa atualizar(Long id, Pessoa pessoa) {
   
    	pessoa.setId(id);
        return pessoaRepository.save(pessoa);

    }
}
