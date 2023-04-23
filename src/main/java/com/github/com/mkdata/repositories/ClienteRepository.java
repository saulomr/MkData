package com.github.com.mkdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.com.mkdata.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
