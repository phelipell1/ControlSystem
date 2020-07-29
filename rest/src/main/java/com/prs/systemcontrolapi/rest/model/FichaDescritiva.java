package com.prs.systemcontrolapi.rest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fichaDescritiva")
public class FichaDescritiva {
	
	private long id_fichaDesc;
	private String referencia;
	private String descricao;
	private String nomeResponsavel;
	private int qtde;
	private String UM;
	private double custoUnitario;
	private double custoProducao;
	@OneToMany(mappedBy = "fichaDescritiva")
	private List<Aviamentos> aviamentos;
	
	public FichaDescritiva() {
		super();
	}

	public FichaDescritiva(long id_fichaDesc, String referencia, String descricao, String nomeResponsavel, int qtde,
			String uM, double custoUnitario, double custoProducao, List<Aviamentos> aviamentos) {
		super();
		this.id_fichaDesc = id_fichaDesc;
		this.referencia = referencia;
		this.descricao = descricao;
		this.nomeResponsavel = nomeResponsavel;
		this.qtde = qtde;
		UM = uM;
		this.custoUnitario = custoUnitario;
		this.custoProducao = custoProducao;
		this.aviamentos = aviamentos;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_fichaDesc() {
		return id_fichaDesc;
	}

	public void setId_fichaDesc(long id_fichaDesc) {
		this.id_fichaDesc = id_fichaDesc;
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
	
	@Override
	public String toString() {
		return "FichaDescritiva [id_fichaDesc=" + id_fichaDesc + ", referencia=" + referencia + ", descricao="
				+ descricao + ", nomeResponsavel=" + nomeResponsavel + ", qtde=" + qtde + ", UM=" + UM
				+ ", custoUnitario=" + custoUnitario + ", custoProducao=" + custoProducao + ", aviamentos=" + aviamentos
				+ "]";
	}
}
