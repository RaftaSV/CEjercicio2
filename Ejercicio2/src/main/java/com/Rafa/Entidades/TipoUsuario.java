package com.Rafa.Entidades;

import lombok.Data;

@Data
public class TipoUsuario {
    private int Id;
    private String TipoUsuario;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
}