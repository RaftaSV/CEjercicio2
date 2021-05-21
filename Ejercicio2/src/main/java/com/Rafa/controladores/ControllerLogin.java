package com.Rafa.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Rafa.Entidades.Loguin;
import com.Rafa.negocio.clsLoguin;

/**
 * Servlet implementation class ControllerLogin
 */
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession(true);

		String btncerrar = request.getParameter("btncerrar");

		if (btncerrar != null) {

			response.sendRedirect("Index.jsp");

			session.invalidate();
		} else {
			
			
			
		

			String user = request.getParameter("user");
			String pass = request.getParameter("pass");

			Loguin log = new Loguin();

			log.setUser(user);
			log.setPass(pass);

		clsLoguin cls = new clsLoguin();

		boolean resultado = cls.Login(log);

		if (resultado == true) {

			session.setAttribute("usuario", resultado);
			int tipo = cls.tipo;
			if (tipo == 1) {
				response.sendRedirect("Saludo.jsp");
			} else {

				response.sendRedirect("Usuario.jsp");

			}
		} else {
			response.sendRedirect("Error.jsp");

		}
	}
	}
}
