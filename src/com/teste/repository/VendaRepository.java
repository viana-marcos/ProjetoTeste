package com.teste.repository;

import java.util.List;

import com.teste.model.Processamento;
import com.teste.model.Venda;

public interface VendaRepository {	
	Venda salvarVenda(Venda venda);
	Venda obterVendaPendente();
	void atualizarVenda(Venda venda);
	Processamento salvarVProcessamento(Processamento processamento);
	void atualizarProcessamento(Processamento processamento);
	List<Processamento> obterListProcessamentoPendente();
	List<Processamento> obterListProcessamento();
}
