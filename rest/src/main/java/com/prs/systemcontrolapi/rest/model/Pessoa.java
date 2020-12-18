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


import com.prs.systemcontrolapi.rest.Enums.EstCivilEnum;
import com.prs.systemcontrolapi.rest.Enums.SexoEnum;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "idPessoa")
	private long idPessoa;
	
	@Column(name = "nomeCompleto", nullable = false, length = 255)
	private String nomeCompleto;
	
	@Column(name = "CPF", nullable = true, length = 14)
	private String CPF;
	
	@Column(name = "", nullable = false)
	private SexoEnum sexo;
	
	@Column(name = "estCivil", nullable = false)
	private EstCivilEnum estCivil;
	
	@Column(name = "dataNascimento", nullable = false)
	private Date dataNascimento;
	
	@Column(name = "email", nullable = true, length = 25)
	private String email;
	
	@Column(name = "numCelular", nullable = true, length = 14)
	private String numCelular;
	
	@Column(name = "numFixo", nullable = true, length = 13)
	private String numFixo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
	private Endereco idEndereco;
	
	public long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public SexoEnum getSexo() {
		return sexo;
	}
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	public EstCivilEnum getEstCivil() {
		return estCivil;
	}
	public void setEstCivil(EstCivilEnum estCivil) {
		this.estCivil = estCivil;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumCelular() {
		return numCelular;
	}
	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}
	public String getNumFixo() {
		return numFixo;
	}
	public void setNumFixo(String numFixo) {
		this.numFixo = numFixo;
	}
	public Endereco getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Endereco idEndereco) {
		this.idEndereco = idEndereco;
	}

}
