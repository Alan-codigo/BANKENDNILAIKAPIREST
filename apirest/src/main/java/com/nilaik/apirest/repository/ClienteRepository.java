package com.nilaik.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nilaik.apirest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
}
