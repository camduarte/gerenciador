package ar.com.camd.gerenciador.servlet;

import java.io.IOException;

import ar.com.camd.gerenciador.accion.Accion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAccion = request.getParameter("accion");
		HttpSession sesion = request.getSession();

		boolean esUsuarioNoLogueado = sesion.getAttribute("usuario") == null;
		boolean esAccionProtegida = !(paramAccion.equals("MostrarLoginForm") || paramAccion.equals("Login")); 
	
		// Si el usuario no está logueado redirecciona al formulario de login.
		if (esUsuarioNoLogueado && esAccionProtegida) {
			response.sendRedirect("entrada?accion=MostrarLoginForm");
			return;
		}

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