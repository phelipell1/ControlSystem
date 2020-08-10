package com.prs.systemcontrolapi.rest.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Costureiras")
public class Costureiras {
	
	private long id_costureira;
	private String nome_completo;
	private String endereco;
	private String numero;
	private String complemento;
	private String setor_bairro;
	private boolean ehAtivo;
	private Date dataCadastro;
	private Cidades id_cidade;
	
	@ManyToMany(mappedBy = "ListProcessos")
	private List<Processo> processos;
	
	public Costureiras() {
		super();
	}

	public Costureiras(long id_costureira, String nome_completo, String endereco, String numero, String complemento,
			String setor_bairro, boolean ehAtivo, Date dataCadastro, Cidades id_cidade) {
		super();
		this.id_costureira = id_costureira;
		this.nome_completo = nome_completo;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.setor_bairro = setor_bairro;
		this.ehAtivo = ehAtivo;
		this.dataCadastro = dataCadastro;
		this.id_cidade = id_cidade;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId_costureira() {
		return id_costureira;
	}

	public void setId_costureira(long id_costureira) {
		this.id_costureira = id_costureira;
	}
	
	@Column(name = "nome_completo", nullable = false, length = 100)
	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
	
	@Column(name = "endereco", nullable = false, length = 190)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name = "numero", nullable = true, length = 4)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Column(name = "complemento", nullable = false, length = 250)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@Column(name = "setor_bairro", nullable = false, length = 250)
	public String getSetor_bairro() {
		return setor_bairro;
	}

	public void setSetor_bairro(String setor_bairro) {
		this.setor_bairro = setor_bairro;
	}
	
	@Column(name = "EhAtivo", nullable = false)
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
	public Cidades getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(Cidades id_cidade) {
		this.id_cidade = id_cidade;
	}

	@Override
	public String toString() {
		return "Costureiras [id_costureira=" + id_costureira + ", nome_completo=" + nome_completo + ", endereco="
				+ endereco + ", numero=" + numero + ", complemento=" + complemento + ", setor_bairro=" + setor_bairro
				+ ", ehAtivo=" + ehAtivo + ", dataCadastro=" + dataCadastro + ", id_cidade=" + id_cidade + "]";
	}
}
