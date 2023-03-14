package ar.com.camd.gerenciador.servlet;

import java.io.IOException;

import ar.com.camd.gerenciador.modelo.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EliminarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Eliminar empresa Servlet");
		Integer id = Integer.valueOf(request.getParameter("id"));
		DB db = new DB();
		db.eliminarEmpresa(id);
		response.sendRedirect("listaEmpresas");
	}

}
