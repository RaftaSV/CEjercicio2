package com.Rafa.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rafa.DAO.clsArchivos;
import com.google.gson.Gson;


/**
 * Servlet implementation class ControllerMostrarArchivos
 */
public class ControllerMostrarArchivos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerMostrarArchivos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
      clsArchivos archivo = new clsArchivos();
		
		//Gson se utiliza para convertir objetos Java
		Gson json = new Gson();
		
		//response es un objeto que contendrá la información que enviaremos como respuesta al navegador
		response.setContentType("application/json");
		
		//UTF-8 cadena de codificación
		response.setCharacterEncoding("UTF-8");
		
		//append cadena especificada a una secuencia de caracteres
		response.getWriter().append(json.toJson(archivo.archivos()));
		
	}

}
