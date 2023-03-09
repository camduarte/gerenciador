package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("nueva empresa resgistrada");
		String nombreEmpresa = request.getParameter("nombre");
		
		Empresa empresa = new Empresa();
		empresa.setNombre(nombreEmpresa);
		
		DB baseDatos = new DB();
		baseDatos.agregar(empresa);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresa " + nombreEmpresa + " resgistrada!</body></html>");
	}

}
