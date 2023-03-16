package ar.com.camd.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DB {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer llaveSecuencialEmpresas = 1;
	private static Integer llaveSecuencialUsuarios = 1;

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(DB.llaveSecuencialEmpresas++);
		empresa1.setNombre("Alura");
		empresa1.setFechaAbertura(new Date());
		Empresa empresa2 = new Empresa();
		empresa2.setId(DB.llaveSecuencialEmpresas++);
		empresa2.setNombre("Caelum");
		empresa2.setFechaAbertura(new Date());

		DB.listaEmpresas.add(empresa1);
		DB.listaEmpresas.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setId(llaveSecuencialUsuarios++);
		u1.setLogin("christian");
		u1.setContrasena("12345");
		Usuario u2 = new Usuario();
		u2.setId(llaveSecuencialUsuarios++);
		u2.setLogin("ariel");
		u2.setContrasena("qwerty");

		DB.listaUsuarios.add(u1);
		DB.listaUsuarios.add(u2);
	}

	public void agregar(Empresa empresa) {
		empresa.setId(DB.llaveSecuencialEmpresas++);
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

	public static List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public Usuario buscarUsuario(String login) {
		return DB.listaUsuarios.stream().filter(us -> us.getLogin().equals(login)).findFirst().get();
	}
}