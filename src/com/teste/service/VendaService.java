package com.teste.service;

import java.util.List;

import com.teste.model.Processamento;
import com.teste.model.Venda;

public interface VendaService {	
	Venda salvar(Venda venda);
	Venda obterVendaPendente();
	void atualizarVenda(Venda venda);
	Processamento salvarVProcessamento(Processamento processamento);
	void atualizarProcessamento(Processamento processamento);
	List<Processamento> obterListProcessamento();
	List<Processamento> obterListProcessamentoPendente();
}
