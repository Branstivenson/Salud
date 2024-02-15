package com.elsobreviviente.serviciosalud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elsobreviviente.serviciosalud.dto.ServicioDto2;
import com.elsobreviviente.serviciosalud.dto.ServicioPrestadoDto;
import com.elsobreviviente.serviciosalud.entity.Servicio;
import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;
import com.elsobreviviente.serviciosalud.repository.TipoServicioRepo;
import com.elsobreviviente.serviciosalud.service.ServicioPrestadoService;

@RestController
@RequestMapping("/api/servicioPrestado")
@CrossOrigin(origins = "http://localhost:4200/")
public class ServicioPrestadoController {

	@Autowired
	ServicioPrestadoService servicioPrestadoService;

	@GetMapping("/listaServicioPrestado")
	public ResponseEntity<List<ServicioPrestadoDto>> listaServicioPrestado() {
		if (servicioPrestadoService.listaServicioPrestadoDto().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(servicioPrestadoService.listaServicioPrestadoDto(), HttpStatus.OK);
		}
	}

	@PostMapping("/guardarServicioPrestado")
	public ResponseEntity<ServicioPrestadoDto> guardarServicioPrestado(
			@RequestBody ServicioPrestadoDto servicioPrestadoDto) {
		return new ResponseEntity<>(servicioPrestadoService.guardarServicioPrestadoDto(servicioPrestadoDto),
				HttpStatus.ACCEPTED);
	}

}
