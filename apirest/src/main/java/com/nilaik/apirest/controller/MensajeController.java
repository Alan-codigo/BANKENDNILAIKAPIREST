package com.nilaik.apirest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nilaik.apirest.model.Mensaje;
import com.nilaik.apirest.repository.MensajeRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MensajeController {

	
	@Autowired
	private MensajeRepository mensajerepository;
	
	@GetMapping("/mensajes")
	public ResponseEntity<List<Mensaje>> getAllMensajes(){
		List<Mensaje> mensaje = mensajerepository.findAll();
		return new ResponseEntity<List<Mensaje>>(mensaje,HttpStatus.OK);
	}
	
	@PostMapping("/mensajes")
	public ResponseEntity<Mensaje> addMensaje(@RequestBody Mensaje mensaje){
	Mensaje mensajeguardado = mensajerepository.save(mensaje);
	return new ResponseEntity<Mensaje>(mensajeguardado, HttpStatus.CREATED);
	} 
	
	//FALTA SERVICE, PUT Y DELETE

	
}
