package com.Rafa.negocio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.CallableStatement;
import com.Rafa.ConexionBD.ConexionBD;
import com.Rafa.Entidades.Loguin;
import com.Rafa.Entidades.Usuario;

public class clsLoguin {

	ConexionBD con = new ConexionBD();
	Connection coneccion = con.retornarConexion();
	public int tipo;

	public int acceso(Loguin log) {

		int result = 0;
		if (log.getUser().equals("Rafa") && log.getPass().equals("123")) {

			result = 1;
		}
		return result;
	}

	public boolean Login(Loguin log) {

		boolean resultado = false;
		ArrayList<Usuario> listaUsuariopass = new ArrayList<>();
		ArrayList<Usuario> ListaPass = new ArrayList<>();
		try {
			CallableStatement call = coneccion.prepareCall("Call SP_S_LOGIN(?,?)");
			call.setString("pUsuario", log.getUser());
			call.setString("pPass", log.getPass());
			ResultSet resul = call.executeQuery();
			while (resul.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuario(resul.getString("Usuario"));
				usuario.setPassWord(resul.getString("PassWord"));
				usuario.setIdUsuario(resul.getInt("idUsuario"));
			    usuario.setTipo(resul.getInt("tipoUsuario"));
				listaUsuariopass.add(usuario);
			}

			String usuBase = "";
			String passBase = "";

			for (var i : listaUsuariopass) {
				usuBase = i.getUsuario();
				passBase = i.getPassWord();
				tipo = i.getTipo();
			}
			CallableStatement call2 = coneccion.prepareCall("call SP_S_CRIP(?)");
			call2.setString("PcripPass", log.getPass());
			ResultSet rs2 = call2.executeQuery();
			while (rs2.next()) {
				Usuario escrip = new Usuario();
				escrip.setPassWord(rs2.getString("crip"));
				ListaPass.add(escrip);
			}
			String Passencriptada = null;
			for (var i : ListaPass) {
				Passencriptada = i.getPassWord();
				log.setPass(Passencriptada);
			}

			if (usuBase != null && passBase != null) {
				if (usuBase.equals(log.getUser()) && passBase.equals(log.getPass())) {
					resultado = true;
				} else {
					resultado = false;

				}
			}
			coneccion.close();

		} catch (Exception e) {
			System.out.println("Error" + e);
		}

		return resultado;

	}

}
