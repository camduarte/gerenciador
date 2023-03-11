package com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DB {
	
	public static List<Empresa> listaEmpresas = new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNombre("Alura");
		empresa1.setFechaAbertura(new Date());
		empresa1.setId(200000);
		Empresa empresa2 = new Empresa();
		empresa2.setNombre("Caelum");
		empresa2.setFechaAbertura(new Date());
		empresa2.setId(300000);
		
		DB.listaEmpresas.add(empresa1);
		DB.listaEmpresas.add(empresa2);
	}
	
	public void agregar(Empresa empresa) {
		DB.getListaEmpresas().add(empresa);
	}

	public static List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	
	public void eliminarEmpresa(int id) {
		DB.listaEmpresas.removeIf(e -> e.getId() == id);
	}
	
	public Empresa findEmpresa(int id) {
		return DB.getListaEmpresas().stream().filter(e -> e.getId() == id).findFirst().get();
	}
	
	public Empresa modificarEmpresa(int id, String nombre, Date fecha) {
		Empresa empresa = this.findEmpresa(id);
		DB.getListaEmpresas().remove(empresa);
		empresa.setNombre(nombre);
		empresa.setFechaAbertura(fecha);
		this.agregar(empresa);
		return empresa;
	}  

}