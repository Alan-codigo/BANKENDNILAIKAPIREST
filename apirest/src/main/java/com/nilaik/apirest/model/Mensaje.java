package com.nilaik.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensaje")
public class Mensaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mensaje")
	private int id_mensaje;
	
	@Column(name = "textomensaje")
	private String textomensaje;
	
	@Column(name = "mailmensaje")
	private String mailmensaje;
	
	@Column(name = "visto")
	private int visto;
	
	@Column(name = "idmensajecliente")
	private int idmensajecliente;
	
	public Mensaje(){
		
	}

	public int getId_mensaje() {
		return id_mensaje;
	}

	public void setId_mensaje(int id_mensaje) {
		this.id_mensaje = id_mensaje;
	}

	public String getTextomensaje() {
		return textomensaje;
	}

	public void setTextomensaje(String textomensaje) {
		this.textomensaje = textomensaje;
	}

	public String getMailmensaje() {
		return mailmensaje;
	}

	public void setMailmensaje(String mailmensaje) {
		this.mailmensaje = mailmensaje;
	}

	public int getVisto() {
		return visto;
	}

	public void setVisto(int visto) {
		this.visto = visto;
	}

	public int getIdmensajecliente() {
		return idmensajecliente;
	}

	public void setIdmensajecliente(int idmensajecliente) {
		this.idmensajecliente = idmensajecliente;
	}
}
