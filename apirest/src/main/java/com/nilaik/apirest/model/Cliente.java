package com.nilaik.apirest.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private int idCliente;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "born", nullable = false)
    private Date born;

    @Column(name = "adress", nullable = false, length = 150)
    private String adress;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrito_idcarrito", nullable = true)
    private int carritoIdCarrito;

    public Cliente(){
    }

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getCarritoIdCarrito() {
		return carritoIdCarrito;
	}

	public void setCarritoIdCarrito(int carritoIdCarrito) {
		this.carritoIdCarrito = carritoIdCarrito;
	}
    
}
