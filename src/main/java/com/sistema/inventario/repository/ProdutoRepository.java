package com.sistema.inventario.repository;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 327efd27d9b5580642621972c175ca36f459efdf

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.inventario.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByCodigo(String codigo);

}
