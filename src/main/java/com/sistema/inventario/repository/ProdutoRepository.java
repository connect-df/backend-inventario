package com.sistema.inventario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.model.Ambiente;
import com.sistema.inventario.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Optional<Produto> findByCodigo(String codigo);

	List<Produto> findByAmbiente(Ambiente ambiente);
	 
}
