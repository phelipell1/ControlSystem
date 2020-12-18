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

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduto")
	private Long idProduto;
	
	@Column(name = "codProduto", nullable = false, length = 10)
	private String codProduto;
	
	@Column(name = "descricaoProduto", nullable = false, length = 255)
	private String descricaoProduto;
	
	@Column(name = "quantidade", nullable = false, length = 4)
	private int quantidade;
	
	@Column(name = "nomeProduto", nullable = false, length = 25)
	private String nomeProduto;
	
	@Column(name = "dateCadastro", nullable = false)
	private Date dateCadastro;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
	private Usuario idUsuario;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idLoja", referencedColumnName = "idLoja")
	private Loja idLoja;
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Date getDateCadastro() {
		return dateCadastro;
	}
	public void setDateCadastro(Date dateCadastro) {
		this.dateCadastro = dateCadastro;
	}
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Loja getIdLoja() {
		return idLoja;
	}
	public void setIdLoja(Loja idLoja) {
		this.idLoja = idLoja;
	}
}
