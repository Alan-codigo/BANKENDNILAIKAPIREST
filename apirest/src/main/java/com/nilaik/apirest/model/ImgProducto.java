package com.nilaik.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imgproducto")
public class ImgProducto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idimgproducto")
    private int idimgproducto;
    
    @Column(name = "url")
    private String url;

    public int getIdimgproducto() {
        return idimgproducto;
    }

    public void setIdimgproducto(int idimgproducto) {
        this.idimgproducto = idimgproducto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImgProducto [idimgproducto=" + idimgproducto + ", url=" + url + "]";
    }
    
}
