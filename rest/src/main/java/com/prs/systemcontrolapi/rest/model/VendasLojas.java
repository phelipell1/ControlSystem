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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.prs.systemcontrolapi.rest.Enums.TipoPagamento;

@Entity
@Table(name = "tbl_VendasLoja")
public class VendasLojas {
	
	private long id_vendaLoja;
	private Usuario_model id_usuario;
	private Lojas id_loja;
	private Date dataVenda;
	private List<LojasItens> listItensloja;
	private double valorTotal;
	private double valorDesconto;
	private TipoPagamento tipoPagamento;
	private boolean parcelado;
	private int totalParcelas;
	
	public VendasLojas() {
		super();
	}

	public VendasLojas(long id_vendaLoja, Usuario_model id_usuario, Lojas id_loja, Date dataVenda,
			List<LojasItens> listItensloja, double valorTotal, double valorDesconto, TipoPagamento tipoPagamento,
			boolean parcelado, int totalParcelas) {
		super();
		this.id_vendaLoja = id_vendaLoja;
		this.id_usuario = id_usuario;
		this.id_loja = id_loja;
		this.dataVenda = dataVenda;
		this.listItensloja = listItensloja;
		this.valorTotal = valorTotal;
		this.valorDesconto = valorDesconto;
		this.tipoPagamento = tipoPagamento;
		this.parcelado = parcelado;
		this.totalParcelas = totalParcelas;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_vendaLoja() {
		return id_vendaLoja;
	}

	public void setId_vendaLoja(long id_vendaLoja) {
		this.id_vendaLoja = id_vendaLoja;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	public Usuario_model getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario_model id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_loja", referencedColumnName = "id_loja")
	public Lojas getId_loja() {
		return id_loja;
	}

	public void setId_loja(Lojas id_loja) {
		this.id_loja = id_loja;
	}
	
	@Column(name = "dataVendas", nullable = false)
	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	@ManyToMany
	@JoinTable(name = "vendas_produtos",  joinColumns = @JoinColumn(name = "id_vendaLoja"), 
	inverseJoinColumns = @JoinColumn(name = "id_itensLoja"))
	public List<LojasItens> getListItensloja() {
		return listItensloja;
	}

	public void setListItensloja(List<LojasItens> listItensloja) {
		this.listItensloja = listItensloja;
	}
	
	@Column(name = "valorTotal", nullable = false)
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Column(name = "valorDesconto", nullable = true)
	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
	@Column(name = "tipoPagamento", nullable = false)
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	@Column(name = "parcelado", nullable = false)
	public boolean isParcelado() {
		return parcelado;
	}

	public void setParcelado(boolean parcelado) {
		this.parcelado = parcelado;
	}
	
	@Column(name = "totalParcelas", nullable = true)
	public int getTotalParcelas() {
		return totalParcelas;
	}

	public void setTotalParcelas(int totalParcelas) {
		this.totalParcelas = totalParcelas;
	}

	@Override
	public String toString() {
		return "VendasLojas [id_vendaLoja=" + id_vendaLoja + ", id_usuario=" + id_usuario + ", id_loja=" + id_loja
				+ ", dataVenda=" + dataVenda + ", listItensloja=" + listItensloja + ", valorTotal=" + valorTotal
				+ ", valorDesconto=" + valorDesconto + ", tipoPagamento=" + tipoPagamento + ", parcelado=" + parcelado
				+ ", totalParcelas=" + totalParcelas + "]";
	}
}
