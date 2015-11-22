package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.service.MaterialService;

@Controller
public class MaterialController {
private MaterialService materialService;
	
	@Autowired
	public MaterialController(MaterialService materialService){
		super();
		this.materialService = materialService;
	}
	
	@RequestMapping("/material")
	public String exercicios(Model model){
		String nome = materialService.buscarDescricao(1L);
		model.addAttribute("tipo", "Material - Descrição");
		model.addAttribute("mensagem", nome);
		return "index2";
	}
}
