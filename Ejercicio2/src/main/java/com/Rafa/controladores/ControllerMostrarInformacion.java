package com.Rafa.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rafa.DAO.ClsUsuarios;
import com.Rafa.Entidades.Usuario;
import com.google.gson.Gson;

/**
 * Servlet implementation class ControllerMostrarInformacion
 */
@WebServlet("/ControllerMostrarInformacion")
public class ControllerMostrarInformacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerMostrarInformacion() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ClsUsuarios cls = new ClsUsuarios();
		Usuario usu = new Usuario();
		
		usu.setIdUsuario(Integer.parseInt(request.getParameter("usu")));
		cls.Eliminar(usu);
		response.sendRedirect("Saludo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	  //	doGet(request, response);
		
		Gson json = new Gson();
		
		ClsUsuarios cls = new ClsUsuarios();
		
		response.getWriter().append(json.toJson(cls.MostrarUsuario()));
	}

}
