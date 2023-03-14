package ar.com.cam.gerenciador.accion;

import java.io.IOException;

import ar.com.camd.gerenciador.modelo.DB;
import ar.com.camd.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostrarEmpresa {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		DB db = new DB();
		Empresa empresa = db.buscarEmpresa(id);
		request.setAttribute("empresa", empresa);
		return "forward:mostrarEmpresa.jsp";
	}
}
