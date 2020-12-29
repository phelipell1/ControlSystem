package com.prs.systemcontrolapi.rest.model;

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
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEndereco")
	private long idEndereco;
	
	@Column(name = "logradouro", nullable = false, length = 255)
	private String logradouro;
	
	@Column(name = "numero", nullable = true, length = 4)
	private int numero;
	
	@Column(name = "complemento", nullable = true, length = 255)
	private String Complemento;
	
	@Column(name = "setor_bairro", nullable = false, length = 150)
	private String setor_bairro;
	
	@Column(name = "cep", nullable = true, length = 8)
	private String cep;
	
	@OneToOne
	@JoinColumn(name = "idCidade", referencedColumnName = "idCidade")
	private Cidade idCidade;
	
	public long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return Complemento;
	}
	public void setComplemento(String complemento) {
		Complemento = complemento;
	}
	public String getSetor_bairro() {
		return setor_bairro;
	}
	public void setSetor_bairro(String setor_bairro) {
		this.setor_bairro = setor_bairro;
	}
	public Cidade getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Cidade idCidade) {
		this.idCidade = idCidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
