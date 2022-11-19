package com.venta.venta.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "emisor",nullable = false)
    private String emisor;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;
    private Date fecha;
    private String valor;

	public Factura() {
    }
    public Factura(long id, String emisor, String descripcion, Date fecha, String valor) {
        this.id = id;
        this.emisor = emisor;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.valor = valor;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getEmisor() {
        return emisor;
    }


    public void setEmisor(String nombre) {
        this.emisor = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String apellido) {
        this.descripcion = apellido;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fechaNacimiento) {
        this.fecha = fechaNacimiento;
    }


    public String getValor() {
        return valor;
    }


    public void setValor(String valor) {
        this.valor = valor;
    }

	
}
