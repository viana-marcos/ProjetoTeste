package com.teste.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tb_item_venda")
public class ItemVenda implements Serializable {
	

	private static final long serialVersionUID = 7611829649881564518L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	private String produto;	
	@Column(name="preco_unitario")
    private Double precoUnitario;
	private Double desconto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_venda")
	private Venda venda;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
