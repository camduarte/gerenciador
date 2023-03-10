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
		Empresa empresa2 = new Empresa();
		empresa2.setNombre("Caelum");
		empresa2.setFechaAbertura(new Date());

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