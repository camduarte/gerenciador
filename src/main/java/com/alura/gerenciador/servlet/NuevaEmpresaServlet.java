package com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("nueva empresa resgistrada");

		String nombre = request.getParameter("nombre");
		Empresa empresa = new Empresa();
		empresa.setNombre(nombre);

		DB baseDatos = new DB();
		baseDatos.agregar(empresa);

		RequestDispatcher rd = request.getRequestDispatcher("/nuevaEmpresaRegistrada.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);
	}

}
