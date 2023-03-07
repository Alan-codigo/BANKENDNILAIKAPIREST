package com.nilaik.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nilaik.apirest.model.Cliente;
import com.nilaik.apirest.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController{

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") int id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        try {
            Cliente newCliente = clienteRepository.save(cliente);
            // Asignar el idCliente al carritoIdCarrito
            newCliente.setCarritoIdCarrito(newCliente.getIdCliente());
            clienteRepository.save(newCliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") int id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteData = clienteRepository.findById(id);

        if (clienteData.isPresent()){
            Cliente updatedCliente = clienteData.get();
            updatedCliente.setUsername(cliente.getUsername());
            updatedCliente.setLastname(cliente.getLastname());
            updatedCliente.setEmail(cliente.getEmail());
            updatedCliente.setPassword(cliente.getPassword());
            updatedCliente.setBorn(cliente.getBorn());
            updatedCliente.setAdress(cliente.getAdress());

            return ResponseEntity.ok(clienteRepository.save(updatedCliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") int id) {
        try {
            clienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
