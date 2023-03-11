package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nueva empresa resgistrada");

		String nombre = request.getParameter("nombre");
		String fecha = request.getParameter("fecha");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaAbertura = null;
		try {
			fechaAbertura = sdf.parse(fecha);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNombre(nombre);
		empresa.setFechaAbertura(fechaAbertura);

		DB baseDatos = new DB();
		baseDatos.agregar(empresa);

		response.sendRedirect("listaEmpresas");
	}

}
