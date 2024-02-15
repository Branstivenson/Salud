package com.elsobreviviente.serviciosalud.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elsobreviviente.serviciosalud.dto.ServicioDto;
import com.elsobreviviente.serviciosalud.dto.ServicioDto2;
import com.elsobreviviente.serviciosalud.dto.ServicioDtoId;

import com.elsobreviviente.serviciosalud.entity.Servicio;

import com.elsobreviviente.serviciosalud.service.ServicioService;



@RestController
@RequestMapping("/api/servicio")
@CrossOrigin(origins = "http://localhost:4200/")
public class ServicioController {
	
	@Autowired
	ServicioService servicioService;
	
	
	@GetMapping("/listaServicioDto2")
	public ResponseEntity<List<ServicioDto2>> listaServicioDto2(){
		if (servicioService.listaServicioDto2().isEmpty()){
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} else {
		return new ResponseEntity<>(servicioService.listaServicioDto2(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/listaPorNombre/{cadena}")
	public ResponseEntity<List<ServicioDto2>> listarPoNombre(@PathVariable ("cadena") String cadena){
		if (servicioService.listarPorNombre(cadena).isEmpty()){
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}else {
		return new ResponseEntity<>(servicioService.listarPorNombre(cadena),HttpStatus.OK);
		}
	}
	
	@PostMapping("/guardarServicioDto2")
	public ResponseEntity<ServicioDto2> guardarServicioDto2(@RequestBody ServicioDto2 servicioDto2) {
		return new ResponseEntity<>(servicioService.guardarServicioDto2(servicioDto2),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/actualizarServicioDto2")
	public ResponseEntity<ServicioDto2> actualizarDto2 (@RequestBody ServicioDto2 servicioDto2) {
		servicioService.actualizarServicioDto2(servicioDto2);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/eliminarServicio/{id}")
	public ResponseEntity<Servicio> eliminarPorId (@PathVariable("id") String id){
		servicioService.eliminarPorId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
