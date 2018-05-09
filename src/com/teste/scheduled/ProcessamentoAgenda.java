package com.teste.scheduled;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.teste.enumerador.StatusEnum;
import com.teste.model.Processamento;
import com.teste.service.VendaService;
import com.teste.util.FileUtil;

@Component
@EnableScheduling
public class ProcessamentoAgenda {
	
	private final long TEMPO = 10 * 1000;	
	
	@Autowired
	VendaService vendaService;
	
	@Scheduled(fixedDelay = TEMPO)
	public void gerarArquivo() {
		System.out.println("PROCESSANDO ARQUIVOS");
		List<Processamento> list = vendaService.obterListProcessamento();		
		String nomeArquivo = UUID.randomUUID().toString();
		
		if(list.size() > 0) {
			for(Processamento processamento : list) {
				processamento.setNomeArquivo(nomeArquivo);	
				processamento.setStatus(StatusEnum.OK);
				vendaService.atualizarProcessamento(processamento);	
			} 		
			new FileUtil().gerarArquivo(list, nomeArquivo);
		}	
		
	}

}
