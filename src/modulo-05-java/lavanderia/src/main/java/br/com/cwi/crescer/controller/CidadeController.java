package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.service.CidadeService;

@Controller
public class CidadeController {
	private CidadeService cidadeService;
	
	@Autowired
	public CidadeController(CidadeService cidadeService){
		super();
		this.cidadeService = cidadeService;
	}
	
	@RequestMapping("/cidade")
	public String exercicios(Model model){
		String nome = cidadeService.buscarNome(1L);
		model.addAttribute("tipo", "Cidade - Nome");
		model.addAttribute("mensagem", nome);
		return "index2";
	}
}
