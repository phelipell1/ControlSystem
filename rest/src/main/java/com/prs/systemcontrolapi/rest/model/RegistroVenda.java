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

import com.prs.systemcontrolapi.rest.Enums.TipoPagamentoEnum;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registroVenda")
public class RegistroVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRegistro")
	private long idRegistro;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "listaProduto", referencedColumnName = "idRegistro")
	private ListaProdutosCompra listaProduto;
	
	@Column(name = "dataCompra", nullable = false)
	private Date dataCompra;
	
	@Column(name = "totalCompra", nullable = false)
	private Double totalCompra;
	
	@Column(name = "tipoPagamento", nullable = false)
	private TipoPagamentoEnum tipoPagamento;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
	private Usuario idUsuario;
	
	
	public long getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(long idRegistro) {
		this.idRegistro = idRegistro;
	}
	public ListaProdutosCompra getListaProduto() {
		return listaProduto;
	}
	public void setListaProduto(ListaProdutosCompra listaProduto) {
		this.listaProduto = listaProduto;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Double getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}
	public TipoPagamentoEnum getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
