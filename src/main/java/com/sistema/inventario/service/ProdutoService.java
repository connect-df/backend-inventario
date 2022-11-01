package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Produto;
import com.sistema.inventario.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos() {
        
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Long id) {

        return produtoRepository.findById(id);

    }
    
    
    public Produto adicionar(Produto produto) {

    	produto.setId(null);
        return produtoRepository.save(produto);

    }

    public void deletar(Long id) {
    	produtoRepository.deleteById(id);
    }

    public Produto atualizar(Long id, Produto produto) {
   
    	produto.setId(id);
        return produtoRepository.save(produto);

    }
    
    public Optional<Produto> obterPorCodigo(String codigo) {

        return produtoRepository.findByCodigo(codigo);

    }
    
}
