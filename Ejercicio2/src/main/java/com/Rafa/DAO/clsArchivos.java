package com.Rafa.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Rafa.ConexionBD.ConexionBD;
import com.mysql.cj.jdbc.CallableStatement;

public class clsArchivos {
	ConexionBD con = new ConexionBD();
	 Connection coneccion = con.retornarConexion();
	public ArrayList<String> archivos (){
		 ArrayList<String > lista = new ArrayList<>();
		 try {
			 CallableStatement st = (CallableStatement) coneccion.prepareCall("select *from archivos");
			 ResultSet resultado = st.executeQuery();
			 while (resultado.next()) {
				 String nombre = resultado.getString("nombreArchivo");
				 lista.add(nombre);
				 
				 
			 }
			
		} catch (Exception e) {
			System.out.println(e);
		}
		 
		
		return lista;
	}
	

	public void guardararchivo(String nombre) {
		
		try {
			
			PreparedStatement stm;
			String consulta = "insert into archivos(nombreArchivo) value (?)";
		stm = con.retornarConexion().prepareStatement(consulta);
		stm.setString(1, nombre);
		stm.execute();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
