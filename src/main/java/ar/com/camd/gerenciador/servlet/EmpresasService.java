package ar.com.camd.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import ar.com.camd.gerenciador.modelo.DB;
import ar.com.camd.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = DB.getListaEmpresas();

		String formato = request.getHeader("Accept");
		
		if (formato.contains("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			response.setContentType("Application/json");
			response.getWriter().print(json);
		} else if (formato.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class); // Reemplazo el nombre completo de la clase con un alias.
			String xml = xstream.toXML(empresas);
			
			response.setContentType("Application/xml");
			response.getWriter().print(xml);
		} else {
			response.setContentType("Application/json");
			response.getWriter().print("{'message': 'no content'}");
		}

	}

}
