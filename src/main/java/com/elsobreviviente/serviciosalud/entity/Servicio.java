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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table (name = "servicio")
public class Servicio {

	@Id
	@Column (name = "id_codigo_servicio")
	private String idCodigoServicio=UUID.randomUUID().toString();
	@Column (name = "codigo_servicio")
	private String codigoServicio;
	@Column (name = "nombre_servicio")
	private String nombreServicio;
	
	private boolean descontinuado;
	
	@ManyToOne
	@JoinColumn (name = "codigo_tipo_servicio", referencedColumnName = "codigo_tipo_servicio")
	private TipoServicio tipoServicio;
	
	@OneToMany (mappedBy = "servicio")
	private List<ServicioPrestado> servicioPrestadoList = new ArrayList<>();
	
	@PrePersist
	public void Descontinuado() {
		this.descontinuado=false;
	}
	
	public Servicio() {

	}
	
	

	public boolean isDescontinuado() {
		return descontinuado;
	}



	public void setDescontinuado(boolean descontinuado) {
		this.descontinuado = descontinuado;
	}



	public String getIdCodigoServicio() {
		return idCodigoServicio;
	}

	public void setIdCodigoServicio(String idCodigoServicio) {
		this.idCodigoServicio = idCodigoServicio;
	}

	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public List<ServicioPrestado> getServicioPrestadoList() {
		return servicioPrestadoList;
	}

	public void setservicioPrestadoList(List<ServicioPrestado> servicioPrestadoList) {
		this.servicioPrestadoList = servicioPrestadoList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCodigoServicio, codigoServicio, nombreServicio, tipoServicio, servicioPrestadoList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return Objects.equals(codigoServicio, other.codigoServicio)
				&& Objects.equals(idCodigoServicio, other.idCodigoServicio)
				&& Objects.equals(servicioPrestadoList, other.servicioPrestadoList)
				&& Objects.equals(nombreServicio, other.nombreServicio)
				&& Objects.equals(tipoServicio, other.tipoServicio);
	}
	
	@Override
	public String toString() {
		return nombreServicio.toString();
	}
	
	
	
}
