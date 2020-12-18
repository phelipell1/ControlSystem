package com.prs.systemcontrolapi.rest.model;

import java.util.Date;

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

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "costureira")
public class Costureira {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCostureira")
	private Long idCostureira;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa idPessoa;
	
	@Column(name = "dateCadastro", nullable = false)
	private Date dateCadastro;
	
	public Long getIdCostureira() {
		return idCostureira;
	}
	public void setIdCostureira(Long idCostureira) {
		this.idCostureira = idCostureira;
	}
	public Pessoa getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}
	public Date getDateCadastro() {
		return dateCadastro;
	}
	public void setDateCadastro(Date dateCadastro) {
		this.dateCadastro = dateCadastro;
	}
}
