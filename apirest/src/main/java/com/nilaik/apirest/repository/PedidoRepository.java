package com.nilaik.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nilaik.apirest.model.Pedido;

public  interface PedidoRepository extends JpaRepository<Pedido, Integer>{
}

