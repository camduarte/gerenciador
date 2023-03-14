package ar.com.cam.gerenciador.accion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ar.com.camd.gerenciador.modelo.DB;
import ar.com.camd.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresa {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String fecha = request.getParameter("fecha");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaAbertura = null;
		try {
			fechaAbertura = sdf.parse(fecha);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNombre(nombre);
		empresa.setFechaAbertura(fechaAbertura);

		DB baseDatos = new DB();
		baseDatos.agregar(empresa);

		return "redirect:entrada?accion=listaEmpresas";
	}

}
