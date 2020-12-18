package com.prs.systemcontrolapi.rest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "listaProdutosCompra")
public class ListaProdutosCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRegistro")
	private long idRegistro;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idlista", referencedColumnName = "idProduto")
	private List<Produto> listaProduta;
	
	
	public long getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(long idRegistro) {
		this.idRegistro = idRegistro;
	}
	public List<Produto> getListaProduta() {
		return listaProduta;
	}
	public void setListaProduta(List<Produto> listaProduta) {
		this.listaProduta = listaProduta;
	}
	
	
	
}
