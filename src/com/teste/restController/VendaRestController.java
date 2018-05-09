package com.teste.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teste.enumerador.StatusEnum;
import com.teste.model.Venda;
import com.teste.service.VendaService;

@RestController
public class VendaRestController {
	
	@Autowired
	VendaService vendaService;
	
	@RequestMapping(value = "/venda/novo", method = RequestMethod.POST)
	public ResponseEntity<Venda> save(@RequestBody Venda venda) {
		
		venda.setStatus(StatusEnum.PENDENTE);
		this.vendaService.salvar(venda);		
		return new ResponseEntity<Venda>(venda, HttpStatus.OK);
	}

}
