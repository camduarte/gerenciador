package ar.com.cam.gerenciador.accion;

import java.io.IOException;

import ar.com.camd.gerenciador.modelo.DB;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EliminarEmpresa {
	
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		DB db = new DB();
		db.eliminarEmpresa(id);
		response.sendRedirect("entrada?accion=listaEmpresas");
	}

}
