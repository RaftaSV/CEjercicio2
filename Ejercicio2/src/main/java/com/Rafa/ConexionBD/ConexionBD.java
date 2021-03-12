package com.Rafa.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	private Connection con;

	public ConexionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/appbanco", "root", "root");
			System.out.println("CONECTADO A LA BD");

		} catch (Exception e) {
			System.out.println("ERROR DE CONEXION A LA BD " + e);
		}
	}

	public Connection retornarConexion() {
		return con;
	}

}
