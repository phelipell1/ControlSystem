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
@Table(name = "lojas")
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoja;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
	private Endereco idEndereco;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@Column(name = "cnpj", nullable = false, length = 18)
	private String cnpj;
	
	@Column(name = "inscEstadual", nullable = true, length = 25)
	private String inscEstadual;
	
	@Column(name = "nomeFantasia", nullable = false, length = 255)
	private String nomeFantasia;
	
	public Long getIdLoja() {
		return idLoja;
	}
	public void setIdLoja(Long idLoja) {
		this.idLoja = idLoja;
	}
	public Endereco getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Endereco idEndereco) {
		this.idEndereco = idEndereco;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscEstadual() {
		return inscEstadual;
	}
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
