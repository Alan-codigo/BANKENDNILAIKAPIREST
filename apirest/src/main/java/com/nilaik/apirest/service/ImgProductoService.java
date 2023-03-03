package com.nilaik.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilaik.apirest.repository.ImgProductoRepository;
import com.nilaik.apirest.model.ImgProducto;

@Service
public class ImgProductoService {
    
    @Autowired
    private ImgProductoRepository imgProductoRepository;
    
    public List<ImgProducto> getAllImgProductos() {
        return imgProductoRepository.findAll();
    }
    
    public Optional<ImgProducto> getImgProductoById(Long id) {
        return imgProductoRepository.findById(id);
    }
    
    public ImgProducto createImgProducto(ImgProducto imgProducto) {
        return imgProductoRepository.save(imgProducto);
    }
    
    public Optional<ImgProducto> updateImgProducto(Long id, ImgProducto imgProductoDetails) {
        Optional<ImgProducto> imgProducto = imgProductoRepository.findById(id);
        if(imgProducto.isPresent()) {
            ImgProducto imgProductoToUpdate = imgProducto.get();
            imgProductoToUpdate.setUrl(imgProductoDetails.getUrl());
            return Optional.of(imgProductoRepository.save(imgProductoToUpdate));
        } else {
            return Optional.empty();
        }
    }
    
    public void deleteImgProducto(Long id) {
        Optional<ImgProducto> imgProducto = imgProductoRepository.findById(id);
        imgProducto.ifPresent(imgProductoRepository::delete);
    }
    
}
