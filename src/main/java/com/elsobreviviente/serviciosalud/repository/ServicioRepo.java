package com.elsobreviviente.serviciosalud.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.elsobreviviente.serviciosalud.entity.Servicio;


@Repository
public interface ServicioRepo extends JpaRepository<Servicio, String>{
	
	Servicio findByNombreServicio(String nombre);
	
	Servicio findByIdCodigoServicio(String id);
	
	List<Servicio> findByNombreServicioContainingIgnoreCase(String cadena);
	
}
