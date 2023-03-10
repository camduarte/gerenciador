package com.alura.gerenciador.servlet;

import java.util.Date;

public class Empresa {
	private int id;
	private String nombre;
	private Date fechaAbertura;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaAbertura() {
		return fechaAbertura;
	}
	public void setFechaAbertura(Date fechaAbertura) {
		this.fechaAbertura = fechaAbertura;
	}

}
