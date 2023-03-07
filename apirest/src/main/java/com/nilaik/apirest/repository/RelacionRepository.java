package com.nilaik.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nilaik.apirest.model.Relacion;

public interface RelacionRepository extends JpaRepository<Relacion, Integer> {
}
