package com.nilaik.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nilaik.apirest.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
