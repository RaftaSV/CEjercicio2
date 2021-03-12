package com.Rafa.Entidades;

import lombok.Data;

@Data
	public class Usuario extends TipoUsuario{
	    private int idUsuario;
	    private String Usuario;
	    private String PassWord;
		public int getIdUsuario() {
			return idUsuario;
		}
		
		public void setIdUsuario(int id) {
			this.idUsuario = id;
		}
		public String getUsuario() {
			return Usuario;
		}
		public void setUsuario(String usuario) {
			this.Usuario = usuario;
		}
		public String getPassWord() {
			return PassWord;
		}
		public void setPassWord(String passWord) {
			PassWord = passWord;
		}
	   

	    
	

}
