package com.prs.systemcontrolapi.rest.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Aviamentos")
public class Aviamentos {
	
	private long id_aviamento;
	private String referencia;
	private String descricao;
	private String nomeResponsavel;
	private int qtde;
	private String UM;
	private double custoUnitario;
	private double custoProducao;
	private FichaDescritiva id_fichaDescricao;
	
	public Aviamentos() {
		super();
	}

	public Aviamentos(long id_aviamento, String referencia, String descricao, String nomeResponsavel, int qtde,
			String uM, double custoUnitario, double custoProducao, FichaDescritiva id_fichaDescricao) {
		super();
		this.id_aviamento = id_aviamento;
		this.referencia = referencia;
		this.descricao = descricao;
		this.nomeResponsavel = nomeResponsavel;
		this.qtde = qtde;
		UM = uM;
		this.custoUnitario = custoUnitario;
		this.custoProducao = custoProducao;
		this.id_fichaDescricao = id_fichaDescricao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId_aviamento() {
		return id_aviamento;
	}
	public void setId_aviamento(long id_aviamento) {
		this.id_aviamento = id_aviamento;
	}
	
	@Column(name = "referencia", length = 10, nullable = false)
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	@Column(name = "descricao", nullable = false, length = 50)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name = "nomeResponsavel", nullable = false, length = 100)
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	
	@Column(name = "qtde", nullable = false, length = 4)
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
	@Column(name = "UM", nullable = false, length = 10)
	public String getUM() {
		return UM;
	}
	public void setUM(String uM) {
		UM = uM;
	}
	
	@Column(name = "custoUnitario", nullable = false)
	public double getCustoUnitario() {
		return custoUnitario;
	}
	
	public void setCustoUnitario(double custoUnitario) {
		this.custoUnitario = custoUnitario;
	}
	
	@Column(name = "custoProducao", nullable = false)
	public double getCustoProducao() {
		return custoProducao;
	}
	
	
	public void setCustoProducao(double custoProducao) {
		this.custoProducao = custoProducao;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_fichaDesc", nullable = false)
	public FichaDescritiva getId_fichaDescricao() {
		return id_fichaDescricao;
	}

	public void setId_fichaDescricao(FichaDescritiva id_fichaDescricao) {
		this.id_fichaDescricao = id_fichaDescricao;
	}



	@Override
	public String toString() {
		return "Aviamentos [id_aviamento=" + id_aviamento + ", referencia=" + referencia + ", descricao=" + descricao
				+ ", nomeResponsavel=" + nomeResponsavel + ", qtde=" + qtde + ", UM=" + UM + ", custoUnitario="
				+ custoUnitario + ", custoProducao=" + custoProducao + "]";
	}
	
	
}
