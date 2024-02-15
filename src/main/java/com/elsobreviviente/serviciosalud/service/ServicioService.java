package com.elsobreviviente.serviciosalud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elsobreviviente.serviciosalud.dto.ServicioDto;
import com.elsobreviviente.serviciosalud.dto.ServicioDto2;
import com.elsobreviviente.serviciosalud.dto.ServicioDtoId;

import com.elsobreviviente.serviciosalud.entity.Servicio;
import com.elsobreviviente.serviciosalud.entity.TipoServicio;
import com.elsobreviviente.serviciosalud.repository.ServicioPrestadoRepo;
import com.elsobreviviente.serviciosalud.repository.ServicioRepo;
import com.elsobreviviente.serviciosalud.repository.TipoServicioRepo;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Service
public class ServicioService {

	@Autowired
	ServicioRepo servicioRepo;

	@Autowired
	TipoServicioRepo tipoServicioRepo;

	public List<ServicioDto2> listaServicioDto2() {

		List<ServicioDto2> listaServicioDto2 = new ArrayList<>();
		List<Servicio> listaServicio = servicioRepo.findAll();
		for (Servicio servicio : listaServicio) {
			try {
				if (!servicio.isDescontinuado()) {
					ServicioDto2 servicioDto2 = new ServicioDto2(servicio);
					listaServicioDto2.add(servicioDto2);
				}
			} catch (Exception e) {
				System.out.println("Error!!!" + e);
				// TODO: handle exception
			}
		}
		return listaServicioDto2;
	}

	public List<ServicioDto2> listarPorNombre(String cadena) {
		List<ServicioDto2> listaServicioDto2 = new ArrayList<>();
		List<Servicio> listaServicio = servicioRepo.findByNombreServicioContainingIgnoreCase(cadena);
		for (Servicio servicio : listaServicio) {
			try {
				if (!servicio.isDescontinuado()) {
					ServicioDto2 servicioDto2 = new ServicioDto2(servicio);
					listaServicioDto2.add(servicioDto2);
				}
			} catch (Exception e) {
				System.out.println("Error!!!" + e);
				// TODO: handle exception
			}
		}
		return listaServicioDto2;
	}

	public ServicioDto2 guardarServicioDto2(ServicioDto2 servicioDto2) {
		Servicio servicio = new Servicio();
		servicio.setCodigoServicio(servicioDto2.getCodigoServicio());
		servicio.setNombreServicio(servicioDto2.getNombreServicio());
		servicio.setTipoServicio(tipoServicioRepo.getReferenceById(servicioDto2.getCodigoTipoServicio()));
		servicioRepo.save(servicio);

		return servicioDto2;
	}

	public ServicioDto2 actualizarServicioDto2(ServicioDto2 servicioDto2) {
		Servicio servicio = servicioRepo.getReferenceById(servicioDto2.getIdCodigoServicio());
		servicio.setCodigoServicio(servicioDto2.getCodigoServicio());
		servicio.setNombreServicio(servicioDto2.getNombreServicio());
		String codigoTipoServicio = servicioDto2.getCodigoTipoServicio();
		TipoServicio tipoServicio = tipoServicioRepo.getReferenceById(codigoTipoServicio);
		servicio.setTipoServicio(tipoServicio);

		servicioRepo.save(servicio);
		return servicioDto2;
	}

	public ResponseEntity<Servicio> eliminarPorId(String id) {
		if (servicioRepo.findByIdCodigoServicio(id) != null) {
			Optional<Servicio> optionalservicio = servicioRepo.findById(id);

			Servicio servicio = optionalservicio.get();
			servicio.setDescontinuado(true);

			servicioRepo.save(servicio);
			return new ResponseEntity<>(HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
