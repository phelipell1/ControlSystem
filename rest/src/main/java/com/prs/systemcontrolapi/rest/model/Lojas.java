package com.prs.systemcontrolapi.rest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Lojas")
public class Lojas {
	
	private long id_loja;
	private String nome_loja;
	private String endereco;
	private String numero;
	private String setorBairro;
	private String complementos;
	private boolean ehAtivo;
	@OneToMany(mappedBy = "LojasItens")
	private LojasItens loja;
	@OneToMany(mappedBy = "RegistroContas")
	private List<RegistroContas> regContas;
	@OneToOne(mappedBy = "VendasLojas")
	private VendasLojas lojasVendas;
	
	public Lojas() {
		super();
	}

	public Lojas(long id_loja, String nome_loja, String endereco, String numero, String setorBairro,
			String complementos, boolean ehAtivo) {
		super();
		this.id_loja = id_loja;
		this.nome_loja = nome_loja;
		this.endereco = endereco;
		this.numero = numero;
		this.setorBairro = setorBairro;
		this.complementos = complementos;
		this.ehAtivo = ehAtivo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_loja() {
		return id_loja;
	}

	public void setId_loja(long id_loja) {
		this.id_loja = id_loja;
	}
	
	@Column(name = "nome_loja", length = 20, nullable = false)
	public String getNome_loja() {
		return nome_loja;
	}

	public void setNome_loja(String nome_loja) {
		this.nome_loja = nome_loja;
	}
	
	@Column(name = "endereco", nullable = false, length = 150)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name = "numero", length = 4, nullable = false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Column(name = "setorBairro", nullable = false, length = 150)
	public String getSetorBairro() {
		return setorBairro;
	}

	public void setSetorBairro(String setorBairro) {
		this.setorBairro = setorBairro;
	}
	
	@Column(name = "complemento", nullable = false, length = 100 )
	public String getComplementos() {
		return complementos;
	}

	public void setComplementos(String complementos) {
		this.complementos = complementos;
	}
	
	@Column(name = "ehAtivo", nullable = false)
	public boolean isEhAtivo() {
		return ehAtivo;
	}

	public void setEhAtivo(boolean ehAtivo) {
		this.ehAtivo = ehAtivo;
	}

	@Override
	public String toString() {
		return "Lojas [id_loja=" + id_loja + ", nome_loja=" + nome_loja + ", endereco=" + endereco + ", numero="
				+ numero + ", setorBairro=" + setorBairro + ", complementos=" + complementos + ", ehAtivo=" + ehAtivo
				+ "]";
	}
}
