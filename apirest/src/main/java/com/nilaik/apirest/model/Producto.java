package com.nilaik.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;
    
    @Column(name = "articulo", nullable = false, length = 50)
    private String articulo;
    
    @Column(name = "marca", nullable = false, length = 45)
    private String marca;
    
    @Column(name = "talla", nullable = false)
    private Integer talla;
    
    @Column(name = "codigo", nullable = false, length = 45)
    private String codigo;
    
    @Column(name = "color", nullable = false, length = 45)
    private String color;
    
    @Column(name = "precio_mayoreo", nullable = false)
    private Integer precioMayoreo;
    
    @Column(name = "precio_menudeo", nullable = false)
    private Integer precioMenudeo;
    
    @Column(name = "existencias", nullable = false)
    private Integer existencias;
    
    @Column(name = "imgproducto_idimgproducto", nullable = false)
    private Integer imgproducto_idimgproducto;
    


    public Producto(){
    	
    }
    
    /*
     * 
    public Producto(String articulo, String marca, 
    		Integer talla, String codigo, String color, Integer 
    		precioMayoreo, Integer precioMenudeo, Integer existencias, 
    		Integer imgproducto_idimgproducto) {
        this.articulo = articulo;
        this.marca = marca;
        this.talla = talla;
        this.codigo = codigo;
        this.color = color;
        this.precioMayoreo = precioMayoreo;
        this.precioMenudeo = precioMenudeo;
        this.existencias = existencias;
        this.imgproducto_idimgproducto = imgproducto_idimgproducto;
    }
     */


	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getTalla() {
		return talla;
	}

	public void setTalla(Integer talla) {
		this.talla = talla;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrecioMayoreo() {
		return precioMayoreo;
	}

	public void setPrecioMayoreo(Integer precioMayoreo) {
		this.precioMayoreo = precioMayoreo;
	}

	public Integer getPrecioMenudeo() {
		return precioMenudeo;
	}

	public void setPrecioMenudeo(Integer precioMenudeo) {
		this.precioMenudeo = precioMenudeo;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	public Integer getImgproducto_idimgproducto() {
		return imgproducto_idimgproducto;
	}

	public void setImgproducto_idimgproducto(Integer imgproducto_idimgproducto) {
		this.imgproducto_idimgproducto = imgproducto_idimgproducto;
	}   
}
