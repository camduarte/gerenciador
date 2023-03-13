package ar.com.camd.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DB {

	public static List<Empresa> listaEmpresas = new ArrayList<>();
	private static Integer llaveSecuencial = 1;

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(DB.llaveSecuencial++);
		empresa1.setNombre("Alura");
		empresa1.setFechaAbertura(new Date());
		Empresa empresa2 = new Empresa();
		empresa2.setId(DB.llaveSecuencial++);
		empresa2.setNombre("Caelum");
		empresa2.setFechaAbertura(new Date());

		DB.listaEmpresas.add(empresa1);
		DB.listaEmpresas.add(empresa2);
	}

	public void agregar(Empresa empresa) {
		empresa.setId(DB.llaveSecuencial++);
		DB.getListaEmpresas().add(empresa);
	}

	public static List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void eliminarEmpresa(Integer id) {
		DB.listaEmpresas.removeIf(e -> e.getId() == id);
	}

	public Empresa buscarEmpresa(Integer id) {
		return DB.getListaEmpresas().stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public Empresa modificarEmpresa(Integer id, String nombre, Date fecha) {
		Empresa empresa = this.buscarEmpresa(id);
		empresa.setNombre(nombre);
		empresa.setFechaAbertura(fecha);
		return empresa;
	}  

}