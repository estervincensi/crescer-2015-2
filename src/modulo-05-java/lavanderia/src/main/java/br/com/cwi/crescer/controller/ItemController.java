package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.service.ItemService;

@Controller
public class ItemController {
private ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService){
		super();
		this.itemService = itemService;
	}
	
	@RequestMapping("/item")
	public String exercicios(Model model){
		String nome = itemService.buscarSituacao(1L);
		model.addAttribute("tipo", "Item - Situacao");
		model.addAttribute("mensagem", nome);
		return "index2";
	}
}
