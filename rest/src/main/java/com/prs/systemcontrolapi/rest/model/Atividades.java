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

@Entity
@Table(name = "tbl_Atividades")
public class Atividades {
	
	private long id_Atividade;
	private String tituloAtividade;
	private String DescricaoAtividade;
	private Date dataCriacao;
	private boolean fimAtividade;
	private Usuario_model id_usuario;
	
	public Atividades() {
		super();
	}

	public Atividades(long id_Atividade, String tituloAtividade, String descricaoAtividade, Date dataCriacao,
			boolean fimAtividade, Usuario_model id_usuario) {
		super();
		this.id_Atividade = id_Atividade;
		this.tituloAtividade = tituloAtividade;
		DescricaoAtividade = descricaoAtividade;
		this.dataCriacao = dataCriacao;
		this.fimAtividade = fimAtividade;
		this.id_usuario = id_usuario;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId_Atividade() {
		return id_Atividade;
	}

	public void setId_Atividade(long id_Atividade) {
		this.id_Atividade = id_Atividade;
	}
	
	@Column(name = "tituloAtividade", length = 20, nullable = false)
	public String getTituloAtividade() {
		return tituloAtividade;
	}

	public void setTituloAtividade(String tituloAtividade) {
		this.tituloAtividade = tituloAtividade;
	}
	
	@Column(name = "descricaoAtividade", length = 255, nullable = true)
	public String getDescricaoAtividade() {
		return DescricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		DescricaoAtividade = descricaoAtividade;
	}
	
	@Column(name = "dataCriacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Column(name = "fimAtividade", nullable = false)
	public boolean isFimAtividade() {
		return fimAtividade;
	}

	public void setFimAtividade(boolean fimAtividade) {
		this.fimAtividade = fimAtividade;
	}
	
	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	public Usuario_model getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario_model id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public String toString() {
		return "Atividades [id_Atividade=" + id_Atividade + ", tituloAtividade=" + tituloAtividade
				+ ", DescricaoAtividade=" + DescricaoAtividade + ", dataCriacao=" + dataCriacao + ", fimAtividade="
				+ fimAtividade + ", id_usuario=" + id_usuario + "]";
	}
	
}
