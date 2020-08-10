package com.prs.systemcontrolapi.rest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_processo")
public class Processo {
	
	private long id_processo;
	private String referencia;
	private String descricao;
	private int qtde;
	private String UM;
	private double custo_unitario;
	private double custo_producao;
	private double valor_pago;
	private List<Costureiras> costureiras;
	private List<FichaDescritiva> fichaDescritivas;
	
	
	public Processo() {
		super();
	}

	public Processo(long id_processo, String referencia, String descricao, int qtde, String uM, double custo_unitario,
			double custo_producao, double valor_pago) {
		super();
		this.id_processo = id_processo;
		this.referencia = referencia;
		this.descricao = descricao;
		this.qtde = qtde;
		this.UM = uM;
		this.custo_unitario = custo_unitario;
		this.custo_producao = custo_producao;
		this.valor_pago = valor_pago;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId_processo() {
		return id_processo;
	}

	public void setId_processo(long id_processo) {
		this.id_processo = id_processo;
	}
	
	@Column(name = "referencia", nullable = false, length = 10)
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	@Column(name = "descricao", nullable = false, length = 200)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name = "qtde", nullable = false, length = 10)
	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
	@Column(name = "UM", nullable = false, length = 20)
	public String getUM() {
		return UM;
	}

	public void setUM(String uM) {
		UM = uM;
	}
	
	@Column(name = "custo_unitario", nullable = false)
	public double getCusto_unitario() {
		return custo_unitario;
	}

	public void setCusto_unitario(double custo_unitario) {
		this.custo_unitario = custo_unitario;
	}
	
	@Column(name = "custo_producao", nullable = false)
	public double getCusto_producao() {
		return custo_producao;
	}

	public void setCusto_producao(double custo_producao) {
		this.custo_producao = custo_producao;
	}
	
	@Column(name = "valor_pago", nullable = false)
	public double getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(double valor_pago) {
		this.valor_pago = valor_pago;
	}
	

    @ManyToMany
    @JoinTable(
    name = "tbl_processos_costureiras", 
    joinColumns = @JoinColumn(name = "id_costureira"), 
    inverseJoinColumns = @JoinColumn(name = "id_processo"))
	public List<Costureiras> getCostureiras() {
		return costureiras;
	}

	public void setCostureiras(List<Costureiras> costureiras) {
		this.costureiras = costureiras;
	}
	
	@ManyToMany
	@JoinTable(name = "tbl_processos_fichadescritiva",
	joinColumns = @JoinColumn(name = "id_fichaDesc"),
	inverseJoinColumns = @JoinColumn(name = "id_processo"))
	public List<FichaDescritiva> getFichaDescritivas() {
		return fichaDescritivas;
	}

	public void setFichaDescritivas(List<FichaDescritiva> fichaDescritivas) {
		this.fichaDescritivas = fichaDescritivas;
	}

	@Override
	public String toString() {
		return "Processo [id_processo=" + id_processo + ", referencia=" + referencia + ", descricao=" + descricao
				+ ", qtde=" + qtde + ", UM=" + UM + ", custo_unitario=" + custo_unitario + ", custo_producao="
				+ custo_producao + ", valor_pago=" + valor_pago + "]";
	}
	
}
