package com.prs.systemcontrolapi.rest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCidade")
	private long idCidade;
	
	@Column(name = "municipio", nullable = true, length = 100)
	private String municipio;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
	private Estado idEstado;
	
	public long getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(long idCidade) {
		this.idCidade = idCidade;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public Estado getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Estado idEstado) {
		this.idEstado = idEstado;
	}
}
