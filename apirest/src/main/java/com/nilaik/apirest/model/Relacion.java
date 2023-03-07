package com.nilaik.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "relacion")
public class Relacion {
	
	@Id
	@Column(name = "numeroproducto")
	private int numeroproducto;
	
	@Column(name = "numeropedido")
	private int numeropedido;
	
	public Relacion(){
		
	}

	public int getNumeroproducto() {
		return numeroproducto;
	}

	public void setNumeroproducto(int numeroproducto) {
		this.numeroproducto = numeroproducto;
	}

	public int getNumeropedido() {
		return numeropedido;
	}

	public void setNumeropedido(int numeropedido) {
		this.numeropedido = numeropedido;
	}
}

