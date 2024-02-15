package com.elsobreviviente.serviciosalud.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "servicio_prestado")
public class ServicioPrestado {
	
	@Id
	@Column (name = "id_servicio")
	private String idServicioPrestado=UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn (name = "identificacion", referencedColumnName = "identificacion")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn (name = "id_codigo_servicio", referencedColumnName = "id_codigo_servicio")
	private Servicio servicio;
	
	
	public ServicioPrestado() {
	
	}
	
	




	public String getIdServicioPrestado() {
		return idServicioPrestado;
	}


	public void setIdServicioPrestado(String idServicioPrestado) {
		this.idServicioPrestado = idServicioPrestado;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Servicio getServicio() {
		return servicio;
	}


	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idServicioPrestado, servicio, usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicioPrestado other = (ServicioPrestado) obj;
		return Objects.equals(idServicioPrestado, other.idServicioPrestado) 
				&& Objects.equals(servicio, other.servicio)
				&& Objects.equals(usuario, other.usuario);
	}
	
	

}
