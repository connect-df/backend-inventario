package com.sistema.inventario.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.inventario.model.Produto;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.data.jpa.repository.Query;

	@Repository
	public interface ProdutoRepository extends JpaRepository<Produto, Long> {

//		@Query("from Produto where tipo like %:tipo%")
//		Optional<Produto> consultarTipo(String tipo);
		
//		List<Produto> findByTipoContaining(tipo);
		
}
