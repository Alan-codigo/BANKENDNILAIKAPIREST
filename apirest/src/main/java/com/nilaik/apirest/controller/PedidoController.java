package com.nilaik.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nilaik.apirest.model.Pedido;
import com.nilaik.apirest.repository.PedidoRepository;

@RestController
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> getAllPedidos() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
	}
	
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") int id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if(pedido.isPresent()) {
			return new ResponseEntity<Pedido>(pedido.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> addPedido(@RequestBody Pedido pedido) {
		Pedido savedPedido = pedidoRepository.save(pedido);
		return new ResponseEntity<Pedido>(savedPedido, HttpStatus.CREATED);
	}
	
	@PutMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable("id") int id, @RequestBody Pedido pedido) {
		Optional<Pedido> pedidoData = pedidoRepository.findById(id);
		if(pedidoData.isPresent()) {
			Pedido updatedPedido = pedidoData.get();
			updatedPedido.setFecha_pedido(pedido.getFecha_pedido());
			updatedPedido.setId_cliente(pedido.getId_cliente());
			pedidoRepository.save(updatedPedido);
			return new ResponseEntity<Pedido>(updatedPedido, HttpStatus.OK);
		} else {
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<HttpStatus> deletePedido(@PathVariable("id") int id) {
		try {
			pedidoRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
