package ar.com.camd.gerenciador.accion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout implements Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession sesion = request.getSession();

//		sesion.removeAttribute("usuario");

		sesion.invalidate(); // Elimina todos los atributos y crea un nuevo sessionid.

		return "redirect:entrada?accion=LoginForm";
	}
}