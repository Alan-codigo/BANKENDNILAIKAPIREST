package com.nilaik.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nilaik.apirest.model.ImgProducto;

@Repository
public interface ImgProductoRepository extends JpaRepository<ImgProducto, Long> {
	
    // aquí podrías definir métodos adicionales para acceder a los datos de la tabla, 
    // por ejemplo, buscar imágenes por URL o por idimgproducto
	
}
