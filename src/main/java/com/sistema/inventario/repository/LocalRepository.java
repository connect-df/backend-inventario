package com.sistema.inventario.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.model.Ambiente;

	public interface LocalRepository extends JpaRepository<Ambiente, Long> {

}
