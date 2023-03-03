package com.nilaik.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilaik.apirest.model.Producto;
import com.nilaik.apirest.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> listarProductos() {
		return productoRepository.findAll();
	}
	
	public Producto obtenerProducto(Integer idProducto) {
		return productoRepository.findById(idProducto).orElse(null);
	}
	
	public Producto crearProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public Producto actualizarProducto(Integer idProducto, Producto producto) {
		Producto productoActual = productoRepository.findById(idProducto).orElse(null);
		if (productoActual != null) {
			productoActual.setArticulo(producto.getArticulo());
			productoActual.setMarca(producto.getMarca());
			productoActual.setTalla(producto.getTalla());
			productoActual.setCodigo(producto.getCodigo());
			productoActual.setColor(producto.getColor());
			productoActual.setPrecioMayoreo(producto.getPrecioMayoreo());
			productoActual.setPrecioMenudeo(producto.getPrecioMenudeo());
			productoActual.setExistencias(producto.getExistencias());
			productoActual.setImgproducto_idimgproducto(producto.getImgproducto_idimgproducto());
			return productoRepository.save(productoActual);
		} else {
			return null;
		}
	}
	
	public void eliminarProducto(Integer idProducto) {
		productoRepository.deleteById(idProducto);
	}
}
