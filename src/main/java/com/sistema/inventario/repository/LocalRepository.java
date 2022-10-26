package com.sistema.inventario.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistema.inventario.model.Ambiente;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.data.jpa.repository.Query;

	@Repository
	public interface LocalRepository extends JpaRepository<Ambiente, Long> {

//		@Query("from Produto where tipo like %:tipo%")
//		Optional<Produto> consultarTipo(String tipo);
		
//		List<Produto> findByTipoContaining(String tipo);
		
}
