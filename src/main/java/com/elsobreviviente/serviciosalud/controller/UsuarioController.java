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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsobreviviente.serviciosalud.dto.UsuarioDto;
import com.elsobreviviente.serviciosalud.entity.Usuario;
import com.elsobreviviente.serviciosalud.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	


	
	@PostMapping("/almacenarUsuarioDto")
	public ResponseEntity<UsuarioDto> almacenarUsuarioDto (@RequestBody UsuarioDto usuarioDto) {
		return new ResponseEntity<>(usuarioService.almacenarUsuarioDtoV1(usuarioDto),HttpStatus.ACCEPTED);
	}
	
	
	
	
}
