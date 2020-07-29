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

@Entity
@Table(name = "tbl_cidades")
public class Cidades {
	
	private long id_cidade;
	private String cid_nome;
	private Estados id_estado;
	
	public Cidades() {
		super();
	}

	public Cidades(long id_cidade, String cid_nome, Estados id_estado) {
		super();
		this.id_cidade = id_cidade;
		this.cid_nome = cid_nome;
		this.id_estado = id_estado;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(long id_cidade) {
		this.id_cidade = id_cidade;
	}
	
	@Column(name = "cid_nome", nullable = false, length = 100)
	public String getCid_nome() {
		return cid_nome;
	}

	public void setCid_nome(String cid_nome) {
		this.cid_nome = cid_nome;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
	public Estados getId_estado() {
		return id_estado;
	}

	public void setId_estado(Estados id_estado) {
		this.id_estado = id_estado;
	}

	@Override
	public String toString() {
		return "Cidades [id_cidade=" + id_cidade + ", cid_nome=" + cid_nome + ", id_estado=" + id_estado + "]";
	}
	
}
