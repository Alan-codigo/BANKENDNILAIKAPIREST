package com.nilaik.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nilaik.apirest.model.ImgProducto;
import com.nilaik.apirest.repository.ImgProductoRepository;

@RestController
@RequestMapping("/imgproductos")
public class ImgProductoController {
    
    @Autowired
    private ImgProductoRepository imgProductoRepository;
    
    @GetMapping("/")
    public ResponseEntity<List<ImgProducto>> getAllImgProductos() {
        List<ImgProducto> imgProductos = imgProductoRepository.findAll();
        return new ResponseEntity<List<ImgProducto>>(imgProductos, HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ImgProducto> getImgProductoById(@PathVariable(value = "id") Long id) {
        Optional<ImgProducto> imgProducto = imgProductoRepository.findById(id);
        if(imgProducto.isPresent()) {
            return new ResponseEntity<ImgProducto>(imgProducto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/")
    public ImgProducto createImgProducto(@RequestBody ImgProducto imgProducto) {
        return imgProductoRepository.save(imgProducto);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ImgProducto> updateImgProducto(@PathVariable(value = "id") Long id, 
            @RequestBody ImgProducto imgProductoDetails) {
        Optional<ImgProducto> imgProducto = imgProductoRepository.findById(id);
        if(imgProducto.isPresent()) {
            ImgProducto imgProductoToUpdate = imgProducto.get();
            imgProductoToUpdate.setUrl(imgProductoDetails.getUrl());
            ImgProducto updatedImgProducto = imgProductoRepository.save(imgProductoToUpdate);
            return new ResponseEntity<ImgProducto>(updatedImgProducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImgProducto(@PathVariable(value = "id") Long id) {
        Optional<ImgProducto> imgProducto = imgProductoRepository.findById(id);
        if(imgProducto.isPresent()) {
            imgProductoRepository.delete(imgProducto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
