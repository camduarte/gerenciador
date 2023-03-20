package ar.com.camd.gerenciador.servlet;

import java.io.IOException;

import ar.com.camd.gerenciador.accion.Accion;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("ControladorFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String paramAccion = request.getParameter("accion");

		String datos = null;
		Accion accion;
		try {
			Class clase = Class.forName("ar.com.camd.gerenciador.accion."+paramAccion);
			accion = (Accion)clase.newInstance();
			datos = accion.ejecutar(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		String[] tipoDireccion = datos.split(":");
		if (tipoDireccion[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoDireccion[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoDireccion[1]);
		}
	}
}