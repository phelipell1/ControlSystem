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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_LojasItens")
public class LojasItens {
	
	private long id_itensLoja;
	private Date dataEntrada;
	private int qtdeEntrada;
	private Lojas id_loja;
	private Usuario_model id_usuario;
	private List<ProdutosGeral> listProdutos;
	@ManyToMany
	private List<VendasLojas> listVendas;
	
	public LojasItens() {
		super();
	}

	public LojasItens(long id_itensLoja, Date dataEntrada, int qtdeEntrada, Lojas id_loja, Usuario_model id_usuario,
			List<ProdutosGeral> listProdutos) {
		super();
		this.id_itensLoja = id_itensLoja;
		this.dataEntrada = dataEntrada;
		this.qtdeEntrada = qtdeEntrada;
		this.id_loja = id_loja;
		this.id_usuario = id_usuario;
		this.listProdutos = listProdutos;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_itensLoja() {
		return id_itensLoja;
	}

	public void setId_itensLoja(long id_itensLoja) {
		this.id_itensLoja = id_itensLoja;
	}
	
	@Column(name = "dataEntrada")
	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	@Column(name = "qtdeEntrada")
	public int getQtdeEntrada() {
		return qtdeEntrada;
	}

	public void setQtdeEntrada(int qtdeEntrada) {
		this.qtdeEntrada = qtdeEntrada;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_loja", nullable = false)
	public Lojas getId_loja() {
		return id_loja;
	}

	public void setId_loja(Lojas id_loja) {
		this.id_loja = id_loja;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	public Usuario_model getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario_model id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	@ManyToMany
	@JoinTable(name = "tbl_Produtos_itens", joinColumns = @JoinColumn(name = "id_lojaIntens"),
	inverseJoinColumns = @JoinColumn(name = "id_estoque"))
	public List<ProdutosGeral> getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(List<ProdutosGeral> listProdutos) {
		this.listProdutos = listProdutos;
	}

	@Override
	public String toString() {
		return "LojasItens [id_itensLoja=" + id_itensLoja + ", dataEntrada=" + dataEntrada + ", qtdeEntrada="
				+ qtdeEntrada + ", id_loja=" + id_loja + ", id_usuario=" + id_usuario + ", listProdutos=" + listProdutos
				+ "]";
	}
	
	
}
