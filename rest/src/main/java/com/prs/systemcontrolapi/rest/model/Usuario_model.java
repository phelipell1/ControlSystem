package com.prs.systemcontrolapi.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.prs.systemcontrolapi.rest.Enums.Cargo;
import com.prs.systemcontrolapi.rest.Enums.Perfil;

@Entity
@Table(name = "tbl_usuarios")
public class Usuario_model {
	
	private long id_usuario;
	private String nome_completo;
	private boolean ehAtivo;
	private Date dataCadastro;
	private String email;
	private Cargo cargo;
	private Perfil perfil;
	private Logins_model id_login;
	@OneToOne(mappedBy = "Atividades")
	private Usuario_model usario;
	@OneToOne(mappedBy = "ProdutosGeral")
	private ProdutosGeral produtos;
	@OneToOne(mappedBy = "tbl_LojasItens")
	private LojasItens lojaIntns;
	@OneToOne(mappedBy = "VendasLoja")
	private VendasLojas vendasLoja;
	
	public Usuario_model() {
		super();
	}

	public Usuario_model(long id_usuario, String nome_completo, boolean ehAtivo, Date dataCadastro, String email,
			Cargo cargo, Perfil perfil, Logins_model id_login) {
		super();
		this.id_usuario = id_usuario;
		this.nome_completo = nome_completo;
		this.ehAtivo = ehAtivo;
		this.dataCadastro = dataCadastro;
		this.email = email;
		this.cargo = cargo;
		this.perfil = perfil;
		this.id_login = id_login;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	@Column(name = "nome_completo", length = 50, nullable = false)
	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
	
	@Column(name = "ehAtivo", nullable = false)
	public boolean isEhAtivo() {
		return ehAtivo;
	}

	public void setEhAtivo(boolean ehAtivo) {
		this.ehAtivo = ehAtivo;
	}
	
	@Column(name = "dataCadastro", nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "Cargo", nullable = false)
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	@Column(name = "perfil", nullable = false)
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	@OneToOne
    @JoinColumn(name = "id_login", referencedColumnName = "id_login")
	public Logins_model getId_login() {
		return id_login;
	}

	public void setId_login(Logins_model id_login) {
		this.id_login = id_login;
	}

	@Override
	public String toString() {
		return "Usuario_model [id_usuario=" + id_usuario + ", nome_completo=" + nome_completo + ", ehAtivo=" + ehAtivo
				+ ", dataCadastro=" + dataCadastro + ", email=" + email + ", cargo=" + cargo + ", perfil=" + perfil
				+ ", id_login=" + id_login + "]";
	}
}
