package com.nilaik.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nilaik.apirest.model.Carrito;
import com.nilaik.apirest.repository.CarritoRepository;

@RestController
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    @PostMapping("/carritos")
    public ResponseEntity<Carrito> addCarrito(@RequestBody Carrito carrito) {
        Carrito newCarrito = carritoRepository.save(carrito);
        return new ResponseEntity<Carrito>(newCarrito, HttpStatus.CREATED);
    }

    @GetMapping("/carritos")
    public ResponseEntity<List<Carrito>> getAllCarritos() {
        List<Carrito> carritos = carritoRepository.findAll();
        return new ResponseEntity<List<Carrito>>(carritos, HttpStatus.OK);
    }
    
    @PutMapping("/carritos/{id}")
    public ResponseEntity<Carrito> updateCarrito(@PathVariable(value = "id") int id, @RequestBody Carrito carritoDetails) {
        Carrito carrito = carritoRepository.findById(id).orElse(null);
        if (carrito == null) {
            return new ResponseEntity<Carrito>(HttpStatus.NOT_FOUND);
        }
        carrito.setPedido(carritoDetails.getPedido()); // actualiza el pedido del carrito
        Carrito updatedCarrito = carritoRepository.save(carrito);
        return new ResponseEntity<Carrito>(updatedCarrito, HttpStatus.OK);
    }


    @GetMapping("/carritos/{id}")
    public ResponseEntity<Carrito> getCarritoById(@PathVariable(value = "id") int id) {
        Carrito carrito = carritoRepository.findById(id).orElse(null);
        if (carrito == null) {
            return new ResponseEntity<Carrito>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Carrito>(carrito, HttpStatus.OK);
    }

    @DeleteMapping("/carritos/{id}")
    public ResponseEntity<Void> deleteCarrito(@PathVariable(value = "id") int id) {
        Carrito carrito = carritoRepository.findById(id).orElse(null);
        if (carrito == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        carritoRepository.delete(carrito);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
