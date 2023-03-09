package com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class DB {
	
	public static List<Empresa> listaEmpresas = new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNombre("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNombre("Caelum");

		DB.listaEmpresas.add(empresa1);
		DB.listaEmpresas.add(empresa2);
	}
	
	public void agregar(Empresa empresa) {
		DB.getListaEmpresas().add(empresa);
	}

	public static List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

}