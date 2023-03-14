package ar.com.cam.gerenciador.accion;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresaForm {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		return "forward:formNuevaEmpresa.jsp";
	}
}
