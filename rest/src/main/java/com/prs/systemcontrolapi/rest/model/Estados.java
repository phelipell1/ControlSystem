package com.prs.systemcontrolapi.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Estados")
public class Estados {
	
	private long id_estado;
	private String nome_estado;
	private String sigla_uf;
	@OneToOne(mappedBy = "Cidades")
	private Cidades cidades;
	
	public Estados() {
		super();
	}

	public Estados(long id_estado, String nome_estado, String sigla_uf) {
		super();
		this.id_estado = id_estado;
		this.nome_estado = nome_estado;
		this.sigla_uf = sigla_uf;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId_estado() {
		return id_estado;
	}

	public void setId_estado(long id_estado) {
		this.id_estado = id_estado;
	}
	
	@Column(name = "nome_estado", nullable = false, length = 100)
	public String getNome_estado() {
		return nome_estado;
	}

	public void setNome_estado(String nome_estado) {
		this.nome_estado = nome_estado;
	}
	
	@Column(name = "sigla_uf", nullable = false, length = 2)
	public String getSigla_uf() {
		return sigla_uf;
	}

	public void setSigla_uf(String sigla_uf) {
		this.sigla_uf = sigla_uf;
	}

	@Override
	public String toString() {
		return "Estados [id_estado=" + id_estado + ", nome_estado=" + nome_estado + ", sigla_uf=" + sigla_uf + "]";
	}
	
} 
