package ar.com.camd.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class); // Reemplazo el nombre completo de la clase con un alias.
		String xml = xstream.toXML(empresas);
		
		PrintWriter out = response.getWriter();
		response.setContentType("Application/xml");
		out.print(xml);
		
//		Gson gson = new Gson();
//		String json = gson.toJson(empresas);
//		
//		PrintWriter out = response.getWriter();
//		response.setContentType("Application/json");
//		out.print(json);
	}

}
