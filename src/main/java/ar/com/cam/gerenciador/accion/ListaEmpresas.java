package ar.com.cam.gerenciador.accion;

import java.io.IOException;
import java.util.List;

import ar.com.camd.gerenciador.modelo.DB;
import ar.com.camd.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresas {
	
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> listaEmpresas = DB.getListaEmpresas();
		request.setAttribute("empresas", listaEmpresas);
		return "forward:listaEmpresas.jsp";
	}

}
