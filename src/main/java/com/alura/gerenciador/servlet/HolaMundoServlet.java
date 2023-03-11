package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hola")
public class HolaMundoServlet extends HttpServlet {

	private static final long serialVersionUID = 3811992510078247633L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hola Mundo! Felicitaciones por crear tu primer Servlet!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}