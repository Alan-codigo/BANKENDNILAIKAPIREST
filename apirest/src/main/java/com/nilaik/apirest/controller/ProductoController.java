package com.nilaik.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nilaik.apirest.model.Producto;
import com.nilaik.apirest.repository.ProductoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/")
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable(value = "id") Integer productoId) {
        Producto producto = productoRepository.findById(productoId).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(producto);
    }

    @PostMapping("/")
    public Producto crearProducto(@Valid @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable(value = "id") Integer productoId, @Valid @RequestBody Producto producto) {
        Producto productoExistente = productoRepository.findById(productoId).orElse(null);
        if (productoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        productoExistente.setArticulo(producto.getArticulo());
        productoExistente.setMarca(producto.getMarca());
        productoExistente.setTalla(producto.getTalla());
        productoExistente.setCodigo(producto.getCodigo());
        productoExistente.setColor(producto.getColor());
        productoExistente.setPrecioMayoreo(producto.getPrecioMayoreo());
        productoExistente.setPrecioMenudeo(producto.getPrecioMenudeo());
        productoExistente.setExistencias(producto.getExistencias());
        productoExistente.setImgproducto_idimgproducto(producto.getImgproducto_idimgproducto());
        Producto productoActualizado = productoRepository.save(productoExistente);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable(value = "id") Integer productoId) {
        Producto productoExistente = productoRepository.findById(productoId).orElse(null);
        if (productoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        productoRepository.delete(productoExistente);
        return ResponseEntity.ok().build();
    }
}

