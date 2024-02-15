package com.elsobreviviente.serviciosalud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elsobreviviente.serviciosalud.dto.ServicioDto2;
import com.elsobreviviente.serviciosalud.dto.ServicioPrestadoDto;
import com.elsobreviviente.serviciosalud.entity.Servicio;
import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;
import com.elsobreviviente.serviciosalud.entity.TipoServicio;
import com.elsobreviviente.serviciosalud.repository.ServicioPrestadoRepo;
import com.elsobreviviente.serviciosalud.repository.ServicioRepo;
import com.elsobreviviente.serviciosalud.repository.TipoServicioRepo;
import com.elsobreviviente.serviciosalud.repository.UsuarioRepository;

@Service
public class ServicioPrestadoService {

	@Autowired
	ServicioPrestadoRepo servicioPrestadoRepo;

	@Autowired
	TipoServicioRepo tipoServicioRepo;

	@Autowired
	ServicioRepo servicioRepo;

	@Autowired
	UsuarioRepository usuarioRepo;

	public List<ServicioPrestadoDto> listaServicioPrestadoDto() {

		List<ServicioPrestadoDto> listaServicioPrestadoDto = new ArrayList<>();
		List<ServicioPrestado> listaServicioPrestado = servicioPrestadoRepo.findAll();
		for (ServicioPrestado servicioPrestado : listaServicioPrestado) {
			try {
				ServicioPrestadoDto servicioPrestadoDto = new ServicioPrestadoDto(servicioPrestado);
				listaServicioPrestadoDto.add(servicioPrestadoDto);
			} catch (Exception e) {
				System.out.println("Error!!!" + e);
				// TODO: handle exception
			}
		}
		return listaServicioPrestadoDto;
	}

	public ServicioPrestadoDto guardarServicioPrestadoDto(ServicioPrestadoDto servicioPrestadoDto) {
		ServicioPrestado servicioPrestado = new ServicioPrestado();

		servicioPrestado.setServicio(servicioRepo.getReferenceById(servicioPrestadoDto.getServicio())); // Versión corta
		servicioPrestado.setUsuario(usuarioRepo.getReferenceById(servicioPrestadoDto.getUsuario())); // Versión corta

		servicioPrestadoRepo.save(servicioPrestado);

		return servicioPrestadoDto;
	}

}
