package com.elsobreviviente.serviciosalud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;

@Repository
public interface ServicioPrestadoRepo extends JpaRepository<ServicioPrestado, String>{
	

}
