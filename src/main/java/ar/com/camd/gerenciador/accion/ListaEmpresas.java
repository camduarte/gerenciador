package ar.com.camd.gerenciador.accion;

import java.io.IOException;
import java.util.List;

import ar.com.camd.gerenciador.modelo.DB;
import ar.com.camd.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresas implements Accion {
	
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> listaEmpresas = DB.getListaEmpresas();
		request.setAttribute("empresas", listaEmpresas);
		return "forward:listaEmpresas.jsp";
	}

}
