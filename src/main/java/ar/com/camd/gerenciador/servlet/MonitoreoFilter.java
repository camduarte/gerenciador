package ar.com.camd.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//Pongo la conciguraconi en el web.xml
//@WebFilter(urlPatterns = "/entrada")
public class MonitoreoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MonitoreoFilter");

		long antes = System.currentTimeMillis();

		String accion = request.getParameter("accion");

		// Ejecución del controlador.
		chain.doFilter(request, response);

		long despues = System.currentTimeMillis();

		System.out.printf("Tiempo de ejecución de la acción: %s -> %d%n", accion, despues - antes);
	}

}
