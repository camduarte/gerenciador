package ar.com.cam.gerenciador.servlet;

import java.io.IOException;

import ar.com.cam.gerenciador.accion.EliminarEmpresa;
import ar.com.cam.gerenciador.accion.ListaEmpresas;
import ar.com.cam.gerenciador.accion.ModificarEmpresa;
import ar.com.cam.gerenciador.accion.MostrarEmpresa;
import ar.com.cam.gerenciador.accion.NuevaEmpresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		System.out.println(accion);

		switch (accion) {
		case "listaEmpresas":
			System.out.println("Lista de empresas");
			ListaEmpresas listaEmpresas = new ListaEmpresas();
			listaEmpresas.ejecutar(request, response);
			break;
		case "nuevaEmpresa":
			System.out.println("Nueva empresas");
			NuevaEmpresa nuevaEmpresas = new NuevaEmpresa();
			nuevaEmpresas.ejecutar(request, response);
			break;
		case "eliminarEmpresa":
			System.out.println("Eliminar empresa");
			EliminarEmpresa eliminarEmpresa = new EliminarEmpresa();
			eliminarEmpresa.ejecutar(request, response);
			break;
		case "mostrarEmpresa":
			System.out.println("Mostrar empresa");
			MostrarEmpresa mostrarEmpresa = new MostrarEmpresa();
			mostrarEmpresa.ejecutar(request, response);
			break;
		case "modificarEmpresa":
			System.out.println("Modificar empresa");
			ModificarEmpresa modificarEmpresa = new ModificarEmpresa();
			modificarEmpresa.ejecutar(request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + accion);
		}
	}

}