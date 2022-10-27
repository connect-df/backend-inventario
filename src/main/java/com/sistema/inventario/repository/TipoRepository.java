package com.sistema.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.inventario.model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {

}