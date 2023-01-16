package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Ambiente;
import com.sistema.inventario.repository.LocalRepository;

@Service
public class LocalService {

	@Autowired
    private LocalRepository localRepository;

    public List<Ambiente> obterTodos() {
        
        return localRepository.findAll();
    }

    public Optional<Ambiente> obterPorId(Long id) {

        return localRepository.findById(id);

    }
    
    
//    public Optional<Local> obterPorTipo(String tipo) {
//
//        return LocalRepository.findByTipo(tipo);
//
//    }

    public Ambiente adicionar(Ambiente local) {

    	local.setId(null);
        return localRepository.save(local);

    }

    public void deletar(Long id) {
    	localRepository.deleteById(id);
    }

    public Ambiente atualizar(Long id, Ambiente local) {
   
    	local.setId(id);
        return localRepository.save(local);

    }
    

}
