package com.elsobreviviente.serviciosalud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsobreviviente.serviciosalud.dto.UsuarioDto;
import com.elsobreviviente.serviciosalud.dto.UsuarioDtoId;
import com.elsobreviviente.serviciosalud.entity.Usuario;
import com.elsobreviviente.serviciosalud.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	public Usuario almacenarUsuario (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	

	public UsuarioDto almacenarUsuarioDtoV1 (UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setIdentificacion(usuarioDto.getIdentificacion());
		usuario.setNombreCompleto(usuarioDto.getNombreCompleto());
		usuarioRepository.save(usuario); // persistencia
		return usuarioDto;
	}
	

}
