package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.service.ProdutoService;

@Controller
public class ProdutoController {
private ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService){
		super();
		this.produtoService = produtoService;
	}
	
	@RequestMapping("/produto")
	public String exercicios(Model model){
		double nome = produtoService.buscarValor(1L);
		model.addAttribute("tipo", "Produto - Valor");
		model.addAttribute("mensagem", nome);
		return "index2";
	}
}
