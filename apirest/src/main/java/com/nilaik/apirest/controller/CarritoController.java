package com.nilaik.apirest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nilaik.apirest.model.Carrito;
import com.nilaik.apirest.repository.CarritoRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarritoController {

	@Autowired
	private CarritoRepository carritorepository;
	
	@GetMapping("/carrito")
	public ResponseEntity<List<Carrito>> getAllCarrito(){
		List<Carrito> Carrito = carritorepository.findAll();
		return new ResponseEntity<List<Carrito>>(Carrito,HttpStatus.OK );
	}
	
	@PostMapping("/carrito")
	public ResponseEntity<Carrito> addCarrito(@RequestBody Carrito carrito) {
	    Carrito carritoguardado = carritorepository.save(carrito);
	    return new ResponseEntity<Carrito>(carritoguardado, HttpStatus.CREATED);
	}
}
