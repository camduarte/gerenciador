package ar.com.camd.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//Pongo la conciguraconi en el web.xml
//@WebFilter(urlPatterns = "/entrada")
public class AutorizacionFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("AutorizacionFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAccion = request.getParameter("accion");
		HttpSession sesion = request.getSession();

		boolean esUsuarioNoLogueado = sesion.getAttribute("usuario") == null;
		boolean esAccionProtegida = !(paramAccion.equals("LoginForm") || paramAccion.equals("Login")); 

		// Si el usuario no está logueado redirecciona al formulario de login.
		if (esUsuarioNoLogueado && esAccionProtegida) {
			response.sendRedirect("entrada?accion=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}
}