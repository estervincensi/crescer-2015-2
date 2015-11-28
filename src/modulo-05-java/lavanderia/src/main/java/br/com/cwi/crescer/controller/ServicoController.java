package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.service.ServicoService;

@Controller
public class ServicoController {
private ServicoService servicoService;
	
	@Autowired
	public ServicoController(ServicoService servicoService){
		super();
		this.servicoService = servicoService;
	}
	
}
