package com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DB db = new DB();
		Empresa empresa = db.findEmpresa(id);
		request.setAttribute("empresa", empresa);
		RequestDispatcher rd =  request.getRequestDispatcher("/mostrarEmpresa.jsp");
		rd.forward(request, response);
	}

}
