package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.service.ClienteService;

@Controller
public class ClienteController {
	private ClienteService clienteService;
	@Autowired
	public ClienteController(ClienteService clienteService){
		super();
		this.clienteService = clienteService;
	}
	
	@RequestMapping("/cliente")
	public String exercicios(Model model){
		String nome = clienteService.buscarNome(1L);
		model.addAttribute("tipo", "Cliente - Nome");
		model.addAttribute("mensagem", nome);
		return "index2";
	}
}
