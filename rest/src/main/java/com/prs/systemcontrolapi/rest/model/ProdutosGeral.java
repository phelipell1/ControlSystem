package com.prs.systemcontrolapi.rest.model;

import java.util.Date;

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
@Table(name = "tbl_ProdutosGeral")
public class ProdutosGeral {
	
	private long id_estoque;
	private String descricao;
	private String codigo_barras;
	private String codigo_referencia;
	private String tamanho;
	private int qtde;
	private int qtdeMinima;
	private Date dataCadastro;
	private Usuario_model id_usuario;
	private double valor;
	
	@ManyToMany(mappedBy = "ListProdutos")
	private LojasItens lojasitens;
	
	public ProdutosGeral() {
		super();
	}

	public ProdutosGeral(long id_estoque, String descricao, String codigo_barras, String codigo_referencia,
			String tamanho, int qtde, int qtdeMinima, Date dataCadastro, Usuario_model id_usuario, double valor,
			LojasItens lojasitens) {
		super();
		this.id_estoque = id_estoque;
		this.descricao = descricao;
		this.codigo_barras = codigo_barras;
		this.codigo_referencia = codigo_referencia;
		this.tamanho = tamanho;
		this.qtde = qtde;
		this.qtdeMinima = qtdeMinima;
		this.dataCadastro = dataCadastro;
		this.id_usuario = id_usuario;
		this.valor = valor;
		this.lojasitens = lojasitens;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_estoque() {
		return id_estoque;
	}

	public void setId_estoque(long id_estoque) {
		this.id_estoque = id_estoque;
	}
	
	@Column(name = "descricao", length = 150, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name = "codigo_barras", nullable = false, length = 10)
	public String getCodigo_barras() {
		return codigo_barras;
	}

	public void setCodigo_barras(String codigo_barras) {
		this.codigo_barras = codigo_barras;
	}
	
	@Column(name = "codigo_referencia", nullable = false, length = 10)
	public String getCodigo_referencia() {
		return codigo_referencia;
	}

	public void setCodigo_referencia(String codigo_referencia) {
		this.codigo_referencia = codigo_referencia;
	}
	
	@Column(name = "tamanho", nullable = false, length = 3)
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	@Column(name = "qtde", nullable = false, length = 3)
	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
	@Column(name = "qtdeMinima", nullable = false, length = 3)
	public int getQtdeMinima() {
		return qtdeMinima;
	}

	public void setQtdeMinima(int qtdeMinima) {
		this.qtdeMinima = qtdeMinima;
	}
	
	@Column(name = "dataCadastro", nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	public Usuario_model getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario_model id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	@Column(name = "valor", nullable = false)
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "ProdutosGeral [id_estoque=" + id_estoque + ", descricao=" + descricao + ", codigo_barras="
				+ codigo_barras + ", codigo_referencia=" + codigo_referencia + ", tamanho=" + tamanho + ", qtde=" + qtde
				+ ", qtdeMinima=" + qtdeMinima + ", dataCadastro=" + dataCadastro + ", id_usuario=" + id_usuario
				+ ", valor=" + valor + "]";
	}

}
