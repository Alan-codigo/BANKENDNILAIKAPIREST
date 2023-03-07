package com.nilaik.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nilaik.apirest.model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Integer>{
}
