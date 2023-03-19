package ar.com.camd.gerenciador.accion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginForm implements Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Mostrar Login Form Accion");
		return "forward:formLogin.jsp";
	}
}