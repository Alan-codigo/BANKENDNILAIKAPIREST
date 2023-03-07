package com.nilaik.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nilaik.apirest.model.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer>{

}
