package ar.com.camd.gerenciador.accion;

import java.io.IOException;

import ar.com.camd.gerenciador.modelo.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EliminarEmpresa implements Accion {
	
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		DB db = new DB();
		db.eliminarEmpresa(id);
		return "redirect:entrada?accion=ListaEmpresas";
	}

}
