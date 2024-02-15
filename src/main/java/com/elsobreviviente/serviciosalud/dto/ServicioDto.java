package com.elsobreviviente.serviciosalud.dto;

import com.elsobreviviente.serviciosalud.entity.TipoServicio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioDto {

	private String nombreServicio;
	
	
	public ServicioDto() {
		
	}

	public ServicioDto(String nombreServicio) {

		this.nombreServicio = nombreServicio;

		
	}

}
