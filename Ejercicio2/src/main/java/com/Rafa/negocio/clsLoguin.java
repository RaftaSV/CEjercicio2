package com.Rafa.negocio;

import com.Rafa.Entidades.Loguin;

public class clsLoguin {

	public int acceso(Loguin log) {
		
	
		int result=0;
		if(log.getUser().equals("Rafa") && log.getPass().equals("123")) {
			
			result=1;
		}
		return result;
	}
	
	
}
