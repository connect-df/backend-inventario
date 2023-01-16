package com.sistema.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
