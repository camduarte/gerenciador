package ar.com.cam.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ar.com.camd.gerenciador.modelo.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 9202896330278089685L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Modificar empresa Servlet");

		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		String fecha = req.getParameter("fecha");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaAbertura = null;
		try {
			fechaAbertura = sdf.parse(fecha);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		DB baseDatos = new DB();
		baseDatos.modificarEmpresa(id, nombre, fechaAbertura);

		resp.sendRedirect("listaEmpresas");
	}
}