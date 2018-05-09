package com.teste.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.teste.enumerador.StatusEnum;
import com.teste.model.Processamento;
import com.teste.model.Venda;


@Repository
public class VendaRepositoryImpl implements VendaRepository {
	
	@PersistenceContext
	public EntityManager entityManager;
	
	public Venda salvarVenda(Venda venda) {
		this.entityManager.persist(venda);
		return venda;
	}

	@Override
	public Venda obterVendaPendente() {
		Venda venda = null;
		@SuppressWarnings("unchecked")
		List<Venda> list = (List<Venda>)entityManager.createQuery("SELECT v FROM Venda v WHERE v.status=:status")
                .setParameter("status", StatusEnum.PENDENTE)
                .setMaxResults(10)
                .getResultList(); 
		if(list != null && list.size() > 0)
			venda = list.get(0);
		return venda;
	}
	
	@Override
	public List<Processamento> obterListProcessamento() {
		 @SuppressWarnings("unchecked")
		List<Processamento> list = (List<Processamento>)entityManager.createQuery("SELECT p FROM Processamento p")	                               
	                .getResultList(); 
		 return list;
	}

	@Override
	public void atualizarVenda(Venda venda) {
		this.entityManager.merge(venda);		
	}

	@Override
	public Processamento salvarVProcessamento(Processamento processamento) {		
		return this.entityManager.merge(processamento);
	}

	@Override
	public List<Processamento> obterListProcessamentoPendente() {		
		 @SuppressWarnings({"unchecked" })	    
		 List<Processamento> list = (List<Processamento>)entityManager.createQuery("SELECT p FROM Processamento p WHERE p.status=:status")
	                .setParameter("status", StatusEnum.PENDENTE)               
	                .getResultList(); 
	     return list;
	}

	@Override
	public void atualizarProcessamento(Processamento processamento) {
		this.entityManager.merge(processamento);		
	}	

}
