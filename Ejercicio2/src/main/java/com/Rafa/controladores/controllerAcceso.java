package com.Rafa.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rafa.DAO.ClsUsuarios;
import com.Rafa.Entidades.Loguin;
import com.Rafa.Entidades.Usuario;
import com.Rafa.negocio.clsLoguin;


/**
 * Servlet implementation class controllerAcceso
 */
@WebServlet("/controllerAcceso")
public class controllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public controllerAcceso() {
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
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		Loguin log = new Loguin();
		
		clsLoguin clsl = new clsLoguin();
		
		log.setUser(user);
		log.setPass(pass);
		
		int valoresdeacceso=clsl.acceso(log);
		
		if(valoresdeacceso==1) {
			
			System.out.println("Bienvenido");
			ClsUsuarios cls = new ClsUsuarios();
			ArrayList<Usuario> lista= cls.MostrarUsuario();
			for(var i : lista) {
				
				System.out.println(i.getUsuario() +" " + i.getPassWord());
			}
			
			response.sendRedirect("Saludo.jsp");
		}else {
			
			System.out.println("Error en los datos");
			response.sendRedirect("Error.jsp");
		}
		
		
	}

}
