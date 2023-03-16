package ar.com.camd.gerenciador.accion;

import java.io.IOException;

import ar.com.camd.gerenciador.modelo.DB;
import ar.com.camd.gerenciador.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login implements Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String login = request.getParameter("login");
		String contrasena = request.getParameter("contrasena");
		System.out.println(login);
		System.out.println(contrasena);

		DB db = new DB();
		Usuario us = db.buscarUsuario(login);

		String url = null;
		if (us != null && us.esIgual(login, contrasena)) {
			System.out.println("USUARIO LOGUEADO");
			url = "redirect:entrada?accion=ListaEmpresas";
		} else {
			System.out.println("USUARIO NO LOGUEADO");
			url = "redirect:entrada?accion=MostrarLoginForm";
		}
		return url;
	}
}