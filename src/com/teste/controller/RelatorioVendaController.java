package com.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teste.model.Processamento;
import com.teste.service.VendaService;

@Controller
public class RelatorioVendaController {
	
	@Autowired
	VendaService vendaService;
	
	@RequestMapping("/relatorio")
    public String index(Model model) {
        System.out.println("Entrando na casadocodigo");
        List<Processamento> list = this.vendaService.obterListProcessamento();
        model.addAttribute("processamentos", list);
        return "relatorio";
    }

}
