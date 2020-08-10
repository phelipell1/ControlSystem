package com.prs.systemcontrolapi.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_RegistroContas")
public class RegistroContas {
	
	private long id_regContas;
	private String descricaoConta;
	private double valorTotal;
	private boolean parcelado;
	private int qtdeParcelas;
	private double valorParcela;
	private Date dataVencimento;
	private boolean quitado;
	private Lojas id_loja;
	
	public RegistroContas() {
		super();
	}

	public RegistroContas(long id_regContas, String descricaoConta, double valorTotal, boolean parcelado,
			int qtdeParcelas, double valorParcela, Date dataVencimento, boolean quitado, Lojas id_loja) {
		super();
		this.id_regContas = id_regContas;
		this.descricaoConta = descricaoConta;
		this.valorTotal = valorTotal;
		this.parcelado = parcelado;
		this.qtdeParcelas = qtdeParcelas;
		this.valorParcela = valorParcela;
		this.dataVencimento = dataVencimento;
		this.quitado = quitado;
		this.id_loja = id_loja;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId_regContas() {
		return id_regContas;
	}

	public void setId_regContas(long id_regContas) {
		this.id_regContas = id_regContas;
	}
	
	@Column(name = "descricaoConta", nullable = false, length = 50)
	public String getDescricaoConta() {
		return descricaoConta;
	}

	public void setDescricaoConta(String descricaoConta) {
		this.descricaoConta = descricaoConta;
	}
	
	@Column(name = "valorTotal", nullable = false)
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Column(name = "parcelado", nullable = false)
	public boolean isParcelado() {
		return parcelado;
	}

	public void setParcelado(boolean parcelado) {
		this.parcelado = parcelado;
	}
	
	@Column(name = "qtdeParcelas", nullable = true)
	public int getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(int qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}
	
	@Column(name = "valorParcela", nullable = true)
	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	@Column(name = "dataVencimento", nullable = false)
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@Column(name = "quitado", nullable = false)
	public boolean isQuitado() {
		return quitado;
	}

	public void setQuitado(boolean quitado) {
		this.quitado = quitado;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_loja", nullable = false)
	public Lojas getId_loja() {
		return id_loja;
	}

	public void setId_loja(Lojas id_loja) {
		this.id_loja = id_loja;
	}

	@Override
	public String toString() {
		return "RegistroContas [id_regContas=" + id_regContas + ", descricaoConta=" + descricaoConta + ", valorTotal="
				+ valorTotal + ", parcelado=" + parcelado + ", qtdeParcelas=" + qtdeParcelas + ", valorParcela="
				+ valorParcela + ", dataVencimento=" + dataVencimento + ", quitado=" + quitado + ", id_loja=" + id_loja
				+ "]";
	}
}
