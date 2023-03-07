package com.nilaik.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nilaik.apirest.model.Relacion;
import com.nilaik.apirest.repository.RelacionRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RelacionController {

	@Autowired
	private RelacionRepository relacionrepository;
	
	@GetMapping("/relacion")
	public ResponseEntity<List<Relacion>> getallRelaciones(){
		List<Relacion> relacion = relacionrepository.findAll();
		return new ResponseEntity<List<Relacion>>(relacion,HttpStatus.OK);
	}
	
	@PostMapping("/relacion")
	public ResponseEntity<Relacion> addRelacion(@RequestBody Relacion relacion){
		Relacion relacionguardada = relacionrepository.save(relacion);
		return new ResponseEntity<Relacion>(relacionguardada, HttpStatus.CREATED);
	}
}
