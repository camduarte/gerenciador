package ar.com.camd.gerenciador.accion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresaForm implements Accion {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		return "forward:formNuevaEmpresa.jsp";
	}
}
