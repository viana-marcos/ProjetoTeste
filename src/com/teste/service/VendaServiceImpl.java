package com.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.model.Processamento;
import com.teste.model.Venda;
import com.teste.repository.VendaRepository;

@Transactional
@Service
public class VendaServiceImpl implements VendaService {	
	@Autowired
	VendaRepository vendaRepository;

	@Override
	public Venda salvar(Venda venda) {		
		return this.vendaRepository.salvarVenda(venda);
	}

	@Override
	public Venda obterVendaPendente() {		
		return this.vendaRepository.obterVendaPendente();
	}

	@Override
	public void atualizarVenda(Venda venda) {
		this.vendaRepository.atualizarVenda(venda);
		
	}

	@Override
	public Processamento salvarVProcessamento(Processamento processamento) {		
		return this.vendaRepository.salvarVProcessamento(processamento);
	}

	@Override
	public void atualizarProcessamento(Processamento processamento) {
		this.vendaRepository.atualizarProcessamento(processamento);		
	}

	@Override
	public List<Processamento> obterListProcessamento() {		
		return this.vendaRepository.obterListProcessamento();
	}

	@Override
	public List<Processamento> obterListProcessamentoPendente() {		
		return this.vendaRepository.obterListProcessamentoPendente();
	}

}
