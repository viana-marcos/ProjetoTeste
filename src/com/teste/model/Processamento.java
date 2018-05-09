package com.teste.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.teste.enumerador.StatusEnum;

@Entity
@Table(name="tb_processamento")
public class Processamento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date data;
	private String loja;
	private Integer pdv;
	@Enumerated(EnumType.STRING)
	private StatusEnum status;	
	@Column(name="nome_arquivo")
    private String nomeArquivo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getPdv() {
		return pdv;
	}
	public void setPdv(Integer pdv) {
		this.pdv = pdv;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public String getLoja() {
		return loja;
	}
	public void setLoja(String loja) {
		this.loja = loja;
	}
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}	

}
