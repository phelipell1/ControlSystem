package com.prs.systemcontrolapi.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Login")
public class Logins_model {

	private long id_login;
	private String login_name;
	private String password;
	private Date dataCadastro;
	private Date dataAlteracao;
	@OneToOne(mappedBy = "Usuario_model")
	private Usuario_model usario;
	
	public Logins_model() {
		super();
	}

	public Logins_model(long id_login, String login_name, String password, Date dataCadastro, Date dataAlteracao) {
		super();
		this.id_login = id_login;
		this.login_name = login_name;
		this.password = password;
		this.dataCadastro = dataCadastro;
		this.dataAlteracao = dataAlteracao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId_login() {
		return id_login;
	}

	public void setId_login(long id_login) {
		this.id_login = id_login;
	}
	
	@Column(name = "login_name", length =20, unique = true, nullable = false)
	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	
	@Column(name = "password", length = 15, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "dataCadastro", nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name = "dataAlteracao", nullable = true)
	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	public String toString() {
		return "Logins_model [id_login=" + id_login + ", login_name=" + login_name + ", password=" + password
				+ ", dataCadastro=" + dataCadastro + ", dataAlteracao=" + dataAlteracao + "]";
	}
	
}
