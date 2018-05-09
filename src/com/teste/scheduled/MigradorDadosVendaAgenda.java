package com.teste.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.teste.enumerador.StatusEnum;
import com.teste.model.Processamento;
import com.teste.model.Venda;
import com.teste.service.VendaService;


@Component
@EnableScheduling
public class MigradorDadosVendaAgenda {
	
	 private final long TEMPO = 10 * 1000;
	 
	 @Autowired
	 VendaService vendaService;
	
	 @Scheduled(fixedDelay = TEMPO)
	 public void migrar() {
	    System.out.println("MIGRANDO DADOS");
	    Venda venda = vendaService.obterVendaPendente();
	    if(venda != null) {
	    	Processamento processamento = new Processamento();
	 	    processamento.setData(venda.getData());
	 	    processamento.setLoja(venda.getLoja());
	 	    processamento.setPdv(venda.getPdv());
	 	    processamento.setStatus(StatusEnum.PENDENTE);	 	    
	 	    vendaService.salvarVProcessamento(processamento);
	 	    venda.setStatus(StatusEnum.OK);
	 	    this.vendaService.atualizarVenda(venda);
	    }
	   
	 }

}
