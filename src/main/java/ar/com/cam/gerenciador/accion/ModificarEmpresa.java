package ar.com.cam.gerenciador.accion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ar.com.camd.gerenciador.modelo.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarEmpresa {

	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String fecha = request.getParameter("fecha");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaAbertura = null;
		try {
			fechaAbertura = sdf.parse(fecha);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		DB baseDatos = new DB();
		baseDatos.modificarEmpresa(id, nombre, fechaAbertura);

		response.sendRedirect("entrada?accion=listaEmpresas");
	}

}
