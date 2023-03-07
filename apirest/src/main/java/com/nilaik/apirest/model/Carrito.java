package com.nilaik.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcarrito")
	private int id_carrito;
	
	@Column(name = "idpedidoactual")
	private int idpedidoactual;
	
	Carrito(){
		
	}

	public int getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}

	public int getIdpedidoactual() {
		return idpedidoactual;
	}

	public void setIdpedidoactual(int idpedidoactual) {
		this.idpedidoactual = idpedidoactual;
	}
	
}
