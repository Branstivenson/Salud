package com.elsobreviviente.serviciosalud.dto;

import com.elsobreviviente.serviciosalud.entity.Servicio;
import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;
import com.elsobreviviente.serviciosalud.entity.Usuario;


public class ServicioPrestadoDto {
	
	private String idServicioPrestado;
	
	private String usuario;
	
	private String servicio;

	public ServicioPrestadoDto() {
		super();
	}



	public ServicioPrestadoDto(ServicioPrestado servicioPrestado) {
		super();
		this.idServicioPrestado = servicioPrestado.getIdServicioPrestado();
		this.usuario = servicioPrestado.getUsuario().toString();
		this.servicio = servicioPrestado.getServicio().toString();
	}



	public String getIdServicioPrestado() {
		return idServicioPrestado;
	}

	public void setIdServicioPrestado(String idServicioPrestado) {
		this.idServicioPrestado = idServicioPrestado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	
	
	
	

}
